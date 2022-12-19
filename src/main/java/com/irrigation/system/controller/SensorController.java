package com.irrigation.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irrigation.system.dto.request.SensorRequest;
import com.irrigation.system.service.SensorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sensor")
public class SensorController extends BaseController {

	@Autowired
	SensorService sensorService;

	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody SensorRequest request) {
		return response(sensorService.create(request));
	}

	@GetMapping("/list")
	public ResponseEntity<?> findAll() {
		return response(sensorService.findAll());
	}

}
