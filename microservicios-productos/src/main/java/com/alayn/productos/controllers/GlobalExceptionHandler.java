package com.alayn.productos.controllers;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException e){
		Throwable cause = e.getRootCause();
		if(cause != null && cause.getMessage() != null) {
			return ResponseEntity.badRequest().body("Error de integridad:" + cause.getMessage());
		}
		return ResponseEntity.badRequest().body("Erro en la integridad de los datos");
	}
	
@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity <String> handleConstraintViolationException(ConstraintViolationException e){
		return ResponseEntity.badRequest().body("Violacion de restriccion: " + e.getMessage());
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity <String> handleRuntimeException(RuntimeException e){
		return ResponseEntity.badRequest().body("Error: " + e.getMessage());
	}
	
	

}
