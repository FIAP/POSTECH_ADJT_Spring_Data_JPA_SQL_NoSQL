package com.talkevents.jpa.services;

import com.talkevents.jpa.dtos.SaveAttendeeRecordDto;
import com.talkevents.jpa.dtos.UpdateAttendeeRecordDto;
import com.talkevents.jpa.entities.Attendee;
import com.talkevents.jpa.repositories.AttendeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AttendeeService {

    private final AttendeeRepository attendeeRepository;

    public AttendeeService(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    public Attendee saveAttendee(SaveAttendeeRecordDto input) {
        var attendee = new Attendee();

        attendee.setName(input.name());
        attendee.setEmail(input.email());

        return attendeeRepository.save(attendee);
    }

    public void updateAttendee(UpdateAttendeeRecordDto input) {
        var attendee = attendeeRepository.findById(input.id()).orElseThrow(() -> new EntityNotFoundException("Attendee not found"));

        attendee.setName(input.name());
        attendee.setEmail(input.email());

        attendeeRepository.save(attendee);
    }

    public void deleteAttendee(UUID id) {
        var attendee = attendeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Attendee not found"));
        attendeeRepository.delete(attendee);
    }

    public Attendee getAttendee(UUID id) {
        return attendeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Attendee not found"));
    }

    public List<Attendee> getAllAttendees() {
        return attendeeRepository.findAll();
    }
}
