package com.francesco.esercizio_2_rest_controller.models;

import java.time.LocalDateTime;

public record RunModel(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Integer miles,
        Location location) {
    public RunModel {
        if (miles < 0) {
            miles = 0;
            throw new IllegalArgumentException("Miles cannot be -1");
        }

        if (completedOn.isBefore(startedOn)) {
            throw new IllegalArgumentException("Completed on must be after started on");
        }
    }
}
