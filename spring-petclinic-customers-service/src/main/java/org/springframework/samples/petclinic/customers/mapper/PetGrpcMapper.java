package org.springframework.samples.petclinic.customers.mapper;

import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.PetType;

import java.util.List;

public final class PetGrpcMapper {
    private PetGrpcMapper() {}

    public static Pet fromDomain(org.springframework.samples.petclinic.customers.model.Pet pet) {
        return Pet.newBuilder()
            .setType(PetType.newBuilder().setId(pet.getType().getId()).setName(pet.getType().getName()).build())
            .setName(pet.getName())
            .setBirthDate(pet.getBirthDate().toString())
            .setId(pet.getId())
            .setOwner(OwnerGrpcMapper.fromDomain(pet.getOwner()))
            .build();
    }

    public static List<PetType> fromDomain(List<org.springframework.samples.petclinic.customers.model.PetType> petTypes) {
       return petTypes.stream().map(petType -> org.springframework.samples.petclinic.customers.grpc.gen.customer.types.PetType.newBuilder().setId(petType.getId()).setName(petType.getName()).build()).toList();
    }
}
