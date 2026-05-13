package com.francesco.esercizio_2_rest_controller.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import com.francesco.esercizio_2_rest_controller.models.Location;
import com.francesco.esercizio_2_rest_controller.models.RunModel;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/runs")
public class RunRestController {
    private List<RunModel> runs;

    public RunRestController() {
        runs = new ArrayList<>(List.of(
                new RunModel(1, "Corsa al parco",
                        LocalDateTime.of(2026, 5, 10, 7, 30),
                        LocalDateTime.of(2026, 5, 10, 8, 15),
                        5,
                        Location.OUTDOOR),
                new RunModel(2, "Allenamento tapis roulant",
                        LocalDateTime.of(2026, 5, 11, 18, 0),
                        LocalDateTime.of(2026, 5, 11, 18, 35),
                        3,
                        Location.INDOOR),
                new RunModel(3, "Lungo domenicale",
                        LocalDateTime.of(2026, 5, 12, 9, 0),
                        LocalDateTime.of(2026, 5, 12, 10, 20),
                        8,
                        Location.OUTDOOR)));
    }

    @GetMapping
    public ResponseEntity<List<RunModel>> index() {
        return ResponseEntity.ok(runs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RunModel> show(@PathVariable int id) {
        RunModel foundedRun = null;

        for (RunModel run : runs) {
            if (run.id() == id) {
                foundedRun = run;
                break;
            }
        }

        if (foundedRun == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(foundedRun);
    }

    @PostMapping
    public ResponseEntity<RunModel> create(@RequestBody RunModel newRun) {
        runs.add(newRun);

        return ResponseEntity.ok(newRun);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RunModel> update(@PathVariable int id, @RequestBody RunModel updatedRun) {
        int index = findIndexById(id);

        if (index == -1) {
            return ResponseEntity.notFound().build();
        }

        runs.set(index, updatedRun);

        return ResponseEntity.ok(updatedRun);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RunModel> delete(@PathVariable int id) {
        int index = findIndexById(id);

        if (index == -1) {
            return ResponseEntity.notFound().build();
        }

        RunModel deletedRun = runs.remove(index);

        return ResponseEntity.ok(deletedRun);
    }

    private int findIndexById(int id) {
        for (int i = 0; i < runs.size(); i++) {
            if (runs.get(i).id() == id) {
                return i;
            }
        }

        return -1;
    }

}
