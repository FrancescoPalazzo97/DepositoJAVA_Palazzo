package com.francesco.esercizio_1.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francesco.esercizio_1.records.BookRequest;
import com.francesco.esercizio_1.records.BookResponse;
import com.francesco.esercizio_1.services.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookRestController {
    private BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> index() {
        List<BookResponse> books = bookService.findAll();

        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> show(@PathVariable Integer id) {
        BookResponse foundedBook = bookService.getById(id);

        return ResponseEntity.ok(foundedBook);
    }

    @PostMapping
    public ResponseEntity<BookResponse> store(@Valid @RequestBody BookRequest newBookRequest) {
        BookResponse savedBook = bookService.save(newBookRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> update(@PathVariable Integer id, @Valid @RequestBody BookRequest updateBook) {
        BookResponse updatedBook = bookService.update(id, updateBook);

        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        bookService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
