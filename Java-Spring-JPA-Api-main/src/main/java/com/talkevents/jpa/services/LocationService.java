package com.talkevents.jpa.services;

import com.talkevents.jpa.dtos.SaveLocationRecordDto;
import com.talkevents.jpa.dtos.UpdateLocationRecordDto;
import com.talkevents.jpa.entities.Location;
import com.talkevents.jpa.repositories.LocationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location saveLocation(SaveLocationRecordDto input) {
        var location = new Location();

        location.setName(input.name());
        location.setAddress(input.address());
        location.setCapacity(input.capacity());

        return locationRepository.save(location);
    }

    public void updateLocation(UpdateLocationRecordDto input) {
        var location = locationRepository.findById(input.id()).orElseThrow(() -> new EntityNotFoundException("Location not found"));

        location.setName(input.name());
        location.setAddress(input.address());
        location.setCapacity(input.capacity());

        locationRepository.save(location);
    }

    public void deleteLocation(UUID id) {
        var location = locationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Location not found"));
        locationRepository.delete(location);
    }

    public Location getLocation(UUID id) {
        return locationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Location not found"));
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
