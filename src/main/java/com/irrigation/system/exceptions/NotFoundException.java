package com.irrigation.system.exceptions;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2891671808105516750L;

	private String message;

	public NotFoundException(String message) {
		super(message);
		this.message = message;
	}

}
