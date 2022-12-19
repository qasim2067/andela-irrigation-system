package com.irrigation.system.exceptions;

import lombok.Getter;

@Getter
public class SensorNotAvailableException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2891671808105516750L;

	private String message;

	public SensorNotAvailableException(String message) {
		super(message);
		this.message = message;
	}

}
