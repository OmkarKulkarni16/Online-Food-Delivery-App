package com.hdfc.userservice.service;

import com.hdfc.userservice.dto.CustomerDTO;
import com.hdfc.userservice.entity.Customer;
import com.hdfc.userservice.vo.Rating;
import com.hdfc.userservice.vo.Restaurant;
import com.hdfc.userservice.exceptions.CustomerNotFoundException;
import com.hdfc.userservice.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Customer addCustomer(CustomerDTO customerDto) {
        Customer customer = new Customer();
        customer.setCustomerId(customerDto.getCustomerId());
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setCustomerEmail(customerDto.getCustomerEmail());
        customer.setCustomerPhoneNumber(customerDto.getCustomerPhoneNumber());
        customer.setCustomerDeliveryAddress(customerDto.getCustomerDeliveryAddress());
        customer.setCustomerRating(customerDto.getCustomerRating());
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(int customerId) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer Not Found With ID = " + customerId));
        Rating[] ratingsOfCustomer = restTemplate.getForObject("http://localhost:8083/ratings/get-by-customerId/" + customerId, Rating[].class);
        List<Rating> ratings = Arrays.stream(ratingsOfCustomer).toList();
        List<Rating> ratingList = ratings.stream().map(rating -> {
//          Api service to call restaurant service
            ResponseEntity<Restaurant> forEntity = restTemplate.getForEntity("http://localhost:8082/restaurants/get-restaurant-by/"+rating.getRestaurantId(), Restaurant.class);
            Restaurant restaurant = forEntity.getBody();
//            set the restaurant to rating
            rating.setRestaurant(restaurant);
            return rating;
        }).collect(Collectors.toList());
        customer.setCustomerRating(ratingList);
        return customer;
    }

    @Override
    public Customer updateCustomer(CustomerDTO customerDto) {
        Customer customer = new Customer();
        customer.setCustomerId(customerDto.getCustomerId());
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setCustomerEmail(customerDto.getCustomerEmail());
        customer.setCustomerPhoneNumber(customerDto.getCustomerPhoneNumber());
        customer.setCustomerDeliveryAddress(customerDto.getCustomerDeliveryAddress());
        customer.setCustomerRating(customerDto.getCustomerRating());
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(int customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public boolean existById(int customerId) {
        return customerRepository.existsById(customerId);
    }
}
