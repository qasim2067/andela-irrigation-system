package com.irrigation.system.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionResponse {

	private String code;
	private String reason;
	private String message;

	public static ExceptionResponse of(String code, String reason, String message) {
		return ExceptionResponse.builder().code(code).message(message).reason(reason).build();
	}
}
