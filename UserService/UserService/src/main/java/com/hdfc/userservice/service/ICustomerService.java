package com.hdfc.userservice.service;

import com.hdfc.userservice.dto.CustomerDTO;
import com.hdfc.userservice.entity.Customer;
import com.hdfc.userservice.exceptions.CustomerNotFoundException;

import java.util.List;

public interface ICustomerService {

    Customer addCustomer(CustomerDTO customerDto);

    List<Customer> getAllCustomer();

    Customer getCustomerById(int customerId) throws CustomerNotFoundException;

    Customer updateCustomer(CustomerDTO customerDto);

    void deleteCustomerById(int customerId);

    boolean existById(int customerId);
}
