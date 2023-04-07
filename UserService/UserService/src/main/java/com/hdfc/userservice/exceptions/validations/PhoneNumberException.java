package com.hdfc.userservice.exceptions.validations;

public class PhoneNumberException extends Exception{
    public  PhoneNumberException(){
        super("Not Matched the given format \n Example of correct matches : +91-9822345654,9822345654,+91-80-25746669");
    }
}
