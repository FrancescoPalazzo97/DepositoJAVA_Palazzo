package com.francesco.esercizio_1.records;

import com.francesco.esercizio_1.models.Genre;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record BookRequest(
                @NotBlank(message = "Title cannot be null, nor empty or blank") @Size(min = 3, max = 100, message = "Title must be higher than 3 and lower than 100") String title,

                @NotBlank(message = "Author cannot be null, nor empty or blank") @Size(min = 3, max = 100, message = "Author must be higher than 3 and lower than 100") String author,

                @NotNull(message = "Pages cannot be null") @Positive(message = "Pages must be positive") Integer pages,

                @NotNull(message = "Genre cannot be null") Genre genre) {

}
