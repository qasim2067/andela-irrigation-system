package com.irrigation.system.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irrigation.system.entity.SlotStatus;
import com.irrigation.system.entity.Slots;
import com.irrigation.system.repository.SlotStatusRepository;

@Service
public class SlotStatusService {

	@Autowired
	SlotStatusRepository slotStatusRepository;

	protected Optional<SlotStatus> getByTimeAndDateAndSlot(Slots slot, LocalTime time, LocalDate date) {

		return slotStatusRepository.findBySlotAndTimeAndDate(slot, time, date);
	}

	public SlotStatus save(SlotStatus entity) {
		return slotStatusRepository.save(entity);
	}

}
