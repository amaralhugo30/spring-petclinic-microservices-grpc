package org.springframework.samples.petclinic.customers.grpc;

import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.OwnerServiceGrpc;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreateOwnerRequest;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreateOwnerResponse;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnerRequest;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnerResponse;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdateOwnerRequest;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdateOwnerResponse;
import org.springframework.samples.petclinic.customers.mapper.OwnerGrpcMapper;
import org.springframework.samples.petclinic.customers.model.Owner;
import org.springframework.samples.petclinic.customers.model.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService extends OwnerServiceGrpc.OwnerServiceImplBase {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public void createOwner(CreateOwnerRequest request, StreamObserver<CreateOwnerResponse> responseObserver) {
        try {
            Owner newOwner = ownerRepository.save(OwnerGrpcMapper.toDomain(new Owner(), request));
            CreateOwnerResponse response = CreateOwnerResponse.newBuilder().setOwner(OwnerGrpcMapper.fromDomain(newOwner)).setCreated(true).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception exception) {
            responseObserver.onError(Status.INTERNAL.withDescription("An expected has occurred. Please try again.").asRuntimeException());
        }
    }

    @Override
    public void getOwner(GetOwnerRequest request, StreamObserver<GetOwnerResponse> responseObserver) {
        try {
            Owner requestedOwner = ownerRepository.findById(request.getOwnerId()).orElseThrow(() -> new ResourceNotFoundException("Owner " + request.getOwnerId() + " not found"));
            GetOwnerResponse response = GetOwnerResponse.newBuilder().setOwner(OwnerGrpcMapper.fromDomain(requestedOwner)).setFound(true).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (ResourceNotFoundException exception) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(exception.getMessage()).asRuntimeException());
        } catch (Exception exception) {
            responseObserver.onError(Status.INTERNAL.withDescription("An expected has occurred. Please try again.").asRuntimeException());
        }
    }

    @Override
    public void listOwners(Empty request, StreamObserver<GetOwnersResponse> responseObserver) {
        try {
            List<Owner> owners = ownerRepository.findAll();
            GetOwnersResponse response = GetOwnersResponse.newBuilder().addAllOwners(owners.stream().map(owner -> OwnerGrpcMapper.fromDomain(owner)).toList()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception exception) {
            responseObserver.onError(Status.INTERNAL.withDescription("An expected has occurred. Please try again.").asRuntimeException());
        }
    }

    @Override
    public void updateOwner(UpdateOwnerRequest request, StreamObserver<UpdateOwnerResponse> responseObserver) {
        try {
            final Owner ownerModel = ownerRepository.findById(request.getOwnerId()).orElseThrow(() -> new ResourceNotFoundException("Owner " + request.getOwnerId() + " not found"));
            OwnerGrpcMapper.toDomain(ownerModel, request);
            ownerRepository.save(ownerModel);
            responseObserver.onNext(UpdateOwnerResponse.newBuilder().setUpdated(true).build());
            responseObserver.onCompleted();
        } catch (ResourceNotFoundException exception) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(exception.getMessage()).asRuntimeException());
        } catch (Exception exception) {
            responseObserver.onError(Status.INTERNAL.withDescription("An expected has occurred. Please try again.").asRuntimeException());
        }
    }
}

