package de.tekup.db.controllers;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import de.tekup.db.errors.SaveInDBException;

@RestControllerAdvice
public class ExpHandler {
	

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body("Error in table : "+e.getMessage());
	}
	
	@ExceptionHandler(SaveInDBException.class)
	public ResponseEntity<String> handleSaveInDBException(SaveInDBException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body(e.getMessage());
	}

}
