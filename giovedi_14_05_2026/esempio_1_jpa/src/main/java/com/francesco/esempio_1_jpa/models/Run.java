package com.francesco.esempio_1_jpa.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "runs")
public class Run {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false, length = 100)
    @NotBlank(message = "The title cannot be null, nor empty or blank")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @Column(name = "startedOn", nullable = false)
    @NotNull(message = "Start date cannot be null")
    @PastOrPresent(message = "Start date cannot be in the future")
    private LocalDateTime startedOn;

    @Column(name = "completedOn", nullable = false)
    @NotNull(message = "End date cannot be null")
    @FutureOrPresent(message = "End date cannot be in the past")
    private LocalDateTime completedOn;

    @Column(name = "miles", nullable = false)
    @Positive(message = "Miles must be a positive value")
    @Max(value = 200, message = "Miles cannot exceed 200")
    private Integer miles;

    @Column(name = "location", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Location cannot be null")
    private Location location;

    public Run() {
    }

    public Run(String title, LocalDateTime startedOn, LocalDateTime completedOn, Integer miles, Location location) {
        this.title = title;
        this.startedOn = startedOn;
        this.completedOn = completedOn;
        this.miles = miles;
        this.location = location;
    }

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

    public LocalDateTime getStartedOn() {
        return this.startedOn;
    }

    public void setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
    }

    public LocalDateTime getCompletedOn() {
        return this.completedOn;
    }

    public void setCompletedOn(LocalDateTime completedOn) {
        this.completedOn = completedOn;
    }

    public Integer getMiles() {
        return this.miles;
    }

    public void setMiles(Integer miles) {
        this.miles = miles;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", title='" + getTitle() + "'" +
                ", startedOn='" + getStartedOn() + "'" +
                ", completedOn='" + getCompletedOn() + "'" +
                ", miles='" + getMiles() + "'" +
                ", location='" + getLocation() + "'" +
                "}";
    }

}
