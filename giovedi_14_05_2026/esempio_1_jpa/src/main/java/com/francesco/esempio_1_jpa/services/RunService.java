package com.francesco.esempio_1_jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.francesco.esempio_1_jpa.exceptions.RunNotFoundException;
import com.francesco.esempio_1_jpa.models.Run;
import com.francesco.esempio_1_jpa.models.records.RunRequest;
import com.francesco.esempio_1_jpa.models.records.RunResponse;
import com.francesco.esempio_1_jpa.repos.RunRepo;

@Service
public class RunService {
    private final RunRepo runRepo;

    public RunService(RunRepo runRepo) {
        this.runRepo = runRepo;
    }

    public List<RunResponse> findAll() {
        return runRepo
                .findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public RunResponse getById(Integer id) {
        Optional<Run> optional = runRepo.findById(id);

        if (optional.isEmpty()) {
            throw new RunNotFoundException(id);
        }

        Run run = optional.get();

        return toResponse(run);
    }

    public RunResponse create(RunRequest newRunRequest) {
        Run newRun = toEntity(newRunRequest);
        Run saved = runRepo.save(newRun);
        return toResponse(saved);
    }

    public RunResponse update(Integer id, RunRequest updatedRunRequest) {
        Optional<Run> optional = runRepo.findById(id);

        if (optional.isEmpty()) {
            throw new RunNotFoundException(id);
        }

        Run updatedRun = toEntity(updatedRunRequest);
        updatedRun.setId(optional.get().getId());
        Run saved = runRepo.save(updatedRun);

        return toResponse(saved);
    }

    public void delete(Integer id) {

        if (!runRepo.existsById(id)) {
            throw new RunNotFoundException(id);
        }

        runRepo.deleteById(id);
    }

    private Run toEntity(RunRequest runRequest) {
        return new Run(
                runRequest.title(),
                runRequest.startedOn(),
                runRequest.completedOn(),
                runRequest.miles(),
                runRequest.location());
    }

    private RunResponse toResponse(Run run) {
        return new RunResponse(
                run.getId(),
                run.getTitle(),
                run.getStartedOn(),
                run.getCompletedOn(),
                run.getMiles(),
                run.getLocation().name());
    }
}
