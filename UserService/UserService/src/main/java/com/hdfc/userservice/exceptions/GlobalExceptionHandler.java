package com.hdfc.userservice.exceptions;

import com.hdfc.userservice.exceptions.validations.ValidationException;
import com.hdfc.userservice.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ApiResponse> handleCustomerNotFoundException(CustomerNotFoundException exception) {
          String message =   exception.getMessage();
          ApiResponse response = ApiResponse.builder().message(message).success(false).status(HttpStatus.NOT_FOUND).build();

          return  new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
    }

   @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleValidationException(ValidationException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);

   }
}
