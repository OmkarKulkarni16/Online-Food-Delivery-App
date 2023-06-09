package com.hdfc.restaurantservice.respository;

import com.hdfc.restaurantservice.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant,Integer> {


    @Query(value = "SELECT * FROM restaurants  WHERE  city  LIKE %?1%",nativeQuery = true )
    public List<Restaurant> findByCity( String location);

    @Query(value = "SELECT * FROM restaurants  WHERE  restaurantname  LIKE %?1%",nativeQuery = true )
    public  List<Restaurant> findByRestaurantName( String restaurantName);
    @Query(value = "SELECT * FROM restaurants  WHERE  cuisinetype LIKE %?1%",nativeQuery = true )
    public List<Restaurant> findByCuisineType(String cuisineType);
}
