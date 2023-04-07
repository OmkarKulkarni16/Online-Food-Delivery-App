package com.hdfc.restaurantservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleRestaurantNotFoundException(RestaurantNotFoundException exception) {
       return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
