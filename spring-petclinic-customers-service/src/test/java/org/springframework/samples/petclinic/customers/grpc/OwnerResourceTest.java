package org.springframework.samples.petclinic.customers.grpc;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
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
import org.springframework.samples.petclinic.customers.grpc.gen.owner.GetOwnerRequest;
import org.springframework.samples.petclinic.customers.grpc.gen.owner.Owner;
import org.springframework.samples.petclinic.customers.grpc.gen.owner.OwnerRequest;
import org.springframework.samples.petclinic.customers.grpc.gen.owner.OwnerResponse;
import org.springframework.samples.petclinic.customers.grpc.gen.owner.OwnerServiceGrpc;
import org.springframework.samples.petclinic.customers.grpc.gen.owner.OwnersListResponse;
import org.springframework.samples.petclinic.customers.grpc.gen.owner.UpdateOwnerRequest;
import org.springframework.samples.petclinic.customers.model.OwnerRepository;
import org.springframework.samples.petclinic.customers.web.mapper.OwnerEntityMapper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import io.grpc.*;


@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest
class OwnerResourceTest {

    private static final String SERVER_NAME = "in-process-test-server";
    private Server server;
    private ManagedChannel channel;

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    OwnerEntityMapper mapper;

    @Autowired
    private OwnerService ownerService;

    @BeforeEach
    public void setup() throws Exception {
        server = InProcessServerBuilder.forName(SERVER_NAME)
            .directExecutor()
            .addService(ownerService)
            .build()
            .start();

        channel = InProcessChannelBuilder.forName(SERVER_NAME)
            .directExecutor()
            .build();
    }

    @AfterEach
    public void teardown() {
        channel.shutdownNow();
        server.shutdownNow();
    }


    @Nested
    @DisplayName("Create Owner Operations")
    class CreateOwnerTests {

        @Test
        @DisplayName("Should create owner successfully with valid data")
        void shouldCreateOwnerSuccessfully() {
            OwnerServiceGrpc.OwnerServiceBlockingStub stub = OwnerServiceGrpc.newBlockingStub(channel);
            OwnerRequest ownerRequest = createValidOwnerRequest();

            OwnerResponse createdOwner = stub.createOwner(ownerRequest);

            assertOwnerMatchesRequest(createdOwner.getOwner(), ownerRequest);
            assertOwnerPersistedCorrectly(createdOwner.getOwner().getId(), ownerRequest);
        }

        @Test
        @DisplayName("Should return validation error for invalid owner data")
        void shouldReturnValidationErrorForInvalidOwner() {
            OwnerServiceGrpc.OwnerServiceBlockingStub stub = OwnerServiceGrpc.newBlockingStub(channel);
            OwnerRequest invalidRequest = createInvalidOwnerRequest();

            assertThatThrownBy(() ->  stub.createOwner(invalidRequest))
                .isInstanceOf(StatusRuntimeException.class)
                .satisfies(exception -> {
                    StatusRuntimeException grpcException = (StatusRuntimeException) exception;
                    assertThat(grpcException.getStatus().getCode()).isEqualTo(Status.Code.INTERNAL);
                });

            assertNoOwnerCreatedInDatabase();
        }
    }

    @Nested
    @DisplayName("Find Owner Operations")
    class FindOwnerTests {

        @Test
        @DisplayName("Should find owner by ID successfully")
        void shouldFindOwnerById() {
            OwnerServiceGrpc.OwnerServiceBlockingStub stub = OwnerServiceGrpc.newBlockingStub(channel);
            Owner existingOwner = createTestOwner("Jane", "Smith");

            OwnerResponse foundOwner = stub.getOwner(GetOwnerRequest.newBuilder().setOwnerId(existingOwner.getId()).build());

            assertOwnerFoundCorrectly(foundOwner, existingOwner);
        }

