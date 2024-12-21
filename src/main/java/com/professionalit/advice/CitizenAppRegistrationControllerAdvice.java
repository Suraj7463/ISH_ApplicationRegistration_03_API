package com.professionalit.advice;

import java.sql.SQLException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.professionalit.exception.InvalidSSNException;

@RestControllerAdvice
public class CitizenAppRegistrationControllerAdvice {
	@ExceptionHandler(InvalidSSNException.class)
	public ResponseEntity<String>handelInvalidSSN(InvalidSSNException exception){
		
		
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}

	@ExceptionHandler(Exception.class)
public ResponseEntity<String>handelAllException(Exception exception){
		
		
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String>handelSQLException(DataIntegrityViolationException exception){
			
			
			return new ResponseEntity<String>("Issue In Server Side Please Contact Admin",HttpStatus.BAD_REQUEST);
			
		}

}


