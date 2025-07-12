package org.springframework.samples.petclinic.customers.web;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.samples.petclinic.customers.grpc.PetService;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.PetServiceGrpc;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetRequest;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnerRequest;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetRequest;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetResponse;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetTypesResponse;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetRequest;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetResponse;
import org.springframework.samples.petclinic.customers.model.Owner;
import org.springframework.samples.petclinic.customers.model.OwnerRepository;
import org.springframework.samples.petclinic.customers.model.Pet;
import org.springframework.samples.petclinic.customers.model.PetRepository;
import org.springframework.samples.petclinic.customers.model.PetType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MvcResult;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class PetResourceTest {

    private static final String SERVER_NAME = "in-process-test-server";
    private Server server;
    private ManagedChannel channel;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private PetService petService;

    private Owner testOwner;
    private org.springframework.samples.petclinic.customers.model.PetType testPetType;

    @BeforeEach
    void setUp() throws IOException {
        server = InProcessServerBuilder.forName(SERVER_NAME)
            .directExecutor()
            .addService(petService)
            .build()
            .start();

        channel = InProcessChannelBuilder.forName(SERVER_NAME)
            .directExecutor()
            .build();

        testOwner = createTestOwner("Test", "Owner");
        testPetType = createOrGetTestPetType("Dog");
    }

    @AfterEach
    public void teardown() {
        channel.shutdownNow();
        server.shutdownNow();
    }

    @Nested
    @DisplayName("Pet Types Operations")
    class PetTypesTests {

        @Test
        @DisplayName("Should retrieve all pet types successfully")
        void shouldGetPetTypes() {
            PetServiceGrpc.PetServiceBlockingStub stub = PetServiceGrpc.newBlockingStub(channel);
            GetPetTypesResponse petTypes = stub.getPetTypes(Empty.newBuilder().build());
            assertThat(petTypes.getPetTypesList()).isNotEmpty();
        }
    }

    @Nested
    @DisplayName("Create Pet Operations")
    class CreatePetTests {

        @Test
        @DisplayName("Should create pet successfully with valid data")
        void shouldCreatePetSuccessfully() throws Exception {
            PetServiceGrpc.PetServiceBlockingStub stub = PetServiceGrpc.newBlockingStub(channel);
            CreatePetRequest petRequest = createValidPetRequest();

            CreatePetResponse response = stub.createPet(petRequest);

            assertPetMatchesRequest(response.getPet(), petRequest);
            assertPetPersistedCorrectly(response.getPet().getId(), petRequest);
        }

        @Test
        @DisplayName("Should return validation error for invalid owner data")
        void shouldReturnValidationErrorForInvalidOwnderId() {
            PetServiceGrpc.PetServiceBlockingStub stub = PetServiceGrpc.newBlockingStub(channel);
            CreatePetRequest invalidRequest = createInvalidPetRequest();

            assertThatThrownBy(() -> stub.createPet(invalidRequest))
                .isInstanceOf(StatusRuntimeException.class)
                .satisfies(exception -> {
                    StatusRuntimeException grpcException = (StatusRuntimeException) exception;
                    assertThat(grpcException.getStatus().getCode()).isEqualTo(Status.Code.INTERNAL);
                });
        }
    }

    @Nested
    @DisplayName("Find Pet Operations")
    class FindPetTests {

        @Test
        @DisplayName("Should find pet by ID successfully")
        void shouldFindPetById() {
            PetServiceGrpc.PetServiceBlockingStub stub = PetServiceGrpc.newBlockingStub(channel);
            Pet existingPet = createTestPet("Buddy", testOwner, testPetType);

            GetPetResponse response = stub.getPet(GetPetRequest.newBuilder().setPetId(existingPet.getId()).build());

            assertPetDetailsMatchesPet(response.getPet(), existingPet);
        }

        @Test
        @DisplayName("Should handle non-existent pet gracefully")
        void shouldHandleNonExistentPet() {
            PetServiceGrpc.PetServiceBlockingStub stub = PetServiceGrpc.newBlockingStub(channel);
            int nonExistentPetId = 99999;

            assertThatThrownBy(() -> stub.getPet(GetPetRequest.newBuilder().setPetId(nonExistentPetId).build()))
                .isInstanceOf(StatusRuntimeException.class)
                .satisfies(exception -> {
                    StatusRuntimeException grpcException = (StatusRuntimeException) exception;
                    assertThat(grpcException.getStatus().getCode()).isEqualTo(Status.Code.NOT_FOUND);
                });
        }
    }

    @Nested
    @DisplayName("Update Pet Operations")
    class UpdatePetTests {

        @Test
        @DisplayName("Should update pet successfully")
        void shouldUpdatePetSuccessfully() {
            PetServiceGrpc.PetServiceBlockingStub stub = PetServiceGrpc.newBlockingStub(channel);
            Pet existingPet = createTestPet("Original Name", testOwner, testPetType);
            UpdatePetRequest request = UpdatePetRequest.newBuilder()
                .setPetId(existingPet.getId())
                .setBirthDate("2023-01-15")
                .setName("Updated Name")
                .setTypeId(testPetType.getId())
                .build();

            stub.updatePet(request);

            assertPetUpdatedCorrectly(existingPet.getId(), request);
        }

        @Test
        @DisplayName("Should handle update of non-existent pet")
        void shouldHandleUpdateOfNonExistentPet() {
            PetServiceGrpc.PetServiceBlockingStub stub = PetServiceGrpc.newBlockingStub(channel);
            int nonExistentPetId = 99999;
            UpdatePetRequest request = UpdatePetRequest.newBuilder()
                .setPetId(nonExistentPetId)
                .setBirthDate(new Date().toString())
                .setName("Updated Name")
                .setTypeId(testPetType.getId())
                .build();

            assertThatThrownBy(() ->  stub.updatePet(request))
                .isInstanceOf(StatusRuntimeException.class)
                .satisfies(exception -> {
                    StatusRuntimeException grpcException = (StatusRuntimeException) exception;
                    assertThat(grpcException.getStatus().getCode()).isEqualTo(Status.Code.NOT_FOUND);
                });
        }
    }

    private CreatePetRequest createValidPetRequest() {
        return CreatePetRequest.newBuilder()
            .setTypeId(testPetType.getId())
            .setBirthDate("2023-01-15")
            .setName("Buddy")
            .setOwnerId(testOwner.getId()).build();
    }

    private CreatePetRequest createInvalidPetRequest() {
        return CreatePetRequest.newBuilder()
            .setTypeId(testPetType.getId())
            .setBirthDate("abc")
            .setName("")
            .setOwnerId(testOwner.getId()).build();
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

    private org.springframework.samples.petclinic.customers.model.PetType createOrGetTestPetType(String name) {
        List<org.springframework.samples.petclinic.customers.model.PetType> existingTypes = petRepository.findPetTypes();
        for (org.springframework.samples.petclinic.customers.model.PetType type : existingTypes) {
            if (name.equals(type.getName())) {
                return type;
            }
        }

        org.springframework.samples.petclinic.customers.model.PetType petType = new org.springframework.samples.petclinic.customers.model.PetType();
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

    private void assertPetMatchesRequest(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet pet, CreatePetRequest request) {
        assertThat(pet).isNotNull();
        assertThat(pet.getName()).isEqualTo(request.getName());
        assertThat(pet.getType().getId()).isEqualTo(request.getTypeId());
    }

    private void assertPetPersistedCorrectly(Integer petId, CreatePetRequest request) {
        Optional<Pet> persistedPet = petRepository.findById(petId);
        assertThat(persistedPet).isPresent();
        assertThat(persistedPet.get().getName()).isEqualTo(request.getName());
        assertThat(persistedPet.get().getType().getId()).isEqualTo(request.getTypeId());
    }

    private void assertPetDetailsMatchesPet(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet petDetails, Pet expectedPet) {
        assertThat(petDetails).isNotNull();
        assertThat(petDetails.getId()).isEqualTo(expectedPet.getId().longValue());
        assertThat(petDetails.getName()).isEqualTo(expectedPet.getName());
        assertThat(petDetails.getType().getId()).isEqualTo(expectedPet.getType().getId());
    }

    private void assertPetUpdatedCorrectly(Integer petId, UpdatePetRequest updateRequest) {
        Optional<Pet> updatedPet = petRepository.findById(petId);
        assertThat(updatedPet).isPresent();
        Pet pet = updatedPet.get();
        assertThat(pet.getName()).isEqualTo(updateRequest.getName());
        assertThat(pet.getType().getId()).isEqualTo(updateRequest.getTypeId());
    }
}
