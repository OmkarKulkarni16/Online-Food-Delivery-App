package com.hdfc.userservice.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private int restaurantId;
    private  String restaurantName;
    private String cuisineType;
    private String location;

    private String city;
}
