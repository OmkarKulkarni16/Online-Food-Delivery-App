package com.hdfc.userservice.entity;


import com.hdfc.userservice.vo.Rating;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "microCustomers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerid")
    private int customerId;
    @Column(name = "customername")
    private String customerName;
    @Column(name = "customeremail")
    private String customerEmail;
    @Column(name = "customerphonenumber")
    private String customerPhoneNumber;

    @Column(name = "customerdeliveryaddress")
    private String customerDeliveryAddress;

    @Transient //do not save in database
    private List<Rating> customerRating;
}
