package com.talkevents.jpa.dtos;

import java.util.UUID;

public record UpdateAttendeeRecordDto(UUID id,
                                      String name,
                                      String email) {
}
