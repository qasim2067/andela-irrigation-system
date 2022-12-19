package com.irrigation.system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {

	/**
	 * Creates a ResponseEntity to be sent back to client
	 *
	 * @param restResponseDto holding the response object and HTTP status
	 * @return ResponseEntity with HTTP status and response object
	 */
	public static <T> ResponseEntity<T> response(T restResponseDto) {
		return new ResponseEntity<>(restResponseDto, HttpStatus.OK);
	}
}
