package com.francesco.esempio_1_jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.francesco.esempio_1_jpa.exceptions.RunNotFoundException;
import com.francesco.esempio_1_jpa.models.Run;
import com.francesco.esempio_1_jpa.repos.RunRepo;

@Service
public class RunService {
    private final RunRepo runRepo;

    public RunService(RunRepo runRepo) {
        this.runRepo = runRepo;
    }

    public List<Run> findAll() {
        return runRepo.findAll();
    }

    public Run getById(Integer id) {
        Optional<Run> optional = runRepo.findById(id);

        if (optional.isEmpty()) {
            throw new RunNotFoundException(id);
        }

        return optional.get();
    }

    public Optional<Run> findById(Integer id) {
        return runRepo.findById(id);
    }

    public Run create(Run newRun) {
        return runRepo.save(newRun);
    }

    public Run update(Integer id, Run updatedRun) {
        Optional<Run> optionalRun = runRepo.findById(id);

        if (optionalRun.isEmpty()) {
            throw new RunNotFoundException(id);
        }

        updatedRun.setId(optionalRun.get().getId());

        return runRepo.save(updatedRun);
    }

    public void delete(Integer id) {

        if (!runRepo.existsById(id)) {
            throw new RunNotFoundException(id);
        }

        runRepo.deleteById(id);
    }
}
