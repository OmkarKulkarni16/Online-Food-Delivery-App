package com.hdfc.ratingservice.service;

import com.hdfc.ratingservice.dto.RatingDTO;
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
    public Rating addRating(RatingDTO ratingDto) {
        Rating rating = new Rating();
        rating.setRatingId(ratingDto.getRatingId());
        rating.setCustomerId(ratingDto.getCustomerId());
        rating.setRestaurantId(ratingDto.getRestaurantId());
        rating.setRating(ratingDto.getRating());
        rating.setComments(ratingDto.getComments());

        return ratingRepository.save(rating);
    }

    @Override
    public Rating updateRating(RatingDTO ratingDto) {
        Rating rating = new Rating();
        rating.setRatingId(ratingDto.getRatingId());
        rating.setCustomerId(ratingDto.getCustomerId());
        rating.setRestaurantId(ratingDto.getRestaurantId());
        rating.setRating(ratingDto.getRating());
        rating.setComments(ratingDto.getComments());

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

    @Override
    public void deleteRating(int ratingId) {
        ratingRepository.deleteById(ratingId);
    }

    @Override
    public boolean existWithId(int id) {
        return ratingRepository.existsById(id);
    }
}
