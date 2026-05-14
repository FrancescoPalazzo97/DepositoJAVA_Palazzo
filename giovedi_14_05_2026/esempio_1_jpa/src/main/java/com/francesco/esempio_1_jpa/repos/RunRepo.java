package com.francesco.esempio_1_jpa.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.francesco.esempio_1_jpa.models.LocationEnum;
import com.francesco.esempio_1_jpa.models.Run;

@Repository
public interface RunRepo extends JpaRepository<Run, Integer> {

    List<Run> findByTitle(String title);

    List<Run> findByMilesGreaterThan(Integer id);

    List<Run> findByLocation(LocationEnum location);

    List<Run> findByLocationAndMilesGreaterThan(LocationEnum location, Integer id);

    Optional<Run> findFirstByTitle(String title);

    boolean existsByTitle(String title);

    @Query("SELECT r FROM Run r WHERE r.location = :location ORDER BY r.miles DESC")
    List<Run> findByLocationOrdrByMiles(@Param("location") LocationEnum location);
}
