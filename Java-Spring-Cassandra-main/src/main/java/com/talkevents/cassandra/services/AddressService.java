package com.talkevents.cassandra.services;

import com.talkevents.cassandra.models.Address;
import com.talkevents.cassandra.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Address getById(UUID id) {
        return addressRepository.findById(id).orElse(null);
    }

    public Address save(Address address) {
        address.setId(UUID.randomUUID());
        return addressRepository.save(address);
    }

    public void update(Address address) {
        var addressToUpdate = getById(address.getId());

        if (addressToUpdate == null)
            return;

        addressToUpdate.setStreet(address.getStreet());
        addressToUpdate.setCity(address.getCity());
        addressToUpdate.setCountry(address.getCountry());
        addressRepository.save(addressToUpdate);
    }

    public void delete(UUID id) {
        addressRepository.deleteById(id);
    }
}
