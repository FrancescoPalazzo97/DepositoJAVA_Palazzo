package com.francesco.esercizio_1.records;

import com.francesco.esercizio_1.models.Genre;

public record BookResponse(
        Integer id,
        String title,
        String author,
        Integer pages,
        Genre genre) {

}
