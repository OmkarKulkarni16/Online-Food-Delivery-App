package com.hdfc.restaurantservice.respository;


import com.hdfc.restaurantservice.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMenuItemRepository extends JpaRepository<MenuItem,Integer> {
}
