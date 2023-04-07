package com.hdfc.userservice.exceptions;

public class CustomerNotFoundException extends Exception{

    public  CustomerNotFoundException(){
        super("Customer not found on server !!");
    }
    public  CustomerNotFoundException(String message){
        super(message);
    }
}
