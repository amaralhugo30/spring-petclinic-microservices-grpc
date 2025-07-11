package org.springframework.samples.petclinic.customers.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.samples.petclinic.customers.model.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PetResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Owner testOwner;
    private PetType testPetType;

    @BeforeEach
    void setUp() {
        testOwner = createTestOwner("Test", "Owner");
        testPetType = createOrGetTestPetType("Dog");
    }

    @Nested
    @DisplayName("Pet Types Operations")
    class PetTypesTests {

        @Test
        @DisplayName("Should retrieve all pet types successfully")
        void shouldGetPetTypes() throws Exception {
            MvcResult result = mockMvc.perform(get("/petTypes")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andReturn();

            String responseBody = result.getResponse().getContentAsString();
            PetType[] petTypes = objectMapper.readValue(responseBody, PetType[].class);

            assertThat(petTypes).isNotEmpty();
        }
    }

    @Nested
    @DisplayName("Create Pet Operations")
    class CreatePetTests {

        @Test
        @DisplayName("Should create pet successfully with valid data")
        void shouldCreatePetSuccessfully() throws Exception {
            PetRequest petRequest = createValidPetRequest();

            MvcResult result = mockMvc.perform(post("/owners/{ownerId}/pets", testOwner.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(petRequest)))
                    .andExpect(status().isCreated())
                    .andReturn();

            String responseBody = result.getResponse().getContentAsString();
            Pet createdPet = objectMapper.readValue(responseBody, Pet.class);

            assertPetMatchesRequest(createdPet, petRequest);
            assertPetPersistedCorrectly(createdPet.getId(), petRequest);
        }

        @Test
        @DisplayName("Should return validation error for invalid owner data")
        void shouldReturnValidationErrorForInvalidOwnderId() throws Exception {
            PetRequest invalidRequest = createValidPetRequest();

            mockMvc.perform(post("/owners/{ownerId}/pets", 888)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(invalidRequest)))
                    .andExpect(status().is4xxClientError());
        }
    }

    @Nested
    @DisplayName("Find Pet Operations")
    class FindPetTests {

        @Test
        @DisplayName("Should find pet by ID successfully")
        void shouldFindPetById() throws Exception {
            Pet existingPet = createTestPet("Buddy", testOwner, testPetType);

            MvcResult result = mockMvc.perform(get("/owners/{ownerId}/pets/{petId}", testOwner.getId(), existingPet.getId())
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andReturn();

            String responseBody = result.getResponse().getContentAsString();
            PetDetails petDetails = objectMapper.readValue(responseBody, PetDetails.class);

            assertPetDetailsMatchesPet(petDetails, existingPet);
        }

        @Test
        @DisplayName("Should handle non-existent pet gracefully")
        void shouldHandleNonExistentPet() throws Exception {
            int nonExistentPetId = 99999;

            mockMvc.perform(get("/owners/{ownerId}/pets/{petId}", testOwner.getId(), nonExistentPetId)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound());
        }
    }

    @Nested
    @DisplayName("Update Pet Operations")
    class UpdatePetTests {

        @Test
        @DisplayName("Should update pet successfully")
        void shouldUpdatePetSuccessfully() throws Exception {
            Pet existingPet = createTestPet("Original Name", testOwner, testPetType);
            PetRequest updateRequest = new PetRequest(existingPet.getId(), new Date(), "Updated Name", testPetType.getId());

            mockMvc.perform(put("/owners/*/pets/{petId}", existingPet.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(updateRequest)))
                    .andExpect(status().isNoContent());

            assertPetUpdatedCorrectly(existingPet.getId(), updateRequest);
        }

        @Test
        @DisplayName("Should handle update of non-existent pet")
        void shouldHandleUpdateOfNonExistentPet() throws Exception {
            int nonExistentPetId = 99999;
            PetRequest updateRequest = createValidPetRequest();

            mockMvc.perform(put("/owners/*/pets/{petId}", nonExistentPetId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(updateRequest)))
                    .andExpect(status().isNotFound());
        }
    }

    private PetRequest createValidPetRequest() {
        return new PetRequest(0, new Date(), "Buddy", testPetType.getId());
    }

    private PetRequest createInvalidPetRequest() {
        return new PetRequest(0, new Date(), "", testPetType.getId());
    }

    private Owner createTestOwner(String firstName, String lastName) {
        Owner owner = new Owner();
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        owner.setAddress("123 Test Street");
        owner.setCity("Test City");
        owner.setTelephone("555987654321");
        return ownerRepository.save(owner);
    }

    private PetType createOrGetTestPetType(String name) {
        List<PetType> existingTypes = petRepository.findPetTypes();
        for (PetType type : existingTypes) {
            if (name.equals(type.getName())) {
                return type;
            }
        }

        PetType petType = new PetType();
        petType.setId(1);
        petType.setName(name);
        return petType;
    }

    private Pet createTestPet(String name, Owner owner, PetType petType) {
        Pet pet = new Pet();
        pet.setName(name);
        pet.setBirthDate(new Date());
        pet.setType(petType);
        owner.addPet(pet);
        return petRepository.save(pet);
    }

    private void assertPetMatchesRequest(Pet pet, PetRequest request) {
        assertThat(pet).isNotNull();
        assertThat(pet.getName()).isEqualTo(request.name());
        assertThat(pet.getType().getId()).isEqualTo(request.typeId());
    }

    private void assertPetPersistedCorrectly(Integer petId, PetRequest request) {
        Optional<Pet> persistedPet = petRepository.findById(petId);
        assertThat(persistedPet).isPresent();
        assertThat(persistedPet.get().getName()).isEqualTo(request.name());
        assertThat(persistedPet.get().getType().getId()).isEqualTo(request.typeId());
    }

    private void assertPetDetailsMatchesPet(PetDetails petDetails, Pet expectedPet) {
        assertThat(petDetails).isNotNull();
        assertThat(petDetails.id()).isEqualTo(expectedPet.getId().longValue());
        assertThat(petDetails.name()).isEqualTo(expectedPet.getName());
        assertThat(petDetails.type().getId()).isEqualTo(expectedPet.getType().getId());
    }

    private void assertPetUpdatedCorrectly(Integer petId, PetRequest updateRequest) {
        Optional<Pet> updatedPet = petRepository.findById(petId);
        assertThat(updatedPet).isPresent();
        Pet pet = updatedPet.get();
        assertThat(pet.getName()).isEqualTo(updateRequest.name());
        assertThat(pet.getType().getId()).isEqualTo(updateRequest.typeId());
    }
}
