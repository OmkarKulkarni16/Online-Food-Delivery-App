package com.hdfc.restaurantservice.service;

import com.hdfc.restaurantservice.entity.Order;
import com.hdfc.restaurantservice.respository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements IOrderService {
    @Autowired
    IOrderRepository orderRepository;
    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }
}
