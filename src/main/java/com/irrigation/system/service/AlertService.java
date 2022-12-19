package com.irrigation.system.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irrigation.system.dto.mapper.AlertMapper;
import com.irrigation.system.dto.response.AlertResponse;
import com.irrigation.system.entity.Alerts;
import com.irrigation.system.repository.AlertRepository;

@Service
public class AlertService {

	@Autowired
	AlertRepository alertRepository;
	
	/**
	 * 
	 * @return
	 */
	public List<AlertResponse> findAll() {

		List<Alerts> entities = alertRepository.findAll();
		return entities.stream().map(m -> AlertMapper.INSTANCE.toResponse(m)).collect(Collectors.toList());
	}

}
