package com.irrigation.system.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irrigation.system.entity.Alerts;
import com.irrigation.system.entity.Plot;
import com.irrigation.system.entity.Sensor;
import com.irrigation.system.entity.SlotStatus;
import com.irrigation.system.entity.Slots;
import com.irrigation.system.exceptions.BadRequestException;
import com.irrigation.system.exceptions.SensorNotAvailableException;
import com.irrigation.system.repository.AlertRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IrrigationTriggerService {

	@Autowired
	PlotService plotService;

	@Autowired
	SlotsService slotsService;

	@Autowired
	SlotStatusService slotStatusService;

	@Autowired
	SensorService sensorService;

	@Autowired
	AlertRepository alertRepo;

	public void initiate(Integer plotId) {

		Plot plot = plotService.getById(plotId);
		LocalTime now = LocalTime.now();
		LocalTime current = LocalTime.of(now.getHour(), now.getMinute());
		log.info("==========" + current.toString());
		Optional<Slots> slot = slotsService.getByPlotAndTime(plot, current);

		if (slot.isEmpty()) {
			throw new BadRequestException("Please call when time to irrigate");
		}

		Optional<SlotStatus> slotstatus = slotStatusService.getByTimeAndDateAndSlot(slot.get(), current,
				LocalDate.now());

		if (slotstatus.isEmpty()) {
			checkSensor(slot.get(), slot.get().getSensor());
			slotStatusService.save(
					SlotStatus.builder().date(LocalDate.now()).slot(slot.get()).status("done").time(current).build());

		}

	}

	private void checkSensor(Slots slot, Sensor sensor) {
		try {
			sensorService.checkSensorStatus(sensor);
		} catch (SensorNotAvailableException e) {
			alertRepo.save(Alerts.builder().alertTime(LocalDateTime.now()).message("Sensor is not active").retryCalls(3)
					.slot(slot).build());
			slotStatusService.save(SlotStatus.builder().date(LocalDate.now()).slot(slot).status("FAILED")
					.time(LocalTime.now()).build());
			throw new SensorNotAvailableException("Irrigation not possible");
		}

	}

}
