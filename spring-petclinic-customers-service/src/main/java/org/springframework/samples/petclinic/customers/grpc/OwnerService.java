package org.springframework.samples.petclinic.customers.grpc;

import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.customers.grpc.gen.owner.*;
import org.springframework.samples.petclinic.customers.model.Owner;
import org.springframework.samples.petclinic.customers.model.OwnerRepository;
import org.springframework.samples.petclinic.customers.web.ResourceNotFoundException;
import org.springframework.samples.petclinic.customers.web.mapper.OwnerEntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService extends OwnerServiceGrpc.OwnerServiceImplBase {
    private static Log log = LogFactory.getLog(OwnerService.class);

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerEntityMapper ownerEntityMapper;


    @Override
    public void createOwner(OwnerRequest request, StreamObserver<OwnerResponse> responseObserver) {
        try {
            Owner newOwner = ownerRepository.save(ownerEntityMapper.map(new Owner(), request));
            org.springframework.samples.petclinic.customers.grpc.gen.owner.Owner grpcOwner = ownerEntityMapper.map(newOwner);
            OwnerResponse response = OwnerResponse.newBuilder().setOwner(grpcOwner).setFound(true).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception exception) {
            responseObserver.onError(Status.INTERNAL.withDescription("An expected has occurred. Please try again.").asRuntimeException());
        }
    }

    @Override
    public void getOwner(GetOwnerRequest request, StreamObserver<OwnerResponse> responseObserver) {
        try {
            Owner requestedOwner = ownerRepository.findById(request.getOwnerId()).orElseThrow(() -> new ResourceNotFoundException("Owner " + request.getOwnerId() + " not found"));
            org.springframework.samples.petclinic.customers.grpc.gen.owner.Owner grpcOwner = ownerEntityMapper.map(requestedOwner);
            OwnerResponse response = OwnerResponse.newBuilder().setOwner(grpcOwner).setFound(true).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (ResourceNotFoundException exception) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(exception.getMessage()).asRuntimeException());
        } catch (Exception exception) {
            responseObserver.onError(Status.INTERNAL.withDescription("An expected has occurred. Please try again.").asRuntimeException());
        }
    }

    @Override
    public void listOwners(Empty request, StreamObserver<OwnersListResponse> responseObserver) {
        try {
            List<Owner> owners = ownerRepository.findAll();
            List<org.springframework.samples.petclinic.customers.grpc.gen.owner.Owner> grpcOwners = owners.stream().map(owner -> ownerEntityMapper.map(owner)).toList();
            OwnersListResponse response = OwnersListResponse.newBuilder().addAllOwners(grpcOwners).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            responseObserver.onCompleted();
        } catch (Exception exception) {
            responseObserver.onError(Status.INTERNAL.withDescription("An expected has occurred. Please try again.").asRuntimeException());
        }
    }

    @Override
    public void updateOwner(UpdateOwnerRequest request, StreamObserver<UpdateOwnerResponse> responseObserver) {
        try {
            final Owner ownerModel = ownerRepository.findById(request.getOwnerId()).orElseThrow(() -> new ResourceNotFoundException("Owner " + request.getOwnerId() + " not found"));
            ownerEntityMapper.map(ownerModel, request.getOwner());
            ownerRepository.save(ownerModel);
            responseObserver.onNext(UpdateOwnerResponse.newBuilder().build());
            responseObserver.onCompleted();
        } catch (ResourceNotFoundException exception) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(exception.getMessage()).asRuntimeException());
        } catch (Exception exception) {
            responseObserver.onError(Status.INTERNAL.withDescription("An expected has occurred. Please try again.").asRuntimeException());
        }
    }
}

