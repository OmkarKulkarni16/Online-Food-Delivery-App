package com.hdfc.restaurantservice.dto;


import com.hdfc.restaurantservice.entity.Cart;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderDTO {

    private String paymentMethod;
    private List<Cart> cartItems;
    private int customerId;

//    private String customerEmail;
//    private String customerName;


    @Override
    public String toString() {
        return "OrderDTO{" +
                "paymentMethod='" + paymentMethod + '\'' +
                ", cartItems=" + cartItems +
                ", customerId=" + customerId +
                '}';
    }
}



