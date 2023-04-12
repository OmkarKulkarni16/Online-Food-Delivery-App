package com.hdfc.restaurantservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class MenuItemDTO {


    private int menuItemId;

    private int restaurantId;

    private String cuisineType;
    private String itemName;
    private String itemImage;
    private String restaurantDescription;
    private int price;



}
