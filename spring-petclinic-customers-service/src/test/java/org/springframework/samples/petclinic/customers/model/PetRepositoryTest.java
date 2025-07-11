package org.springframework.samples.petclinic.customers.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for PetRepository.
 * These tests validate the data layer functionality that both REST and gRPC depend on.
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
class PetRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    private Owner testOwner;
    private PetType testPetType;

    @BeforeEach
    void setUp() {
        // Create test owner
        testOwner = new Owner();
        testOwner.setFirstName("Test");
        testOwner.setLastName("Owner");
        testOwner.setAddress("123 Test St");
        testOwner.setCity("Test City");
        testOwner.setTelephone("123456789012");
        testOwner = ownerRepository.save(testOwner);

        // Create test pet type
        testPetType = new PetType();
        testPetType.setName("Dog");
        entityManager.persist(testPetType);
        entityManager.flush();
    }

    @Test
    void shouldSaveAndFindPet() {
        Pet pet = new Pet();
        pet.setName("Buddy");
        pet.setBirthDate(new Date(55555L));
        pet.setType(testPetType);
        testOwner.addPet(pet);

        Pet savedPet = petRepository.save(pet);

        assertNotNull(savedPet.getId());
        assertEquals("Buddy", savedPet.getName());
        assertEquals(new Date(55555L), savedPet.getBirthDate());
        assertEquals(testPetType.getId(), savedPet.getType().getId());

        Optional<Pet> foundPet = petRepository.findById(savedPet.getId());
        assertTrue(foundPet.isPresent());
        assertEquals("Buddy", foundPet.get().getName());
    }

    @Test
    void shouldUpdatePet() {
        Pet pet = new Pet();
        pet.setName("Original Name");
        pet.setBirthDate(new Date(555555L));
        pet.setType(testPetType);
        testOwner.addPet(pet);
        pet = petRepository.save(pet);

        pet.setName("Updated Name");
        Pet updatedPet = petRepository.save(pet);

        assertEquals("Updated Name", updatedPet.getName());
        assertEquals(new Date(555555L), updatedPet.getBirthDate()); // unchanged
    }

    @Test
    void shouldDeletePet() {
        Pet pet = new Pet();
        pet.setName("ToDelete");
        pet.setBirthDate(new Date());
        pet.setType(testPetType);
        testOwner.addPet(pet);
        pet = petRepository.save(pet);

        Integer petId = pet.getId();
        petRepository.delete(pet);

        Optional<Pet> deletedPet = petRepository.findById(petId);
        assertFalse(deletedPet.isPresent());
    }

    @Test
    void shouldReturnEmptyWhenPetNotFound() {
        Optional<Pet> notFound = petRepository.findById(99999);
        assertFalse(notFound.isPresent());
    }

    @Test
    void shouldFindPetTypes() {
        List<PetType> petTypes = petRepository.findPetTypes();
        assertNotNull(petTypes);
        assertTrue(petTypes.size() >= 1); // At least our test pet type should be present

        boolean foundTestType = petTypes.stream()
                .anyMatch(type -> "Dog".equals(type.getName()));
        assertTrue(foundTestType);
    }

    @Test
    void shouldFindPetTypeById() {
        Optional<PetType> foundType = petRepository.findPetTypeById(testPetType.getId());
        assertTrue(foundType.isPresent());
        assertEquals("Dog", foundType.get().getName());
    }

    @Test
    void shouldReturnEmptyWhenPetTypeNotFound() {
        Optional<PetType> notFound = petRepository.findPetTypeById(99999);
        assertFalse(notFound.isPresent());
    }
}
