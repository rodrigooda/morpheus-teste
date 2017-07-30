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

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IOException.class)
	protected ResponseEntity<Object> handleIOException(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "IOException: Contate o administrador do sistema";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(AppException.class)
	protected ResponseEntity<Object> handleAppException(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "AppException: Contate o administrador do sistema";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

}
