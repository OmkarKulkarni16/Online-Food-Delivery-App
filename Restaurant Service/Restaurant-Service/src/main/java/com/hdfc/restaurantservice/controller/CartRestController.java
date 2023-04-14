package com.hdfc.restaurantservice.controller;

import com.hdfc.restaurantservice.dto.OrderDTO;
import com.hdfc.restaurantservice.dto.ResponseOrderDTO;
import com.hdfc.restaurantservice.entity.Customer;
import com.hdfc.restaurantservice.entity.Order;
import com.hdfc.restaurantservice.entity.RestTemplateCustomer;
import com.hdfc.restaurantservice.exceptions.RestaurantNotFoundException;
import com.hdfc.restaurantservice.service.CustomerService;
import com.hdfc.restaurantservice.service.OrderService;
import com.hdfc.restaurantservice.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Random;


@RestController
@RequestMapping("/api")
public class CartRestController {
    @Autowired
    private RestTemplate restTemplate;
    private OrderService orderService;

    private CustomerService customerService;


    public CartRestController(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    private Logger logger = LoggerFactory.getLogger(CartRestController.class);


    @GetMapping(value = "/getOrder/{orderId}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable int orderId) {

        Order order = orderService.getOrderDetail(orderId);
        return ResponseEntity.ok(order);
    }
    @PostMapping("/placeOrder")
    public ResponseEntity<ResponseOrderDTO> placeOrder(@RequestBody OrderDTO orderDTO) throws RestaurantNotFoundException {
        logger.info("Request Payload " + orderDTO.toString());

        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
        float amount = orderService.getCartAmount(orderDTO.getCartItems());

        Customer customer = new Customer();
        RestTemplateCustomer customer1 = restTemplate.getForObject("http://localhost:8081/customers/getById/"+orderDTO.getCustomerId(), RestTemplateCustomer.class);
        customer.setCustomerName(customer1.getCustomerName());
        customer.setCustomerEmail(customer1.getCustomerEmail());
        customer.setCustomerId(customer1.getCustomerId());
        customer.setCustomerDeliveryAddress(customer1.getCustomerDeliveryAddress());


        Customer customer2 = new Customer(customer.getCustomerName(),customer.getCustomerEmail(), customer.getCustomerId(), customer.getCustomerDeliveryAddress());
        Integer customerIdFromDb = customerService.isCustomerPresent(customer2);
        if (customerIdFromDb != null) {
            customer.setId(customerIdFromDb);
            logger.info("Customer already present in db with id : " + customerIdFromDb);
        } else {
            customer = customerService.saveCustomer(customer2);
            logger.info("Customer saved.. with id : " + customer.getId());
        }


        Order order = new Order(orderDTO.getPaymentMethod(), customer2,orderDTO.getCartItems());
        order = orderService.saveOrder(order);

        responseOrderDTO.setAmount(amount);
        responseOrderDTO.setDate(DateUtil.getCurrentDateTime());
        responseOrderDTO.setInvoiceNumber(new Random().nextInt(10000));
        responseOrderDTO.setOrderId(order.getId());
        responseOrderDTO.setPaymentMethod(orderDTO.getPaymentMethod());

        return ResponseEntity.ok(responseOrderDTO);
    }
}
