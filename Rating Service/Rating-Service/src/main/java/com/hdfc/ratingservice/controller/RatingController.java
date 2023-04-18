package com.hdfc.ratingservice.controller;

import com.hdfc.ratingservice.dto.RatingDTO;
import com.hdfc.ratingservice.entity.Rating;
import com.hdfc.ratingservice.exception.CustomerNotFoundException;
import com.hdfc.ratingservice.exception.IdNotFoundException;
import com.hdfc.ratingservice.exception.RatingException;
import com.hdfc.ratingservice.exception.RestaurantNotFoundException;
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
    public ResponseEntity<Rating> addRating(@RequestBody RatingDTO ratingDto) throws IdNotFoundException, RatingException {
        if (ratingDto.getCustomerId() > 0 && ratingDto.getRestaurantId() > 0) {
            if (ratingDto.getRating() >= 0 && ratingDto.getRating() <= 5) {
                if (ratingDto.getComments().length() > 0) {
                    return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.addRating(ratingDto));
                } else {
                    throw new RatingException("Empty String Not Allowed In Comments");
                }
            } else {
                throw new RatingException();
            }
        } else {
            throw new IdNotFoundException("Either your Customer Id or Restaurant ID is Zero. Please Check.....");
        }

    }


    @PutMapping("/updateRating")
    public ResponseEntity<Rating> updateRating(@RequestBody RatingDTO ratingDto) throws RatingException, IdNotFoundException {
        if (ratingDto.getCustomerId() > 0 && ratingDto.getRestaurantId() > 0) {
            if (ratingDto.getRating() >= 0 && ratingDto.getRating() <= 5) {
                if (ratingDto.getComments().length() > 0) {
                    return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.updateRating(ratingDto));
                } else {
                    throw new RatingException("Empty String Not Allowed In Comments");
                }
            } else {
                throw new RatingException();
            }
        } else {
            throw new IdNotFoundException("Either your Customer Id or Restaurant ID is Zero. Please Check.....");
        }
    }

    @GetMapping("/getAllRating")
    public ResponseEntity<List<Rating>> getAllRatings() {
        return ResponseEntity.ok(ratingService.getAllRating());
    }

    @GetMapping("/get-by-customerId/{customerId}")
    public ResponseEntity<List<Rating>> getRatingsByCustomerId(@PathVariable int customerId) throws CustomerNotFoundException {
        if (ratingService.existWithId(customerId)) {
            return ResponseEntity.ok(ratingService.getRatingByCustomerId(customerId));

        } else {
            throw new CustomerNotFoundException("Customer Not Found With Id = " + customerId);
        }
    }

    @GetMapping("/get-by-restaurant-id/{restaurantId}")
    public ResponseEntity<List<Rating>> getRatingsByRestaurantId(@PathVariable int restaurantId) throws RestaurantNotFoundException {
        if (ratingService.existWithId(restaurantId)) {
            return ResponseEntity.ok(ratingService.getRatingByRestaurantId(restaurantId));

        } else {
            throw new RestaurantNotFoundException("Restaurant Not Found With Id = " + restaurantId);
        }
    }


    @DeleteMapping("/deleteRating/{ratingId}")
    public ResponseEntity<String> deleteRating(@PathVariable int ratingId) throws RatingException {
     if (ratingService.existWithId(ratingId)){
     ratingService.deleteRating(ratingId);
     return ResponseEntity.status(HttpStatus.GONE).body("Rating Successfully Deleted");
     }else {
         throw new RatingException("Rating Id Does Not Exists");
     }
    }
}
