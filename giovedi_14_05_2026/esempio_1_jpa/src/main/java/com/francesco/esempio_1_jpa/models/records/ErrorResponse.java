package com.francesco.esempio_1_jpa.models.records;

import java.time.LocalDateTime;

public record ErrorResponse(
        String message,
        int status,
        LocalDateTime timestamp) {

}
