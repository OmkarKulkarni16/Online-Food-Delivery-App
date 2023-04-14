package com.hdfc.restaurantservice.entity;


import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "customername")
    private String customerName;
    @Column(name = "customeremail")
    private String customerEmail;

    @Column(name = "customerid")
    private int customerId;

    @Column(name = "customerdeliveryAddress")
    private String customerDeliveryAddress;

    public Customer(String customerName, String customerEmail, int customerId, String customerDeliveryAddress) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerId = customerId;
        this.customerDeliveryAddress = customerDeliveryAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerDeliveryAddress() {
        return customerDeliveryAddress;
    }

    public void setCustomerDeliveryAddress(String customerDeliveryAddress) {
        this.customerDeliveryAddress = customerDeliveryAddress;
    }

    //
    public Customer() {
        super();
    }
}
