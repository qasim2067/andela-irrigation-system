package com.irrigation.system.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.irrigation.system.dto.request.SensorRequest;
import com.irrigation.system.dto.response.SensorResponse;
import com.irrigation.system.entity.Sensor;

@Mapper
public interface SensorMapper {

	SensorMapper INSTANCE = Mappers.getMapper(SensorMapper.class);

	Sensor sourceToDestination(SensorRequest source);

	@Mapping(target = "sensorId", source = "entity.id")
	SensorResponse sensorToSensorResponseDTO(Sensor entity);
}
