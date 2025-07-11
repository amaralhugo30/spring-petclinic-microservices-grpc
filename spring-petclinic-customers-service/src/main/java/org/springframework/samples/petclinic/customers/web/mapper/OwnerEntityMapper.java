package org.springframework.samples.petclinic.customers.web.mapper;


import org.springframework.samples.petclinic.customers.grpc.gen.owner.Owner;
import org.springframework.samples.petclinic.customers.grpc.gen.owner.OwnerRequest;
import org.springframework.samples.petclinic.customers.grpc.gen.owner.Pet;
import org.springframework.samples.petclinic.customers.grpc.gen.owner.PetType;
import org.springframework.stereotype.Component;

@Component
public class OwnerEntityMapper implements Mapper<OwnerRequest, org.springframework.samples.petclinic.customers.model.Owner, Owner> {
    @Override
    public org.springframework.samples.petclinic.customers.model.Owner map(final org.springframework.samples.petclinic.customers.model.Owner owner, final OwnerRequest request) {
        owner.setAddress(request.getAddress());
        owner.setCity(request.getCity());
        owner.setTelephone(request.getTelephone());
        owner.setFirstName(request.getFirstName());
        owner.setLastName(request.getLastName());
        return owner;
    }

    @Override
    public Owner map(org.springframework.samples.petclinic.customers.model.Owner domainOwner) {
        Owner.Builder owner = org.springframework.samples.petclinic.customers.grpc.gen.owner.Owner.newBuilder()
            .setId(domainOwner.getId())
            .setFirstName(domainOwner.getFirstName())
            .setLastName(domainOwner.getLastName())
            .setAddress(domainOwner.getAddress())
            .setCity(domainOwner.getCity());

        for(org.springframework.samples.petclinic.customers.model.Pet p : domainOwner.getPets()) {
            Pet pet = Pet.newBuilder()
                .setId(p.getId())
                .setBirthDate(p.getBirthDate().toString())
                .setName(p.getName())
                .setType(PetType.newBuilder().setId(p.getType().getId()).build())
                .build();
            owner.addPets(pet);
        }

        return owner.build();
    }

}
