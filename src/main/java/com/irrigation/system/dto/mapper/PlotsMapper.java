package com.irrigation.system.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.irrigation.system.dto.request.PlotRequest;
import com.irrigation.system.dto.response.PlotResponse;
import com.irrigation.system.entity.Plot;

@Mapper
public interface PlotsMapper {

	PlotsMapper INSTANCE = Mappers.getMapper(PlotsMapper.class);

	Plot sourceToDestination(PlotRequest source);

	@Mapping(target = "plotId", source = "entity.id")
	PlotResponse plotToPlotResponseDTO(Plot entity);
}
