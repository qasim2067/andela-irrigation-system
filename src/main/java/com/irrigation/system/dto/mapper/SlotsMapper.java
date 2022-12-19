package com.irrigation.system.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.irrigation.system.dto.request.SlotRequest;
import com.irrigation.system.dto.response.SlotsResponse;
import com.irrigation.system.entity.Slots;

@Mapper
public interface SlotsMapper {

	SlotsMapper INSTANCE = Mappers.getMapper(SlotsMapper.class);

	Slots sourceToDestination(SlotRequest source);

	@Mapping(target = "slotId", source = "entity.id")
	@Mapping(target = "sensorDeviceId", source = "entity.sensor.deviceUniqueIdentifier")
	SlotsResponse slotsToSlotResponseDTO(Slots entity);
}
