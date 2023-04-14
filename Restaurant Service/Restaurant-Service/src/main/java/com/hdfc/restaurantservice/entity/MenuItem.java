package com.hdfc.restaurantservice.entity;


import com.sun.istack.NotNull;
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
@Table(name = "menuitems")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuItemId;
    @Column(name = "restaurantid")
    private int restaurantId;

    @Column(name = "cuisinetype")
    @NotNull
    private String cuisineType;
    @Column(name = "itemname")
    @NotNull
    private String itemName;
    @Column(name = "itemimage")
    @NotNull
    private String itemImage;

    @Column(name = "menuitemdescription")
    @NotNull
    private String menuItemDescription;

    @Column(name = "price")
    @NotNull
    private int price;

    @Column(name = "availability")
    @NotNull
    private int availability;



}
