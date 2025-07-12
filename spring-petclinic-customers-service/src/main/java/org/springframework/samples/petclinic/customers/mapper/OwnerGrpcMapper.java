package org.springframework.samples.petclinic.customers.mapper;

import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreateOwnerRequest;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreateOwnerResponse;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.PetType;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdateOwnerRequest;
import org.springframework.samples.petclinic.customers.model.Owner;


public final class OwnerGrpcMapper {

    private OwnerGrpcMapper() {}

    public static Owner toDomain(final Owner owner, CreateOwnerRequest request) {
        owner.setFirstName(request.getFirstName());
        owner.setLastName(request.getLastName());
        owner.setAddress(request.getAddress());
        owner.setCity(request.getCity());
        owner.setTelephone(request.getTelephone());
        return owner;
    }

    public static Owner toDomain(final Owner owner, UpdateOwnerRequest request) {
        owner.setFirstName(request.getFirstName());
        owner.setLastName(request.getLastName());
        owner.setAddress(request.getAddress());
        owner.setCity(request.getCity());
        owner.setTelephone(request.getTelephone());
        return owner;
    }

    public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner fromDomain(Owner owner) {
        org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner.Builder ownerBuilder = org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner.newBuilder()
            .setId(owner.getId())
            .setFirstName(owner.getFirstName())
            .setLastName(owner.getLastName())
            .setAddress(owner.getAddress())
            .setCity(owner.getCity())
            .setTelephone(owner.getTelephone());

        for(org.springframework.samples.petclinic.customers.model.Pet p : owner.getPets()) {
            org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet pet = org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet.newBuilder()
                .setId(p.getId())
                .setBirthDate(p.getBirthDate().toString())
                .setName(p.getName())
                .setType(PetType.newBuilder().setId(p.getType().getId()).build())
                .build();
            ownerBuilder.addPets(pet);
        }

        return ownerBuilder.build();
    }
}
