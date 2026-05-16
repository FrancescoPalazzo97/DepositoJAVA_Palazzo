package com.francesco.esempio_1_jpa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francesco.esempio_1_jpa.models.records.RunRequest;
import com.francesco.esempio_1_jpa.models.records.RunResponse;
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
    public ResponseEntity<List<RunResponse>> index() {
        List<RunResponse> runsResponses = runService.findAll();

        return ResponseEntity.ok(runsResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RunResponse> show(@PathVariable Integer id) {
        RunResponse result = runService.getById(id);

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<RunResponse> store(@Valid @RequestBody RunRequest runRequest) {
        RunResponse saved = runService.create(runRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RunResponse> update(@PathVariable Integer id, @Valid @RequestBody RunRequest runRequest) {
        RunResponse result = runService.update(id, runRequest);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        runService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
