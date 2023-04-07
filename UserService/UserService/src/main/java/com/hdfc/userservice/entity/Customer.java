package com.hdfc.userservice.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "micro_customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;

    private String customerDeliveryAddress;

    @Transient //do not save in database
    private List<Rating> customerRating;
}
