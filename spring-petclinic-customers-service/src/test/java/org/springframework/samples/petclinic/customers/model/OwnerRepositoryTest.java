package org.springframework.samples.petclinic.customers.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
class OwnerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    void shouldSaveAndFindOwner() {
        Owner owner = new Owner();
        owner.setFirstName("John");
        owner.setLastName("Doe");
        owner.setAddress("123 Main St");
        owner.setCity("Springfield");
        owner.setTelephone("123456789012");

        Owner savedOwner = ownerRepository.save(owner);

        assertNotNull(savedOwner.getId());
        assertEquals("John", savedOwner.getFirstName());
        assertEquals("Doe", savedOwner.getLastName());

        Optional<Owner> foundOwner = ownerRepository.findById(savedOwner.getId());
        assertTrue(foundOwner.isPresent());
        assertEquals("John", foundOwner.get().getFirstName());
    }

    @Test
    void shouldFindAllOwners() {
        Owner owner1 = new Owner();
        owner1.setFirstName("Alice");
        owner1.setLastName("Johnson");
        owner1.setAddress("789 Pine St");
        owner1.setCity("Springfield");
        owner1.setTelephone("123456789012");
        ownerRepository.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setLastName("Wilson");
        owner2.setAddress("321 Elm St");
        owner2.setCity("Springfield");
        owner2.setTelephone("098765432123");
        ownerRepository.save(owner2);

        List<Owner> owners = ownerRepository.findAll();
        assertTrue(owners.size() >= 2);

        boolean foundAlice = owners.stream()
                .anyMatch(owner -> "Alice".equals(owner.getFirstName()));
        boolean foundBob = owners.stream()
                .anyMatch(owner -> "Bob".equals(owner.getFirstName()));

        assertTrue(foundAlice);
        assertTrue(foundBob);
    }

    @Test
    void shouldUpdateOwner() {
        Owner owner = new Owner();
        owner.setFirstName("Original");
        owner.setLastName("Name");
        owner.setAddress("Original Address");
        owner.setCity("Original City");
        owner.setTelephone("123456789012");
        owner = ownerRepository.save(owner);

        owner.setFirstName("Updated");
        owner.setAddress("Updated Address");
        Owner updatedOwner = ownerRepository.save(owner);

        assertEquals("Updated", updatedOwner.getFirstName());
        assertEquals("Updated Address", updatedOwner.getAddress());
        assertEquals("Original City", updatedOwner.getCity()); // unchanged
    }

    @Test
    void shouldDeleteOwner() {
        Owner owner = new Owner();
        owner.setFirstName("ToDelete");
        owner.setLastName("Owner");
        owner.setAddress("Delete St");
        owner.setCity("Delete City");
        owner.setTelephone("123456789012");
        owner = ownerRepository.save(owner);

        Integer ownerId = owner.getId();
        ownerRepository.delete(owner);

        Optional<Owner> deletedOwner = ownerRepository.findById(ownerId);
        assertFalse(deletedOwner.isPresent());
    }

    @Test
    void shouldReturnEmptyWhenOwnerNotFound() {
        Optional<Owner> notFound = ownerRepository.findById(99999);
        assertFalse(notFound.isPresent());
    }
}