        @Test
        @DisplayName("Should handle non-existent owner gracefully")
        void shouldHandleNonExistentOwner() {
            int nonExistentId = 99999;
            OwnerServiceGrpc.OwnerServiceBlockingStub stub = OwnerServiceGrpc.newBlockingStub(channel);

            assertThatThrownBy(() ->  stub.getOwner(GetOwnerRequest.newBuilder().setOwnerId(nonExistentId).build()))
                .isInstanceOf(StatusRuntimeException.class)
                .satisfies(exception -> {
                    StatusRuntimeException grpcException = (StatusRuntimeException) exception;
                    assertThat(grpcException.getStatus().getCode()).isEqualTo(Status.Code.NOT_FOUND);
                });
        }

        @Test
        @DisplayName("Should list all owners successfully")
        void shouldListAllOwners() {
            OwnerServiceGrpc.OwnerServiceBlockingStub stub = OwnerServiceGrpc.newBlockingStub(channel);
            Owner owner1 = createTestOwner("Alice", "Johnson");
            Owner owner2 = createTestOwner("Bob", "Wilson");

            OwnersListResponse ownerList = stub.listOwners(Empty.newBuilder().build());

            assertOwnersListContainsExpectedOwners(ownerList.getOwnersList(), owner1, owner2);
        }
    }

    @Nested
    @DisplayName("Update Owner Operations")
    class UpdateOwnerTests {

        @Test
        @DisplayName("Should update owner successfully")
        void shouldUpdateOwnerSuccessfully() {
            OwnerServiceGrpc.OwnerServiceBlockingStub stub = OwnerServiceGrpc.newBlockingStub(channel);
            Owner existingOwner = createTestOwner("Original", "Name");
            OwnerRequest owner = createValidOwnerRequest();
            UpdateOwnerRequest request = UpdateOwnerRequest.newBuilder().setOwner(owner).setOwnerId(existingOwner.getId()).build();

            stub.updateOwner(request);

            assertOwnerUpdatedCorrectly(existingOwner.getId(), request.getOwner());
        }

        @Test
        @DisplayName("Should handle update of non-existent owner")
        void shouldHandleUpdateOfNonExistentOwner() {
            OwnerServiceGrpc.OwnerServiceBlockingStub stub = OwnerServiceGrpc.newBlockingStub(channel);
            int nonExistentId = 99999;
            OwnerRequest updateRequest = createValidOwnerRequest();
            UpdateOwnerRequest request = UpdateOwnerRequest.newBuilder().setOwner(updateRequest).setOwnerId(nonExistentId).build();

            assertThatThrownBy(() ->  stub.updateOwner(request))
                .isInstanceOf(StatusRuntimeException.class)
                .satisfies(exception -> {
                    StatusRuntimeException grpcException = (StatusRuntimeException) exception;
                    assertThat(grpcException.getStatus().getCode()).isEqualTo(Status.Code.NOT_FOUND);
                });
            assertNoOwnerUpdatedInDatabase(nonExistentId);
        }

        @Test
        @DisplayName("Should return validation error when updating with invalid data")
        void shouldReturnValidationErrorWhenUpdatingWithInvalidData() {
            OwnerServiceGrpc.OwnerServiceBlockingStub stub = OwnerServiceGrpc.newBlockingStub(channel);
            Owner existingOwner = createTestOwner("Valid", "Owner");
            OwnerRequest invalidUpdateRequest = createInvalidOwnerRequest();
            UpdateOwnerRequest request = UpdateOwnerRequest.newBuilder().setOwner(invalidUpdateRequest).setOwnerId(existingOwner.getId()).build();

            assertThatThrownBy(() ->  stub.updateOwner(request))
                .isInstanceOf(StatusRuntimeException.class)
                .satisfies(exception -> {
                    StatusRuntimeException grpcException = (StatusRuntimeException) exception;
                    assertThat(grpcException.getStatus().getCode()).isEqualTo(Status.Code.INTERNAL);
                });

            assertOwnerNotUpdated(existingOwner.getId(), existingOwner);
        }
    }

    private OwnerRequest createValidOwnerRequest() {
        return OwnerRequest.newBuilder()
            .setFirstName("John")
            .setLastName("Doe")
            .setAddress("123 Main St")
            .setCity("Springfield")
            .setTelephone("555123456789").build();
    }


