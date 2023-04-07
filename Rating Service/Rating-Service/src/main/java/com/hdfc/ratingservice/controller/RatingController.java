package com.hdfc.ratingservice.controller;

import com.hdfc.ratingservice.entity.Rating;
import com.hdfc.ratingservice.service.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    IRatingService ratingService;

    @PostMapping("/add")
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.addRating(rating));
    }

    @GetMapping("/getAllRating")
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.ok(ratingService.getAllRating());
    }
    @GetMapping("/get-by-customerId/{customerId}")
    public ResponseEntity<List<Rating>> getRatingsByCustomerId(@PathVariable int customerId){
        return ResponseEntity.ok(ratingService.getRatingByCustomerId(customerId));
    }
    @GetMapping("/get-by-restaurant-id/{restaurantId}")
    public ResponseEntity<List<Rating>> getRatingsByRestaurantId(@PathVariable int restaurantId){
        return ResponseEntity.ok(ratingService.getRatingByRestaurantId(restaurantId));
    }


}
