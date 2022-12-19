package com.irrigation.system.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	private String toStack(Exception e) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		e.printStackTrace(printWriter);
		String exceptionString = stringWriter.toString();
		return exceptionString;
	}

	public void logException(String message, StringBuffer url, Exception e) {

		StringBuilder sb = new StringBuilder();

		sb = appendLog("", sb);
		sb = appendLog(String.format("********************** Start Exception **************"), sb);

		//sb = appendLog(String.format(" | URL: %s", url.toString()), sb);

		sb = appendLog(String.format(" | Error: %s", message), sb);
		sb = appendLog(String.format(" | ERROR Details: %s", toStack(e)), sb);

		sb = appendLog(String.format("********************** End Exception **************"), sb);

		log.error(sb.toString());
	}

	private StringBuilder appendLog(String log, StringBuilder sb) {
		sb.append(System.lineSeparator());
		sb.append(log);
		return sb;
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ExceptionResponse> handleError404(HttpServletRequest request, Exception e) {
		logException("", null, e);
		ExceptionResponse obj = ExceptionResponse.of("404", e.getMessage(), "No handler found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(obj);
	}

	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<ExceptionResponse> nullPointerExceptionHandler(HttpServletRequest req,
			HttpServletResponse response, NullPointerException e) throws Exception {

		ExceptionResponse obj = ExceptionResponse.of("500", e.getMessage(), "Internal server error");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(obj);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ExceptionResponse> defaultErrorHandler(HttpServletRequest req, HttpServletResponse response,
			Exception e) throws Exception {
		logException("", null, e);
		ExceptionResponse obj = ExceptionResponse.of("500", e.getMessage(), "Unknown error, Please contact support");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(obj);
	}

	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<ExceptionResponse> badRequestException(HttpServletRequest req, HttpServletResponse response,
			BadRequestException e) throws Exception {

		ExceptionResponse obj = ExceptionResponse.of("400", e.getMessage(), "Invalid request");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(obj);
	}

	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<ExceptionResponse> notFoundException(HttpServletRequest req, HttpServletResponse response,
			NotFoundException e) throws Exception {

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
