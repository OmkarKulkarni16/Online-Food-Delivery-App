package com.hdfc.userservice.service;

import com.hdfc.userservice.entity.Customer;
import com.hdfc.userservice.exceptions.CustomerNotFoundException;

import java.util.List;

public interface ICustomerService {

    public Customer addCustomer(Customer customer);

    public List<Customer> getAllCustomer();

    public Customer getCustomerById(int customerId) throws CustomerNotFoundException;

    public Customer updateCustomer(Customer customer);

    public void deleteCustomerById(int customerId);
}
