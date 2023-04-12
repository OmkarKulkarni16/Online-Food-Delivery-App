package com.hdfc.userservice.service;

import com.hdfc.userservice.dto.CustomerDTO;
import com.hdfc.userservice.entity.Customer;
import com.hdfc.userservice.exceptions.CustomerNotFoundException;

import java.util.List;

public interface ICustomerService {

    public Customer addCustomer(CustomerDTO customerDto);

    public List<Customer> getAllCustomer();

    public Customer getCustomerById(int customerId) throws CustomerNotFoundException;

    public Customer updateCustomer(CustomerDTO customerDto);

    public void deleteCustomerById(int customerId);
}
