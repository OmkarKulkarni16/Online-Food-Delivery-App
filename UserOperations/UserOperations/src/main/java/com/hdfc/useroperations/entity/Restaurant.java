package com.hdfc.useroperations.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter

public class Restaurant {


    private int restaurantId;
    private String restaurantName;
    private String cuisineType;
    private String location;

    private String city;

}
