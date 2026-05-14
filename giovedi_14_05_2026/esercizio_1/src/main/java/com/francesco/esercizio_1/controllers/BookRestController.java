package com.francesco.esercizio_1.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francesco.esercizio_1.models.Book;
import com.francesco.esercizio_1.repos.BookRepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookRestController {
    private BookRepo bookRepo;

    public BookRestController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;

    }

    @GetMapping
    public ResponseEntity<List<Book>> index() {
        return ResponseEntity.ok(bookRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> show(@PathVariable Integer id) {
        Optional<Book> optionalBook = bookRepo.findById(id);

        if (optionalBook.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optionalBook.get());
    }

    @PostMapping
    public ResponseEntity<?> store(@Valid @RequestBody Book newBook, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();

            bindingResult.getFieldErrors().forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));

            return ResponseEntity.badRequest().body(errors);
        }

        Book saved = bookRepo.save(newBook);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody Book updateBook,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();

            bindingResult.getFieldErrors().forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));

            return ResponseEntity.badRequest().body(errors);
        }

        if (!bookRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        updateBook.setId(id);
        Book updated = bookRepo.save(updateBook);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        if (!bookRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        bookRepo.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
