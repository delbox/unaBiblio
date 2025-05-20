package com.biblioteca.unaBiblio.exception;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;



@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(LibroInactivoException.class)
	public ResponseEntity<Map<String, String>> manejarLibroInactivo(LibroInactivoException ex) {
		Map<String, String> errorBody = new HashMap<>();
		errorBody.put("error", ex.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}
	
	//Se puede agregar mas manejadores si queremos
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Map<String, Object>> manejarBadRequest(BadRequestException ex) {
	    Map<String, Object> errorBody = new LinkedHashMap<>();
	    errorBody.put("timestamp", LocalDateTime.now());
	    errorBody.put("status", HttpStatus.BAD_REQUEST.value());
	    errorBody.put("error", "Bad Request");
	    errorBody.put("message", ex.getMessage());
	    return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
	}
	
	//Cuando no encontramos algun dato
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> manejarNotFound(ResourceNotFoundException ex) {
	    Map<String, Object> errorBody = new LinkedHashMap<>();
	    errorBody.put("timestamp", LocalDateTime.now());
	    errorBody.put("status", HttpStatus.NOT_FOUND.value());
	    errorBody.put("error", "Not Found");
	    errorBody.put("message", ex.getMessage());
	    return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
	}
}
