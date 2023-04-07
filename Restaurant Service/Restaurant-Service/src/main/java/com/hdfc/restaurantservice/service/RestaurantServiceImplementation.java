package com.hdfc.restaurantservice.service;

import com.hdfc.restaurantservice.entity.Restaurant;
import com.hdfc.restaurantservice.exceptions.RestaurantNotFoundException;
import com.hdfc.restaurantservice.respository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImplementation implements IRestaurantService{
    @Autowired
    private IRestaurantRepository restaurantRepository;
    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantById(int restaurantId) throws RestaurantNotFoundException {
        return restaurantRepository.findById(restaurantId).orElseThrow(()->new RestaurantNotFoundException("Restaurant not found with id = "+restaurantId));
    }
}
