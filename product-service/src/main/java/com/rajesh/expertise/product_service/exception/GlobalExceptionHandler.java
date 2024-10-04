package com.rajesh.expertise.product_service.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*this class handles method throwing Exception.class, using ErrorDetails DTO*/

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFound(ResourceNotFoundException ex) {
//        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), "Resource not found");
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), "Internal server error");
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
