package org.springframework.samples.petclinic.api.boundary.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.samples.petclinic.api.application.VisitsServiceClient;
import org.springframework.samples.petclinic.api.dto.*;
import org.springframework.samples.petclinic.api.grpc.clients.CustomerClient;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnerResponse;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = ApiGatewayController.class)
@Import({ReactiveResilience4JAutoConfiguration.class, CircuitBreakerConfiguration.class})
class ApiGatewayControllerTest {

    @MockBean
    private CustomerClient customersServiceClient;

    @MockBean
    private VisitsServiceClient visitsServiceClient;

    @Autowired
    private WebTestClient client;


    @Test
    void getOwnerDetails_withAvailableVisitsService() {
        Pet cat = Pet.newBuilder()
            .setId(20)
            .setName("Garfield")
            .build();

        GetOwnerResponse ownerResponse = GetOwnerResponse.newBuilder()
                .setOwner(Owner.newBuilder().addPets(cat)).build();
        Mockito
            .when(customersServiceClient.getOwner(Mockito.any()))
            .thenReturn(ownerResponse);

        VisitDetails visit = new VisitDetails(300, cat.getId(), null, "First visit");
        Visits visits = new Visits(List.of(visit));
        Mockito
            .when(visitsServiceClient.getVisitsForPets(Collections.singletonList(cat.getId())))
            .thenReturn(Mono.just(visits));

        client.get()
            .uri("/api/gateway/owners/1")
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.pets[0].name").isEqualTo("Garfield")
            .jsonPath("$.pets[0].visits[0].description").isEqualTo("First visit");
    }

    /**
     * Test Resilience4j fallback method
     */
    @Test
    void getOwnerDetails_withServiceError() {
        Pet cat = Pet.newBuilder()
            .setId(20)
            .setName("Garfield")
            .build();

        GetOwnerResponse ownerResponse = GetOwnerResponse.newBuilder()
            .setOwner(Owner.newBuilder().addPets(cat)).build();
        Mockito
            .when(customersServiceClient.getOwner(Mockito.any()))
            .thenReturn(ownerResponse);

        Mockito
            .when(visitsServiceClient.getVisitsForPets(Collections.singletonList(cat.getId())))
            .thenReturn(Mono.error(new ConnectException("Simulate error")));

        client.get()
            .uri("/api/gateway/owners/1")
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.pets[0].name").isEqualTo("Garfield")
            .jsonPath("$.pets[0].visits").isEmpty();
    }

}
