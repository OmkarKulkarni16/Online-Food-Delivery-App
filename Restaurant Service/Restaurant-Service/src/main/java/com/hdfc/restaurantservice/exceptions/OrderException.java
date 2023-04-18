package com.hdfc.restaurantservice.exceptions;

public class OrderException extends Exception{
    public OrderException() {
        super("Order Not Found With This ID");
    }

    public OrderException(String message) {
        super(message);
    }
}
