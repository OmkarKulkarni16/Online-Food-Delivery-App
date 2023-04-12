package com.hdfc.restaurantservice.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "menuItems")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuItemId;
    @Column(name = "restaurant_id")
    private int restaurantId;

    private String cuisineType;
    private String itemName;
    private String itemImage;
    private String restaurantDescription;
    private int price;



}
