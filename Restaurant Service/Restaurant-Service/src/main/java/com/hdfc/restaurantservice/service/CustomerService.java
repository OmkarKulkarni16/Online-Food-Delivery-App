package com.hdfc.restaurantservice.service;


import com.hdfc.restaurantservice.entity.Customer;
import com.hdfc.restaurantservice.respository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Integer isCustomerPresent(Customer customer){
        Customer customer1 = customerRepository.getCustomerByCustomerEmailAndCustomerName(customer.getCustomerEmail(),customer.getCustomerName());
        return customer1!=null ? customer1.getId(): null ;
    }
}
