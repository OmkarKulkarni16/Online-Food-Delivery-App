package com.hdfc.ratingservice.service;

import com.hdfc.ratingservice.dto.RatingDTO;
import com.hdfc.ratingservice.entity.Rating;

import java.util.List;

public interface IRatingService {

    public Rating addRating(RatingDTO ratingDto);

    public List<Rating> getAllRating();

    public List<Rating> getRatingByCustomerId(int customerId);

    public List<Rating> getRatingByRestaurantId(int restaurantId);


}
