package com.irrigation.system.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irrigation.system.dto.mapper.SlotsMapper;
import com.irrigation.system.dto.request.SlotRequest;
import com.irrigation.system.dto.response.SlotsResponse;
import com.irrigation.system.entity.Plot;
import com.irrigation.system.entity.Sensor;
import com.irrigation.system.entity.Slots;
import com.irrigation.system.exceptions.BadRequestException;
import com.irrigation.system.repository.SlotsRepository;

@Service
public class SlotsService {

	@Autowired
	SlotsRepository slotsRepository;


	@Autowired
	PlotService plotService;

	@Autowired
	SensorService sensorService;

	/**
	 * 
	 * @param slotRequest
	 * @return
	 */
	public SlotsResponse create(SlotRequest slotRequest) {

		Plot plot = plotService.getById(slotRequest.getPlotId());
		Sensor sensor = sensorService.getByIdentifier(slotRequest.getSensorDeviceId());

		Slots entity = SlotsMapper.INSTANCE.sourceToDestination(slotRequest);

		entity.setPlot(plot);
		entity.setSensor(sensor);

		dataValidation(entity);

		slotsRepository.save(entity);
		return SlotsMapper.INSTANCE.slotsToSlotResponseDTO(entity);
	}

	/**
	 * 
	 * @return
	 */
	public List<SlotsResponse> findAll() {

		List<Slots> entities = slotsRepository.findAll();
		return entities.stream().map(m -> SlotsMapper.INSTANCE.slotsToSlotResponseDTO(m)).collect(Collectors.toList());
	}

	private void dataValidation(Slots entity) {

		if (Objects.nonNull(entity.getDate()) && Boolean.TRUE.equals(entity.isRecurring())) {
			throw new BadRequestException("Recurring with date is not allowed for now");
		}

		Optional<Slots> slot = slotsRepository.findByPlotAndStartTimeAndDate(entity.getPlot(), entity.getStartTime(),
				entity.getDate());

		if (slot.isPresent()) {
			if (Boolean.TRUE.equals(slot.get().isRecurring()) && Objects.nonNull(slot.get().getDate()))
				throw new BadRequestException(
						"A slot for this plot with this time already exist, Overlapping & duplicate not allowed");
		}

		if (entity.getEndTime().isBefore(entity.getStartTime())) {
			throw new BadRequestException("End time cannot be before the start time");
		}

		if (Objects.nonNull(entity.getDate()) && entity.getDate().isBefore(LocalDate.now())) {
			throw new BadRequestException("Previous date not allowed");
		}

	}

	protected Optional<Slots> getByPlotAndTime(Plot plot, LocalTime startTime) {
		return slotsRepository.findByPlotAndStartTime(plot, startTime);
	}

}
