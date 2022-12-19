package com.irrigation.system.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irrigation.system.dto.request.PlotRequest;
import com.irrigation.system.dto.response.PlotResponse;
import com.irrigation.system.exceptions.NotFoundException;
import com.irrigation.system.service.PlotService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/plot")
public class PlotController extends BaseController {

	@Autowired
	PlotService plotService;

	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody PlotRequest request) {
		return response(plotService.save(request));
	}

	@GetMapping("/list")
	public ResponseEntity<?> findAll() {
		return response(plotService.findAll());
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@PathVariable Integer id, @Valid @RequestBody PlotRequest request) {
		Optional<PlotResponse> response = plotService.edit(id, request);

		return response.map(p -> response(p))
				.orElseThrow(() -> new NotFoundException("Plot " + id + " does not exist"));
	}
}
