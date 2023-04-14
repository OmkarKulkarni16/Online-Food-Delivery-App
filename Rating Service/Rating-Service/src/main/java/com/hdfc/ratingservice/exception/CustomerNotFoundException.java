package com.hdfc.ratingservice.exception;

public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException() {
        super("Customer Not Found");
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
