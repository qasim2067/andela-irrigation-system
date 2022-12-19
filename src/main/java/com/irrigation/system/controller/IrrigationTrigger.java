package com.irrigation.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irrigation.system.service.IrrigationTriggerService;

@RestController
@RequestMapping("/irrigation")
public class IrrigationTrigger {

	@Autowired
	IrrigationTriggerService irrigationTriggerService;

	@GetMapping("/trigger/{plotId}")
	public ResponseEntity<?> trigger(@PathVariable("plotId") Integer plotId) {
		irrigationTriggerService.initiate(plotId);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

}
