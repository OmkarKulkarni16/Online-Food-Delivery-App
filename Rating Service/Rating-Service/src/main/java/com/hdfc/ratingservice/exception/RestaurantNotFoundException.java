package com.hdfc.ratingservice.exception;

public class RestaurantNotFoundException extends Exception{
    public RestaurantNotFoundException() {
        super("Restaurant Not Found");
    }

    public RestaurantNotFoundException(String message) {
        super(message);
    }
}
