package com.hdfc.restaurantservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter

public class RestaurantDTO {

    private int restaurantId;
    private String restaurantName;
    private String cuisineType;
    private String location;

    private String city;

    private List<MenuItemDTO> menuItems;

}
