package com.hdfc.ratingservice.service;

import com.hdfc.ratingservice.entity.Rating;
import com.hdfc.ratingservice.repository.IRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImplementation implements IRatingService{

    @Autowired
    private IRatingRepository ratingRepository;
    @Override
    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByCustomerId(int customerId) {
        return ratingRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Rating> getRatingByRestaurantId(int restaurantId) {
        return ratingRepository.findByRestaurantId(restaurantId);
    }
}
