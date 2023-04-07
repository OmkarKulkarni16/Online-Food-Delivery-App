package com.hdfc.userservice.repository;

import com.hdfc.userservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

}
