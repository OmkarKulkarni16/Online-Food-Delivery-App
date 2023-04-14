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
//        Restaurant restaurant  = new Restaurant();
//        restaurant.setRestaurantId(restaurantDto.getRestaurantId());
//        restaurant.setRestaurantName(restaurantDto.getRestaurantName());
//        restaurant.setCuisineType(restaurantDto.getCuisineType());
//        restaurant.setLocation(restaurantDto.getLocation());
//        restaurant.setCity(restaurantDto.getCity());
////        restaurantDto.setMenuItems(restaurantDto.getMenuItems());
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

    @Override
    public List<Restaurant> searchByRestaurantLocation(String restaurantLocation) {
        return restaurantRepository.findByCity(restaurantLocation);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
//        Restaurant restaurant  = new Restaurant();
//        restaurant.setRestaurantId(restaurantDto.getRestaurantId());
//        restaurant.setRestaurantName(restaurantDto.getRestaurantName());
//        restaurant.setCuisineType(restaurantDto.getCuisineType());
//        restaurant.setLocation(restaurantDto.getLocation());
//        restaurant.setCity(restaurantDto.getCity());
//        restaurantDto.setMenuItems(restaurantDto.getMenuItems());
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> searchByRestaurantName(String restaurantName) {
        return restaurantRepository.findByRestaurantName(restaurantName);
    }

    @Override
    public List<Restaurant> searchByCuisineType(String cuisineType) {
        return restaurantRepository.findByCuisineType(cuisineType);
    }

    @Override
    public void deleteRestaurantById(int restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }

    @Override
    public boolean existsById(int restaurantId) {
        return restaurantRepository.existsById(restaurantId);
    }
}
