package com.hdfc.restaurantservice.entity;

import com.hdfc.restaurantservice.vo.Rating;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class RestTemplateCustomer {

    private int customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;

    private String customerDeliveryAddress;
    private List<Rating> customerRating;
}
