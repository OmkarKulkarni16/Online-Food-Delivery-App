package com.hdfc.restaurantservice.exceptions;

public class RestaurantNotFoundException extends Exception {
    public RestaurantNotFoundException(String s) {
        super(s);
    }
    public  RestaurantNotFoundException(){
        super("Restaurant Not Found Exception");
    }
}
