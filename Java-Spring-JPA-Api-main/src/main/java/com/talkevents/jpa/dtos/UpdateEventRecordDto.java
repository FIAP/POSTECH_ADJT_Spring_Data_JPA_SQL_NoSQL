package com.talkevents.jpa.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateEventRecordDto(UUID id,
                                   String name,
                                   LocalDateTime date) {
}
