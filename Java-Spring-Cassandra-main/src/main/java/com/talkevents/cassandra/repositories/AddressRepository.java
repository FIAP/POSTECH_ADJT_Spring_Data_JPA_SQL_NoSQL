package com.talkevents.cassandra.repositories;

import com.talkevents.cassandra.models.Address;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends CassandraRepository<Address, UUID> {
}
