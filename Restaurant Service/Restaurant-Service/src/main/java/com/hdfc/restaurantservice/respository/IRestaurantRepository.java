package com.hdfc.restaurantservice.respository;

import com.hdfc.restaurantservice.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestaurantRepository extends JpaRepository<Restaurant,Integer> {

}
