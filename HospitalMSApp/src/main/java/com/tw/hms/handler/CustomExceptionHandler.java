package com.tw.hms.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tw.hms.exception.DoctorNotFoundException;

@RestControllerAdvice

public class CustomExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<String> handleDoctorNotFoundException(DoctorNotFoundException dnfe){
		return new ResponseEntity<String>(dnfe.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
