package org.springframework.samples.petclinic.customers.web.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.samples.petclinic.customers.model.Owner;
import org.springframework.samples.petclinic.customers.web.OwnerRequest;

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

        when(request.address()).thenReturn("123 Main St");
        when(request.city()).thenReturn("Springfield");
        when(request.telephone()).thenReturn("123456789012");
        when(request.firstName()).thenReturn("John");
        when(request.lastName()).thenReturn("Doe");

        Owner result = mapper.map(owner, request);

        assertEquals("123 Main St", result.getAddress());
        assertEquals("Springfield", result.getCity());
        assertEquals("123456789012", result.getTelephone());
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
    }
}
