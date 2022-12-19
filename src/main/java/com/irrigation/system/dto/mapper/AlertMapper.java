package com.irrigation.system.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.irrigation.system.dto.response.AlertResponse;
import com.irrigation.system.entity.Alerts;

@Mapper
public interface AlertMapper {

	AlertMapper INSTANCE = Mappers.getMapper(AlertMapper.class);

	AlertResponse toResponse(Alerts entity);
}
