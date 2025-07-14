package org.springframework.samples.petclinic.api.grpc.clients;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.OwnerServiceGrpc;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.PetServiceGrpc;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnerRequest;
import org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnerResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerClient {

    private final PetServiceGrpc.PetServiceBlockingStub petStub;
    private final OwnerServiceGrpc.OwnerServiceBlockingStub ownerStub;

    public CustomerClient(
        @Value("${spring.grpc.client.customer.address}") String address,
        @Value("${spring.grpc.client.customer.port}") int port) {
        Channel channel = ManagedChannelBuilder
            .forAddress(address, port)
            .usePlaintext()
            .build();

        this.petStub = PetServiceGrpc.newBlockingStub(channel);
        this.ownerStub = OwnerServiceGrpc.newBlockingStub(channel);
    }

    public GetOwnerResponse getOwner(GetOwnerRequest request) {
        return this.ownerStub.getOwner(request);
    }
}
