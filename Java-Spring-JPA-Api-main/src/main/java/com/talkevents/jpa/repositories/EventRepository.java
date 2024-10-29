package com.talkevents.jpa.repositories;

import com.talkevents.jpa.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {

    Event findEventByName(String name);

    @Query(value = "SELECT * FROM event WHERE date = :date", nativeQuery = true)
    List<Event> findEventsByDate(@Param("date") LocalDateTime date);
}
