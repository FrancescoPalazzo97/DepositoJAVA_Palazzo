package com.francesco.esempio_1_jpa.exceptions;

public class RunNotFoundException extends RuntimeException {
    public RunNotFoundException(Integer id) {
        super("Run con id: " + id + " non trovato!");
    }
}
