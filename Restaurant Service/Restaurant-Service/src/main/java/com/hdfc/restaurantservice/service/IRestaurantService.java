package com.hdfc.restaurantservice.service;

import com.hdfc.restaurantservice.entity.Restaurant;
import com.hdfc.restaurantservice.exceptions.RestaurantNotFoundException;

import java.util.List;

public interface IRestaurantService {

    public Restaurant addRestaurant(Restaurant restaurant);

    public List<Restaurant> getAllRestaurant();

    public Restaurant getRestaurantById(int restaurantId) throws RestaurantNotFoundException;



}