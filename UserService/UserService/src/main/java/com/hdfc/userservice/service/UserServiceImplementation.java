package com.hdfc.userservice.service;

import com.hdfc.userservice.entity.Customer;
import com.hdfc.userservice.exceptions.CustomerNotFoundException;
import com.hdfc.userservice.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements ICustomerService{

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(int customerId) throws CustomerNotFoundException {
        return customerRepository.findById(customerId).orElseThrow(()->new CustomerNotFoundException("Customer Not Found With ID = "+customerId));
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(int customerId) {
        customerRepository.deleteById(customerId);
    }
}
