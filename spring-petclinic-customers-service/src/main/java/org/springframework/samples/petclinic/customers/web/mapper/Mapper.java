package org.springframework.samples.petclinic.customers.web.mapper;

import com.google.protobuf.GeneratedMessage;

public interface Mapper<R, E, G extends GeneratedMessage> {
    E map(E domainEntity, R request);
    G map(E domainEntity);
}
