package org.springframework.samples.petclinic.customers.web.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.samples.petclinic.customers.grpc.gen.owner.OwnerRequest;
import org.springframework.samples.petclinic.customers.model.Owner;

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
}
