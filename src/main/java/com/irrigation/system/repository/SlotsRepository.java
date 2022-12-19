package com.irrigation.system.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irrigation.system.entity.Plot;
import com.irrigation.system.entity.Slots;

@Repository
public interface SlotsRepository extends JpaRepository<Slots, Integer> {

	Optional<Slots> findByPlotAndStartTimeAndDate(Plot plot, LocalTime startTime, LocalDate date);

	Optional<Slots> findByPlotAndStartTime(Plot plot, LocalTime startTime);
}
