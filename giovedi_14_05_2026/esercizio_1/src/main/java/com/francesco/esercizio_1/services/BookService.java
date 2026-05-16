package com.francesco.esercizio_1.services;

import java.util.List;
import java.util.Optional;

import com.francesco.esercizio_1.exceptions.BookNotFoundException;
import com.francesco.esercizio_1.models.Book;
import com.francesco.esercizio_1.repos.BookRepo;

public class BookService {
    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    public Book getById(Integer id) {
        Optional<Book> result = bookRepo.findById(id);

        if (result.isEmpty()) {
            throw new BookNotFoundException(id);
        }

        return result.get();
    }

    public Book save(Book newBook) {
        return bookRepo.save(newBook);
    }

    public Book update(Integer id, Book updatedBook) {
        Optional<Book> result = bookRepo.findById(id);

        if (result.isEmpty()) {
            throw new BookNotFoundException(id);
        }

        updatedBook.setId(result.get().getId());

        return bookRepo.save(updatedBook);
    }

    public void delete(Integer id) {

        if (!bookRepo.existsById(id)) {
            throw new BookNotFoundException(id);
        }

        bookRepo.deleteById(id);
    }
}
