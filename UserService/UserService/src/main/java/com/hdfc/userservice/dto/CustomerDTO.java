package com.hdfc.userservice.dto;

import com.hdfc.userservice.vo.Rating;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDTO {

    private int customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;

    private String customerDeliveryAddress;

    private List<Rating> customerRating;
}
