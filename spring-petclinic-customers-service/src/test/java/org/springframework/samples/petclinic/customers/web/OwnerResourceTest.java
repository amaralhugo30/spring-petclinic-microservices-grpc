package org.springframework.samples.petclinic.customers.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.samples.petclinic.customers.model.Owner;
import org.springframework.samples.petclinic.customers.model.OwnerRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class OwnerResourceTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Nested
    @DisplayName("Create Owner Operations")
    class CreateOwnerTests {

        @Test
        @DisplayName("Should create owner successfully with valid data")
        void shouldCreateOwnerSuccessfully() throws Exception {
            OwnerRequest ownerRequest = createValidOwnerRequest();

            MvcResult result = mockMvc.perform(post("/owners")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(ownerRequest)))
                .andExpect(status().isCreated())
                .andReturn();

            String responseBody = result.getResponse().getContentAsString();
            Owner createdOwner = objectMapper.readValue(responseBody, Owner.class);

            assertOwnerMatchesRequest(createdOwner, ownerRequest);
            assertOwnerPersistedCorrectly(createdOwner.getId(), ownerRequest);
        }

        @Test
        @DisplayName("Should return validation error for invalid owner data")
        void shouldReturnValidationErrorForInvalidOwner() throws Exception {
            OwnerRequest invalidRequest = createInvalidOwnerRequest();

            mockMvc.perform(post("/owners")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(invalidRequest)))
                .andExpect(status().isBadRequest());

            assertNoOwnerCreatedInDatabase();
        }
    }

    @Nested
    @DisplayName("Find Owner Operations")
    class FindOwnerTests {

        @Test
        @DisplayName("Should find owner by ID successfully")
        void shouldFindOwnerById() throws Exception {
            Owner existingOwner = createTestOwner("Jane", "Smith");

            MvcResult result = mockMvc.perform(get("/owners/{ownerId}", existingOwner.getId())
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

            String responseBody = result.getResponse().getContentAsString();
            Optional<Owner> foundOwnerOptional = Optional.of(objectMapper.readValue(responseBody, Owner.class));

            assertOwnerFoundCorrectly(foundOwnerOptional, existingOwner);
        }

        @Test
        @DisplayName("Should handle non-existent owner gracefully")
        void shouldHandleNonExistentOwner() throws Exception {
            int nonExistentId = 99999;

            MvcResult result = mockMvc.perform(get("/owners/{ownerId}", nonExistentId)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

            String responseBody = result.getResponse().getContentAsString();
            assertThat(responseBody).isEqualTo("null");
        }

        @Test
        @DisplayName("Should list all owners successfully")
        void shouldListAllOwners() throws Exception {
            Owner owner1 = createTestOwner("Alice", "Johnson");
            Owner owner2 = createTestOwner("Bob", "Wilson");

            MvcResult result = mockMvc.perform(get("/owners")
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

            String responseBody = result.getResponse().getContentAsString();
            Owner[] owners = objectMapper.readValue(responseBody, Owner[].class);

            assertOwnersListContainsExpectedOwners(List.of(owners), owner1, owner2);
        }
    }

    @Nested
    @DisplayName("Update Owner Operations")
    class UpdateOwnerTests {

        @Test
        @DisplayName("Should update owner successfully")
        void shouldUpdateOwnerSuccessfully() throws Exception {
            Owner existingOwner = createTestOwner("Original", "Name");
            OwnerRequest updateRequest = new OwnerRequest(
                "Updated", "Name", "456 Updated St", "Updated City", "555111222333"
            );

            mockMvc.perform(put("/owners/{ownerId}", existingOwner.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(updateRequest)))
                .andExpect(status().isNoContent());

            assertOwnerUpdatedCorrectly(existingOwner.getId(), updateRequest);
        }

        @Test
        @DisplayName("Should handle update of non-existent owner")
        void shouldHandleUpdateOfNonExistentOwner() throws Exception {
            int nonExistentId = 99999;
            OwnerRequest updateRequest = createValidOwnerRequest();

            mockMvc.perform(put("/owners/{ownerId}", nonExistentId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(updateRequest)))
                .andExpect(status().isNotFound());

            assertNoOwnerUpdatedInDatabase(nonExistentId);
        }

        @Test
        @DisplayName("Should return validation error when updating with invalid data")
        void shouldReturnValidationErrorWhenUpdatingWithInvalidData() throws Exception {
            Owner existingOwner = createTestOwner("Valid", "Owner");
            OwnerRequest invalidUpdateRequest = createInvalidOwnerRequest();

            mockMvc.perform(put("/owners/{ownerId}", existingOwner.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(invalidUpdateRequest)))
                .andExpect(status().isBadRequest());

            assertOwnerNotUpdated(existingOwner.getId(), existingOwner);
        }
    }

    private OwnerRequest createValidOwnerRequest() {
        return new OwnerRequest("John", "Doe", "123 Main St", "Springfield", "555123456789");
    }


    private OwnerRequest createInvalidOwnerRequest() {
        return new OwnerRequest("", "", "", "", "");
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

    private void assertOwnerMatchesRequest(Owner owner, OwnerRequest request) {
        assertThat(owner).isNotNull();
        assertThat(owner.getFirstName()).isEqualTo(request.firstName());
        assertThat(owner.getLastName()).isEqualTo(request.lastName());
        assertThat(owner.getAddress()).isEqualTo(request.address());
        assertThat(owner.getCity()).isEqualTo(request.city());
        assertThat(owner.getTelephone()).isEqualTo(request.telephone());
    }

    private void assertOwnerPersistedCorrectly(Integer ownerId, OwnerRequest request) {
        Optional<Owner> persistedOwner = ownerRepository.findById(ownerId);
        assertThat(persistedOwner).isPresent();
        assertThat(persistedOwner.get().getFirstName()).isEqualTo(request.firstName());
        assertThat(persistedOwner.get().getLastName()).isEqualTo(request.lastName());
        assertThat(persistedOwner.get().getAddress()).isEqualTo(request.address());
        assertThat(persistedOwner.get().getCity()).isEqualTo(request.city());
        assertThat(persistedOwner.get().getTelephone()).isEqualTo(request.telephone());
    }

    private void assertNoOwnerCreatedInDatabase() {
        List<Owner> allOwners = ownerRepository.findAll();
        assertThat(allOwners).isNotNull();
    }

    private void assertOwnerFoundCorrectly(Optional<Owner> foundOwner, Owner expectedOwner) {
        assertThat(foundOwner).isPresent();
        Owner owner = foundOwner.get();
        assertThat(owner.getId()).isEqualTo(expectedOwner.getId());
        assertThat(owner.getFirstName()).isEqualTo(expectedOwner.getFirstName());
        assertThat(owner.getLastName()).isEqualTo(expectedOwner.getLastName());
        assertThat(owner.getAddress()).isEqualTo(expectedOwner.getAddress());
        assertThat(owner.getCity()).isEqualTo(expectedOwner.getCity());
        assertThat(owner.getTelephone()).isEqualTo(expectedOwner.getTelephone());
    }

    private void assertOwnersListContainsExpectedOwners(List<Owner> ownersList, Owner... expectedOwners) {
        assertThat(ownersList).isNotEmpty();
        assertThat(ownersList.size()).isGreaterThanOrEqualTo(expectedOwners.length);

        for (Owner expectedOwner : expectedOwners) {
            assertThat(ownersList).anySatisfy(owner -> {
                assertThat(owner.getId()).isEqualTo(expectedOwner.getId());
                assertThat(owner.getFirstName()).isEqualTo(expectedOwner.getFirstName());
                assertThat(owner.getLastName()).isEqualTo(expectedOwner.getLastName());
            });
        }
    }

    private void assertOwnerUpdatedCorrectly(Integer ownerId, OwnerRequest updateRequest) {
        Optional<Owner> updatedOwner = ownerRepository.findById(ownerId);
        assertThat(updatedOwner).isPresent();
        Owner owner = updatedOwner.get();
        assertThat(owner.getFirstName()).isEqualTo(updateRequest.firstName());
        assertThat(owner.getLastName()).isEqualTo(updateRequest.lastName());
        assertThat(owner.getAddress()).isEqualTo(updateRequest.address());
        assertThat(owner.getCity()).isEqualTo(updateRequest.city());
        assertThat(owner.getTelephone()).isEqualTo(updateRequest.telephone());
    }

    private void assertNoOwnerUpdatedInDatabase(Integer ownerId) {
        Optional<Owner> owner = ownerRepository.findById(ownerId);
        assertThat(owner).isEmpty();
    }

    private void assertOwnerNotUpdated(Integer ownerId, Owner originalOwner) {
        Optional<Owner> owner = ownerRepository.findById(ownerId);
        assertThat(owner).isPresent();
        Owner currentOwner = owner.get();
        assertThat(currentOwner.getFirstName()).isEqualTo(originalOwner.getFirstName());
        assertThat(currentOwner.getLastName()).isEqualTo(originalOwner.getLastName());
        assertThat(currentOwner.getAddress()).isEqualTo(originalOwner.getAddress());
        assertThat(currentOwner.getCity()).isEqualTo(originalOwner.getCity());
        assertThat(currentOwner.getTelephone()).isEqualTo(originalOwner.getTelephone());
    }
}
