package com.hdfc.restaurantservice.respository;


import com.hdfc.restaurantservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    public Customer getCustomerByCustomerEmailAndCustomerName(String email,String name);
}
