package com.francesco.esempio_1_jpa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francesco.esempio_1_jpa.models.Run;
import com.francesco.esempio_1_jpa.services.RunService;

import jakarta.validation.Valid;

import java.util.List;

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
    private RunService runService;

    public RunController(RunService runService) {
        this.runService = runService;
    }

    @GetMapping
    public ResponseEntity<List<Run>> index() {
        List<Run> runs = runService.findAll();

        return ResponseEntity.ok(runs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Run> show(@PathVariable Integer id) {
        Run result = runService.getById(id);

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Run> store(@Valid @RequestBody Run run) {
        Run saved = runService.create(run);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Run> update(@PathVariable Integer id, @Valid @RequestBody Run runDetails) {
        Run result = runService.update(id, runDetails);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        runService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
