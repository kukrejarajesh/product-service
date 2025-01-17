package com.rajesh.expertise.product_service.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rajesh.expertise.product_service.dto.ExceptionDto;

@ControllerAdvice
public class ControllerAdvices {

	@ExceptionHandler(NotFoundException.class)
	private ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException) {
		
		System.out.println("inside controller exception handling");
		
		ExceptionDto exceptionDto= new ExceptionDto(HttpStatus.NOT_FOUND,notFoundException.getMessage());
		
		return new ResponseEntity<ExceptionDto>(exceptionDto, HttpStatus.NOT_FOUND);
		
	
	
		
	}
	
	
}
