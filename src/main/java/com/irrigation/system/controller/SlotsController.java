package com.irrigation.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irrigation.system.dto.request.SlotRequest;
import com.irrigation.system.service.SlotsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/slots")
public class SlotsController extends BaseController {

	@Autowired
	SlotsService slotsService;

	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody SlotRequest request) {
		return response(slotsService.create(request));
	}

	@GetMapping("/list")
	public ResponseEntity<?> findAll() {
		return response(slotsService.findAll());
	}
}
