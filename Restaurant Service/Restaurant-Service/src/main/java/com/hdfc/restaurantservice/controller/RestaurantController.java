package com.hdfc.restaurantservice.controller;

import com.hdfc.restaurantservice.entity.Restaurant;
import com.hdfc.restaurantservice.exceptions.RestaurantNotFoundException;
import com.hdfc.restaurantservice.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private IRestaurantService restaurantService;

    @PostMapping("/add")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant){
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantService.addRestaurant(restaurant));
    }

    @GetMapping("/get-restaurant-by/{restaurantId}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable int restaurantId) throws RestaurantNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.getRestaurantById(restaurantId));
    }

    @GetMapping("/getAllRestaurant")
    public ResponseEntity<List<Restaurant>> getAllRestaurant(){
        return ResponseEntity.ok(restaurantService.getAllRestaurant());
    }

    @GetMapping("/get-by-location/{location}")
    public List<Restaurant> getRestaurantByLocation(@PathVariable String location){
        return restaurantService.searchByRestaurantLocation(location);
    }

    @PutMapping("/update-restaurant")
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.updateRestaurant(restaurant);
    }

    @GetMapping("/get-by-restaurant/{restaurantName}")
    public List<Restaurant> searchByRestaurantName(@PathVariable String restaurantName){
        return restaurantService.searchByRestaurantName(restaurantName);
    }

    @GetMapping("/get-by-cuisineType/{cuisineType}")
    public List<Restaurant> searchByCuisineType(@PathVariable String cuisineType){
        return restaurantService.searchByCuisineType(cuisineType);
    }
}
