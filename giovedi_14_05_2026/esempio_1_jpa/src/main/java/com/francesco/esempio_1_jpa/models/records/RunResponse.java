package com.francesco.esempio_1_jpa.models.records;

import java.time.LocalDateTime;

public record RunResponse(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        int miles,
        String location) {
}
