package com.hdfc.userservice.exceptions.validations;

public class ValidationException extends Exception{
    public ValidationException() {
        super("Either Of Your Parameter Did Not Match The Validations. Match with below example :- \n " +
                "Customer Name:-\n" +
                "\t\tOmkar Kulkarni\n" +
                "\t\tOmkar Sunil Kulkarni\n\n" +
                "Customer Email:-\n" +
                "\t\tuser@domain.com\n" +
                "\t\tuser@domain.co.in\n" +
                "\t\tuser1@domain.com\n" +
                "\t\tuser.name@domain.com\n" +
                "\t\tuser#@domain.co.in\n" +
                "\t\tuser@domaincom\n\n" +
                "Customer Mobile Number:-\n" +
                "\t\t9423126987\n" +
                "\t\t+919423126987\n\n" +
                "Customer Delivery Address:-\n" +
                "\t\tShould Not Be Empty String");
    }

    public ValidationException(String message) {
        super(message);
    }
}
