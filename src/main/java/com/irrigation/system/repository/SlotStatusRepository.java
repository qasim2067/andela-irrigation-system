package com.irrigation.system.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irrigation.system.entity.SlotStatus;
import com.irrigation.system.entity.Slots;

@Repository
public interface SlotStatusRepository extends JpaRepository<SlotStatus, Integer> {

	Optional<SlotStatus> findBySlotAndTimeAndDate(Slots slot, LocalTime time, LocalDate date);
}
