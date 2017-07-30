package com.morpheus.app.controller;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.morpheus.app.exception.AppException;
import com.morpheus.app.exception.ExceptionResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(IOException.class)
	protected ResponseEntity<ExceptionResponse> handleIOException(IOException ex, WebRequest request) {
		ExceptionResponse er = new ExceptionResponse();
		er.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		er.setDescription(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AppException.class)
	protected ResponseEntity<ExceptionResponse> handleAppException(AppException ex, WebRequest request) {
		ExceptionResponse er = new ExceptionResponse();
		er.setCode(HttpStatus.BAD_REQUEST.value());
		er.setDescription(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.BAD_REQUEST);
	}

}
