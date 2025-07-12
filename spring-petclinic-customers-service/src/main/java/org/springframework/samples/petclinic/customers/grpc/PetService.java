package org.springframework.samples.petclinic.customers.grpc;

import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.PetServiceGrpc;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetRequest;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetRequest;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetResponse;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetTypesResponse;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetRequest;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetResponse;
import org.springframework.samples.petclinic.customers.mapper.PetGrpcMapper;
import org.springframework.samples.petclinic.customers.model.Owner;
import org.springframework.samples.petclinic.customers.model.OwnerRepository;
import org.springframework.samples.petclinic.customers.model.Pet;
import org.springframework.samples.petclinic.customers.model.PetRepository;
import org.springframework.samples.petclinic.customers.model.PetType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class PetService extends PetServiceGrpc.PetServiceImplBase {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private PetRepository petRepository;

    @Override
    public void createPet(CreatePetRequest request, StreamObserver<CreatePetResponse> responseObserver) {
        try {
            Owner owner = ownerRepository.findById(request.getOwnerId())
                .orElseThrow(() -> new ResourceNotFoundException("Owner " + request.getOwnerId() + " not found"));

            final Pet pet = new Pet();
            owner.addPet(pet);
            pet.setName(request.getName());
            pet.setBirthDate(parseBirthDate(request.getBirthDate()));

            petRepository.findPetTypeById(request.getTypeId())
                .ifPresent(pet::setType);
            petRepository.save(pet);
            CreatePetResponse response = CreatePetResponse.newBuilder().setPet(PetGrpcMapper.fromDomain(pet)).setCreated(true).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (ResourceNotFoundException exception) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(exception.getMessage()).asRuntimeException());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription("An unexpected error has occurred. Please try again.").asRuntimeException());
        }
    }

    @Override
    public void getPetTypes(Empty request, StreamObserver<GetPetTypesResponse> responseObserver) {
        List<PetType> petTypes = petRepository.findPetTypes();
        GetPetTypesResponse response = GetPetTypesResponse.newBuilder().addAllPetTypes(PetGrpcMapper.fromDomain(petTypes)).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updatePet(UpdatePetRequest request, StreamObserver<UpdatePetResponse> responseObserver) {
        try {
            Pet pet = findPetById(request.getPetId());
            pet.setName(request.getName());
            pet.setBirthDate(parseBirthDate(request.getBirthDate()));

            petRepository.findPetTypeById(request.getTypeId())
                .ifPresent(pet::setType);

            petRepository.save(pet);
            UpdatePetResponse response = UpdatePetResponse.newBuilder().setUpdated(true).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (ResourceNotFoundException exception) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(exception.getMessage()).asRuntimeException());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription("An unexpected error has occurred. Please try again.").asRuntimeException());
        }
    }

    @Override
    public void getPet(GetPetRequest request, StreamObserver<GetPetResponse> responseObserver) {
        try {
            Pet pet = findPetById(request.getPetId());
            GetPetResponse response = GetPetResponse.newBuilder().setPet(PetGrpcMapper.fromDomain(pet)).setFound(true).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (ResourceNotFoundException exception) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(exception.getMessage()).asRuntimeException());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription("An unexpected error has occurred. Please try again.").asRuntimeException());
        }
    }

    private Pet findPetById(int petId) {
        return petRepository.findById(petId)
            .orElseThrow(() -> new ResourceNotFoundException("Pet " + petId + " not found"));
    }

    private Date parseBirthDate(String dateString) {
        try {
            LocalDate localDate = LocalDate.parse(dateString);
            return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        } catch (Exception e) {
            throw e;
        }
    }
}
