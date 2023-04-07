package com.hdfc.ratingservice.service;

import com.hdfc.ratingservice.entity.Rating;

import java.util.List;

public interface IRatingService {

    public Rating addRating(Rating rating);

    public List<Rating> getAllRating();

    public List<Rating> getRatingByCustomerId(int customerId);

    public List<Rating> getRatingByRestaurantId(int restaurantId);


}
