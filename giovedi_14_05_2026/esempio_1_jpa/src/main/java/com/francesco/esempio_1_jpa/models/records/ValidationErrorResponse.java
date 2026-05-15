package com.francesco.esempio_1_jpa.models.records;

import java.time.LocalDateTime;
import java.util.Map;

public record ValidationErrorResponse(
        String message,
        int status,
        LocalDateTime timestamp,
        Map<String, String> fieldErrors) {

}
