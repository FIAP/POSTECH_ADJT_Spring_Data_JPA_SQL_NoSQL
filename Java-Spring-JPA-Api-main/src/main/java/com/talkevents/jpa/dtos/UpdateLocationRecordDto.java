package com.talkevents.jpa.dtos;

import java.util.UUID;

public record UpdateLocationRecordDto(UUID id,
                                      String name,
                                      String address,
                                      int capacity) {
}
