package com.hdfc.ratingservice.exception;

public class IdNotFoundException extends Exception{
    public IdNotFoundException() {
        super("Please Enter The Valid ID Parameter");
    }

    public IdNotFoundException(String message) {
        super(message);
    }
}
