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
    public List<Restaurant> getRestaurantByLocation(@PathVariable String location) throws RestaurantNotFoundException {
      if ( restaurantService.searchByRestaurantLocation(location).size() == 0){
          throw new RestaurantNotFoundException("Restaurant Not Found In Location = "+location);
      } else{
          return  restaurantService.searchByRestaurantLocation(location);
      }
    }

    @PutMapping("/update-restaurant")
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.updateRestaurant(restaurant);
    }

    @GetMapping("/get-by-restaurant/{restaurantName}")
    public List<Restaurant> searchByRestaurantName(@PathVariable String restaurantName) throws RestaurantNotFoundException {
        if (restaurantService.searchByRestaurantName(restaurantName).size()==0){
            throw new RestaurantNotFoundException("Restaurant Not Found With Name = " + restaurantName);
        }else {
            return restaurantService.searchByRestaurantName(restaurantName);

        }
    }

    @GetMapping("/get-by-cuisineType/{cuisineType}")
    public List<Restaurant> searchByCuisineType(@PathVariable String cuisineType) throws RestaurantNotFoundException {
        if (restaurantService.searchByCuisineType(cuisineType).size() == 0){
            throw new RestaurantNotFoundException("Restaurant Not Found With Cuisine Type = "+cuisineType);
        }else {
            return restaurantService.searchByCuisineType(cuisineType);

        }
    }

    @DeleteMapping("/delete-by-id/{restaurantId}")
    public ResponseEntity<String> deleteRestaurantById(@PathVariable int restaurantId) throws RestaurantNotFoundException {
        if (restaurantService.existsById(restaurantId)){
            restaurantService.deleteRestaurantById(restaurantId);
            return  ResponseEntity.status(HttpStatus.GONE).body("Restaurant Successfully Deleted");
        }else {
            throw new RestaurantNotFoundException("Restaurant Not Found With Id = "+restaurantId);
        }

    }
}
