package com.irrigation.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irrigation.system.service.AlertService;

@RestController
@RequestMapping("/alert")
public class AlertController extends BaseController {

	@Autowired
	AlertService service;

	@GetMapping("/list")
	public ResponseEntity<?> findAll() {
		return response(service.findAll());
	}

}
