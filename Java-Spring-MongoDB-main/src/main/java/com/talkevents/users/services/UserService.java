package com.talkevents.users.services;

import com.talkevents.users.documents.Address;
import com.talkevents.users.documents.User;
import com.talkevents.users.repositories.AddressRepository;
import com.talkevents.users.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {
        if (user.getAddress() != null && user.getAddress().getId() != null) {
            Address address = addressRepository.findById(user.getAddress().getId()).orElse(null);
            user.setAddress(Objects.requireNonNullElseGet(address, () -> addressRepository.save(user.getAddress())));
        } else if (user.getAddress() != null) {
            user.setAddress(addressRepository.save(user.getAddress()));
        }
        return userRepository.save(user);
    }

    public void update(User user) {
        User userToUpdate = getById(user.getId());
        if (userToUpdate != null) {
            userToUpdate.setName(user.getName());
            userToUpdate.setAge(user.getAge());

            if (user.getAddress() != null) {
                Address address = addressRepository.findById(user.getAddress().getId()).orElse(null);
                userToUpdate.setAddress(Objects.requireNonNullElseGet(address, () -> addressRepository.save(user.getAddress())));
            }
            userRepository.save(userToUpdate);
        }
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
