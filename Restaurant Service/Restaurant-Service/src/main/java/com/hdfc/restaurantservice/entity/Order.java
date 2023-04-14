package com.hdfc.restaurantservice.entity;

import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@ToString
@Entity
@Table(name = "myorder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String paymentMethod;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customerid", referencedColumnName = "id")
    private Customer customer;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Cart.class)
    @JoinColumn(name = "orderid", referencedColumnName = "id")
    private List<Cart> cartItems;

    public Order() {
        super();
    }

    public Order(String paymentMethod, Customer customer, List<Cart> cartItems) {
        this.paymentMethod = paymentMethod;
        this.customer = customer;
        this.cartItems = cartItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Cart> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Cart> cartItems) {
        this.cartItems = cartItems;
    }
}
