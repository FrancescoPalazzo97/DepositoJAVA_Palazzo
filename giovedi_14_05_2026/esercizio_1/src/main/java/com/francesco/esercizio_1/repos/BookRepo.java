package com.francesco.esercizio_1.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.francesco.esercizio_1.models.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