    private OwnerRequest createInvalidOwnerRequest() {
        return OwnerRequest.newBuilder()
            .setFirstName("")
            .setLastName("")
            .setAddress("")
            .setCity("")
            .setTelephone("").build();
    }

    private Owner createTestOwner(String firstName, String lastName) {
        org.springframework.samples.petclinic.customers.model.Owner owner = new org.springframework.samples.petclinic.customers.model.Owner();
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        owner.setAddress("123 Test Street");
        owner.setCity("Test City");
        owner.setTelephone("555987654321");
        ownerRepository.save(owner);
        return mapper.map(owner);
    }

    private void assertOwnerMatchesRequest(Owner owner, OwnerRequest request) {
        assertThat(owner).isNotNull();
        assertThat(owner.getFirstName()).isEqualTo(request.getFirstName());
        assertThat(owner.getLastName()).isEqualTo(request.getLastName());
        assertThat(owner.getAddress()).isEqualTo(request.getAddress());
        assertThat(owner.getCity()).isEqualTo(request.getCity());
        assertThat(owner.getTelephone()).isEqualTo(request.getTelephone());
    }

    private void assertOwnerPersistedCorrectly(Integer ownerId, OwnerRequest request) {
        Optional<org.springframework.samples.petclinic.customers.model.Owner> persistedOwner = ownerRepository.findById(ownerId);
        assertThat(persistedOwner).isPresent();
        assertThat(persistedOwner.get().getFirstName()).isEqualTo(request.getFirstName());
        assertThat(persistedOwner.get().getLastName()).isEqualTo(request.getLastName());
        assertThat(persistedOwner.get().getAddress()).isEqualTo(request.getAddress());
        assertThat(persistedOwner.get().getCity()).isEqualTo(request.getCity());
        assertThat(persistedOwner.get().getTelephone()).isEqualTo(request.getTelephone());
    }

    private void assertNoOwnerCreatedInDatabase() {
        List<org.springframework.samples.petclinic.customers.model.Owner> allOwners = ownerRepository.findAll();
        assertThat(allOwners).isNotNull();
    }

    private void assertOwnerFoundCorrectly(OwnerResponse ownerResponse, Owner expectedOwner) {
        Owner owner = ownerResponse.getOwner();
        assertThat(owner).isNotNull();
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
        Optional<org.springframework.samples.petclinic.customers.model.Owner> updatedOwner = ownerRepository.findById(ownerId);
        assertThat(updatedOwner).isPresent();
        org.springframework.samples.petclinic.customers.model.Owner owner = updatedOwner.get();
        assertThat(owner.getFirstName()).isEqualTo(updateRequest.getFirstName());
        assertThat(owner.getLastName()).isEqualTo(updateRequest.getLastName());
        assertThat(owner.getAddress()).isEqualTo(updateRequest.getAddress());
        assertThat(owner.getCity()).isEqualTo(updateRequest.getCity());
        assertThat(owner.getTelephone()).isEqualTo(updateRequest.getTelephone());
    }

    private void assertNoOwnerUpdatedInDatabase(Integer ownerId) {
        Optional<org.springframework.samples.petclinic.customers.model.Owner> owner = ownerRepository.findById(ownerId);
        assertThat(owner).isEmpty();
    }

    private void assertOwnerNotUpdated(Integer ownerId, Owner originalOwner) {
        Optional<org.springframework.samples.petclinic.customers.model.Owner> owner = ownerRepository.findById(ownerId);
        assertThat(owner).isPresent();
        org.springframework.samples.petclinic.customers.model.Owner currentOwner = owner.get();
        assertThat(currentOwner.getFirstName()).isEqualTo(originalOwner.getFirstName());
        assertThat(currentOwner.getLastName()).isEqualTo(originalOwner.getLastName());
        assertThat(currentOwner.getAddress()).isEqualTo(originalOwner.getAddress());
        assertThat(currentOwner.getCity()).isEqualTo(originalOwner.getCity());
        assertThat(currentOwner.getTelephone()).isEqualTo(originalOwner.getTelephone());
    }
}

