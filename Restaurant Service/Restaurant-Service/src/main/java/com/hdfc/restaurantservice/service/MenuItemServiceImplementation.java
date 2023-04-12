package com.hdfc.restaurantservice.service;


import com.hdfc.restaurantservice.entity.MenuItem;
import com.hdfc.restaurantservice.respository.IMenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImplementation implements  IMenuItemService{

    @Autowired
    IMenuItemRepository menuItemRepository;


    @Override
    public MenuItem addMenuItem(MenuItem menuItem) {
//        MenuItem menuItem = new MenuItem();
//        menuItem.setMenuItemId(menuItemDto.getMenuItemId());
//        menuItem.setRestaurantId(menuItemDto.getRestaurantId());
//        menuItem.setCuisineType(menuItemDto.getCuisineType());
//        menuItem.setItemName(menuItemDto.getItemName());
//        menuItem.setItemImage(menuItemDto.getItemImage());
//        menuItem.setRestaurantDescription(menuItemDto.getRestaurantDescription());
//        menuItem.setPrice(menuItemDto.getPrice());
        return menuItemRepository.save(menuItem);
    }

    @Override
    public List<MenuItem> getAllMenuItem() {
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem updateMenuItem(MenuItem menuItem) {
//        MenuItem menuItem = new MenuItem();
//        menuItem.setMenuItemId(menuItemDto.getMenuItemId());
//        menuItem.setRestaurantId(menuItemDto.getRestaurantId());
//        menuItem.setCuisineType(menuItemDto.getCuisineType());
//        menuItem.setItemName(menuItemDto.getItemName());
//        menuItem.setItemImage(menuItemDto.getItemImage());
//        menuItem.setRestaurantDescription(menuItemDto.getRestaurantDescription());
//        menuItem.setPrice(menuItemDto.getPrice());
        return menuItemRepository.save(menuItem);
    }

    @Override
    public void deleteMenuItemById(int menuItemId) {
        menuItemRepository.deleteById(menuItemId);
    }
}
