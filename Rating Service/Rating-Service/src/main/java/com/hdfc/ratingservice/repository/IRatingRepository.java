package com.hdfc.ratingservice.repository;

import com.hdfc.ratingservice.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRatingRepository extends JpaRepository<Rating,Integer> {

    List<Rating> findByCustomerId(int customerId);
    List<Rating> findByRestaurantId(int restaurantId);
}
