package com.hdfc.restaurantservice.exceptions;

public class MenuItemException extends Exception{
    public MenuItemException() {
        super("Menu item not available");
    }

    public MenuItemException(String message) {
        super(message);
    }
}
