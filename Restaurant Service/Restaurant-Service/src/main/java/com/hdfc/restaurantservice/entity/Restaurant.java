package com.hdfc.restaurantservice.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurantid")
    private Integer restaurantId;

    @Column(name = "restaurantname")
    @NotNull
    private String restaurantName;

    @Column(name = "cuisinetype")
    @NotNull
    private String cuisineType;
    @NotNull
    private String location;
    @NotNull
    private String city;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurantid")
    private List<MenuItem> menuItems;

}
