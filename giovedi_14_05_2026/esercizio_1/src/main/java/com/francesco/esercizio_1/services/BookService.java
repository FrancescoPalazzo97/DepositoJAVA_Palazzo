package com.francesco.esercizio_1.services;

import java.util.List;
import java.util.Optional;

import com.francesco.esercizio_1.exceptions.BookNotFoundException;
import com.francesco.esercizio_1.models.Book;
import com.francesco.esercizio_1.records.BookRequest;
import com.francesco.esercizio_1.records.BookResponse;
import com.francesco.esercizio_1.repos.BookRepo;

public class BookService {
    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<BookResponse> findAll() {
        return bookRepo
                .findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public BookResponse getById(Integer id) {
        Optional<Book> result = bookRepo.findById(id);

        if (result.isEmpty()) {
            throw new BookNotFoundException(id);
        }

        return toResponse(result.get());
    }

    public BookResponse save(BookRequest newBookRequest) {
        Book newBook = toEntity(newBookRequest);
        Book savedBook = bookRepo.save(newBook);
        return toResponse(savedBook);
    }

    public BookResponse update(Integer id, BookRequest bookRequestUpdate) {
        Optional<Book> result = bookRepo.findById(id);

        if (result.isEmpty()) {
            throw new BookNotFoundException(id);
        }

        Book bookUpdate = toEntity(bookRequestUpdate);
        bookUpdate.setId(result.get().getId());
        Book updatedBook = bookRepo.save(bookUpdate);

        return toResponse(updatedBook);
    }

    public void delete(Integer id) {

        if (!bookRepo.existsById(id)) {
            throw new BookNotFoundException(id);
        }

        bookRepo.deleteById(id);
    }

    private Book toEntity(BookRequest bookRequest) {
        return new Book(
                bookRequest.title(),
                bookRequest.author(),
                bookRequest.pages(),
                bookRequest.genre());
    }

    private BookResponse toResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPages(),
                book.getGenre());
    }
}
