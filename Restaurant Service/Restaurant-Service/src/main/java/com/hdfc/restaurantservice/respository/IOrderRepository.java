package com.hdfc.restaurantservice.respository;


import com.hdfc.restaurantservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Integer> {

}
