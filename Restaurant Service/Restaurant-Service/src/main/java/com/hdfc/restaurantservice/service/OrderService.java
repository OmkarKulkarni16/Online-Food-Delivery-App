package com.hdfc.restaurantservice.service;

import com.hdfc.restaurantservice.entity.Cart;
import com.hdfc.restaurantservice.entity.MenuItem;
import com.hdfc.restaurantservice.entity.Order;
import com.hdfc.restaurantservice.entity.Restaurant;
import com.hdfc.restaurantservice.exceptions.MenuItemException;
import com.hdfc.restaurantservice.exceptions.OrderException;
import com.hdfc.restaurantservice.respository.IMenuItemRepository;
import com.hdfc.restaurantservice.respository.IOrderRepository;
import com.hdfc.restaurantservice.respository.IRestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class OrderService {

    private IOrderRepository orderRepository;
    private IRestaurantRepository restaurantRepository;

    private IMenuItemRepository menuItemRepository;

    public OrderService(IOrderRepository orderRepository, IRestaurantRepository restaurantRepository, IMenuItemRepository menuItemRepository) {
        this.orderRepository = orderRepository;
        this.restaurantRepository = restaurantRepository;
        this.menuItemRepository = menuItemRepository;
    }

//    @Autowired
//    IRestaurantService restaurantService;
//    @Autowired
//    IMenuItemService menuItemService;
//    @Autowired
//    IOrderService orderService;
//    public OrderService(IOrderRepository orderRepository, IRestaurantRepository restaurantRepository, IMenuItemRepository menuItemRepository) {
//        this.orderRepository = orderRepository;
//        this.restaurantRepository = restaurantRepository;
//        this.menuItemRepository = menuItemRepository;
//    }


    public Order getOrderDetail(int orderId) throws OrderException {
        Optional<Order> order = this.orderRepository.findById(orderId);
        if (order.isPresent()){
            return order.get();
        }else {
            throw new OrderException("Order history not found with Id = "+orderId);
        }
//        return order.isPresent() ? order.get() : null;
    }

    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    public float getCartAmount(List<Cart> cartList) throws MenuItemException {
        float totalCartAmount = 0f;
        float singleCartAmount = 0f;
        int availableQuantity = 0;

        logger.info("CarList Data === " + cartList);
       for (Cart cart:cartList){
            int restaurantId = cart.getRestaurantId();
            int menuItemId = cart.getMenuItemId();
           Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
           Optional<MenuItem> menuItem = menuItemRepository.findById(menuItemId);

           if (restaurant.isPresent()){
               Restaurant restaurant1 = restaurant.get();
               MenuItem menuItem1 = menuItem.get();
               logger.info("Avab = "+menuItem1.getAvailability() +"And = "+ cart.getQuantity());
               if (menuItem1.getAvailability()< cart.getQuantity()){
                     throw new MenuItemException();
//                   singleCartAmount = menuItem1.getPrice() * menuItem1.getAvailability();
//                   cart.setQuantity(menuItem1.getAvailability());
               }else {
                   singleCartAmount = cart.getQuantity() * menuItem1.getPrice();
                   availableQuantity = menuItem1.getAvailability() - cart.getQuantity();
               }
               totalCartAmount = totalCartAmount + singleCartAmount;
               menuItem1.setAvailability(availableQuantity);
               availableQuantity=0;
               cart.setRestaurantName(restaurant1.getRestaurantName());
               cart.setMenuItemName(menuItem1.getItemName());
               cart.setAmount(singleCartAmount);
               restaurantRepository.save(restaurant1);
           }
       }
     return totalCartAmount;
    }

    public Order saveOrder(Order order){
        logger.info("Order Data = "+order);
        return orderRepository.save(order);
    }
}
