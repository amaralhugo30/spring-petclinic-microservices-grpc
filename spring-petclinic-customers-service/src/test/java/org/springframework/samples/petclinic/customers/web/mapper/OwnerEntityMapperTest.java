package org.springframework.samples.petclinic.customers.web.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.samples.petclinic.customers.grpc.gen.owner.OwnerRequest;
import org.springframework.samples.petclinic.customers.grpc.gen.owner.Pet;
import org.springframework.samples.petclinic.customers.model.Owner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OwnerEntityMapperTest {

    private OwnerEntityMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new OwnerEntityMapper();
    }

    @Test
    void map_shouldUpdateOwnerFieldsFromRequest() {
        Owner owner = new Owner();
        OwnerRequest request = mock(OwnerRequest.class);

        when(request.getAddress()).thenReturn("123 Main St");
        when(request.getCity()).thenReturn("Springfield");
        when(request.getTelephone()).thenReturn("123456789012");
        when(request.getFirstName()).thenReturn("John");
        when(request.getLastName()).thenReturn("Doe");

        Owner result = mapper.map(owner, request);

        assertEquals("123 Main St", result.getAddress());
        assertEquals("Springfield", result.getCity());
        assertEquals("123456789012", result.getTelephone());
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
    }

    @Test
    void map_shouldMapDomainOwnerToGrpcOwner() throws NoSuchFieldException, IllegalAccessException {
        org.springframework.samples.petclinic.customers.model.Owner domainOwner =
            new org.springframework.samples.petclinic.customers.model.Owner();

        java.lang.reflect.Field idField = domainOwner.getClass().getDeclaredField("id");
        idField.setAccessible(true);
        idField.set(domainOwner, 1);
        domainOwner.setFirstName("John");
        domainOwner.setLastName("Doe");
        domainOwner.setAddress("123 Main St");
        domainOwner.setCity("Springfield");
        domainOwner.setTelephone("555123456789");


        org.springframework.samples.petclinic.customers.model.Pet pet1 =
            new org.springframework.samples.petclinic.customers.model.Pet();
        pet1.setId(1);
        pet1.setName("Fluffy");
        pet1.setBirthDate(new Date(55555L));

        org.springframework.samples.petclinic.customers.model.PetType petType =
            new org.springframework.samples.petclinic.customers.model.PetType();
        petType.setId(1);
        pet1.setType(petType);

        domainOwner.addPet(pet1);

        org.springframework.samples.petclinic.customers.grpc.gen.owner.Owner grpcOwner = mapper.map(domainOwner);

        assertEquals(grpcOwner.getFirstName(),"John");
        assertEquals(grpcOwner.getLastName(), "Doe");
        assertEquals(grpcOwner.getAddress(), "123 Main St");
        assertEquals(grpcOwner.getCity(), "Springfield");
        assertEquals(grpcOwner.getTelephone(), "555123456789");

        assertThat(grpcOwner.getPetsList()).hasSize(1);
        Pet grpcPet = grpcOwner.getPetsList().get(0);
        assertThat(grpcPet.getId()).isEqualTo(1);
        assertThat(grpcPet.getName()).isEqualTo("Fluffy");
        assertThat(grpcPet.getBirthDate()).isEqualTo(new Date(55555L).toString());
        assertThat(grpcPet.getType().getId()).isEqualTo(1);
    }
}
