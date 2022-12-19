package com.irrigation.system.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irrigation.system.dto.mapper.PlotsMapper;
import com.irrigation.system.dto.request.PlotRequest;
import com.irrigation.system.dto.response.PlotResponse;
import com.irrigation.system.entity.Plot;
import com.irrigation.system.exceptions.BadRequestException;
import com.irrigation.system.repository.PlotsRepository;

@Service
public class PlotService {

	@Autowired
	PlotsRepository plotsRepository;

	/**
	 * 
	 * @param request
	 * @return
	 */
	public PlotResponse save(PlotRequest request) {

		Plot entity = plotsRepository.save(PlotsMapper.INSTANCE.sourceToDestination(request));

		return PlotsMapper.INSTANCE.plotToPlotResponseDTO(entity);
	}

	/**
	 * 
	 * @param id
	 * @param request
	 * @return
	 */

	public Optional<PlotResponse> edit(Integer id, PlotRequest request) {

		Optional<Plot> update = plotsRepository.findById(id);

		if (update.isPresent()) {
			Plot entity = PlotsMapper.INSTANCE.sourceToDestination(request);
			entity.setId(update.get().getId());
			plotsRepository.save(entity);
			return Optional.of(PlotsMapper.INSTANCE.plotToPlotResponseDTO(entity));
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @return
	 */
	public List<PlotResponse> findAll() {

		List<Plot> entities = plotsRepository.findAll();
		return entities.stream().map(m -> PlotsMapper.INSTANCE.plotToPlotResponseDTO(m)).collect(Collectors.toList());
	}

	/**
	 * 
	 * @param Id
	 * @return
	 */
	protected Plot getById(Integer Id) {
		Optional<Plot> plot = plotsRepository.findById(Id);
		return plot.orElseThrow(() -> new BadRequestException("Plot " + Id + " does not exist"));
	}

}
