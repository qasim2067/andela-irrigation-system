package com.irrigation.system.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.irrigation.system.dto.mapper.SensorMapper;
import com.irrigation.system.dto.request.SensorRequest;
import com.irrigation.system.dto.response.SensorResponse;
import com.irrigation.system.entity.Sensor;
import com.irrigation.system.exceptions.BadRequestException;
import com.irrigation.system.exceptions.SensorNotAvailableException;
import com.irrigation.system.repository.SensorRepository;

@Service
public class SensorService {

	@Autowired
	SensorRepository sensorRepository;

	public SensorResponse create(SensorRequest request) {

		Optional<Sensor> sensor = sensorRepository.findByDeviceUniqueIdentifier(request.getDeviceUniqueIdentifier());

		if (sensor.isPresent()) {
			throw new BadRequestException(
					"Sensor " + request.getDeviceUniqueIdentifier() + " is already present, duplicate not allowed");
		}

		Sensor entity = sensorRepository.save(SensorMapper.INSTANCE.sourceToDestination(request));

		return SensorMapper.INSTANCE.sensorToSensorResponseDTO(entity);
	}

	/**
	 * 
	 * @return
	 */
	public List<SensorResponse> findAll() {

		List<Sensor> entities = sensorRepository.findAll();
		return entities.stream().map(m -> SensorMapper.INSTANCE.sensorToSensorResponseDTO(m)).collect(Collectors.toList());
	}

	protected Sensor getByIdentifier(String identifier) {
		Optional<Sensor> sensor = sensorRepository.findByDeviceUniqueIdentifier(identifier);
		return sensor
				.orElseThrow(() -> new BadRequestException("Sensor of identifier " + identifier + " does not exist"));
	}

	@Retryable(value = SensorNotAvailableException.class, maxAttempts = 3)
	protected void checkSensorStatus(Sensor sensor) {
		if (!sensor.isActive()) {
			throw new SensorNotAvailableException("Sensor is not available");
		}
	}
}
