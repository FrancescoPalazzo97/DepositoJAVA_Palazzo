package com.francesco.esercizio_1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Title must not be null, nor empty or blank")
    @Size(min = 3, max = 100, message = "Title must be higher than 3 and lower than 100")
    private String title;

    @NotBlank(message = "Author must not be null, nor empty or blank")
    @Size(min = 3, max = 100, message = "Author must be higher than 3 and lower than 100")
    private String author;

    @NotNull(message = "Pages cannot be null")
    @Positive(message = "Pages must be positive")
    private Integer pages;

    @NotNull(message = "Genre cannot be null")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return this.pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", title='" + getTitle() + "'" +
                ", author='" + getAuthor() + "'" +
                ", pages='" + getPages() + "'" +
                ", genre='" + getGenre() + "'" +
                "}";
    }

}
