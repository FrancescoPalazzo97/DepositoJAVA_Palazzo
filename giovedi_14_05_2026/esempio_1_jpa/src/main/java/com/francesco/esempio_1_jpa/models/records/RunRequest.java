package com.francesco.esempio_1_jpa.models.records;

import java.time.LocalDateTime;

import com.francesco.esempio_1_jpa.models.Location;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record RunRequest(
        @NotBlank(message = "Title cannot be blank, nor empty or null") @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters") String title,

        @NotNull(message = "Start date cannot be null") @PastOrPresent(message = "Start date cannot be in the future") LocalDateTime startedOn,

        @NotNull(message = "End date cannot be null") @FutureOrPresent(message = "End date cannot be in the past") LocalDateTime completedOn,

        @Positive(message = "Miles must be a positive value") @Max(value = 200, message = "Miles cannot exceed 200") int miles,

        @NotNull(message = "Location cannot be null") Location location) {

}
