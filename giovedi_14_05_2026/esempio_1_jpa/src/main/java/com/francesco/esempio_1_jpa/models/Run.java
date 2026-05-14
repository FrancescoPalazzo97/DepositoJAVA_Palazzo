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

@Entity
@Table(name = "runs")
public class Run {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "startedOn", nullable = false)
    private LocalDateTime startedOn;

    @Column(name = "completedOn", nullable = false)
    private LocalDateTime completedOn;

    @Column(name = "miles", nullable = false)
    private Integer miles;

    @Enumerated(EnumType.STRING)
    @Column(name = "location", nullable = false)
    private Location location;

    protected Run() {
    }

    public Run(
            String title,
            LocalDateTime startedOn,
            LocalDateTime completedOn,
            Integer miles,
            Location location) {
        if (miles < 0) {
            throw new IllegalArgumentException("Le miglia non possono essere negative");
        }
        if (completedOn.isBefore(startedOn)) {
            throw new IllegalArgumentException("La data di fine deve essere dopo quella di inizio");
        }

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
