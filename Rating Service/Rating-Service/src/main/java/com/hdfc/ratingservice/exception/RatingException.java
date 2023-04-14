package com.hdfc.ratingservice.exception;

public class RatingException extends Exception{
    public RatingException() {
        super("Rating should in range 0 to 5");
    }

    public RatingException(String message) {
        super(message);
    }
}
