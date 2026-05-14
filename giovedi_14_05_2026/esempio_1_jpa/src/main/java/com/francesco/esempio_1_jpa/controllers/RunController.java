package com.francesco.esempio_1_jpa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francesco.esempio_1_jpa.models.Run;
import com.francesco.esempio_1_jpa.repos.RunRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/runs")
public class RunController {
    private RunRepo runRepo;

    public RunController(RunRepo runRepo) {
        this.runRepo = runRepo;
    }

    @GetMapping
    public ResponseEntity<List<Run>> index() {
        return ResponseEntity.ok(runRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Run> show(@RequestParam Integer id) {
        Optional<Run> optional = runRepo.findById(id);

        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optional.get());

        // return
        // optional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Run> create(@RequestBody Run run) {
        Run saved = runRepo.save(run);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Run> update(@PathVariable Integer id, @RequestBody Run runDetails) {
        Optional<Run> optional = runRepo.findById(id);

        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Run run = optional.get();
        run.setTitle(runDetails.getTitle());
        run.setStartedOn(runDetails.getStartedOn());
        run.setCompletedOn(runDetails.getCompletedOn());
        run.setMiles(runDetails.getMiles());
        run.setLocation(runDetails.getLocation());
        Run update = runRepo.save(run);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!runRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        runRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
