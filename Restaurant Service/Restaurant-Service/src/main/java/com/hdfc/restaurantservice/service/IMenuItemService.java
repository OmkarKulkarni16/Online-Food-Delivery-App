package com.hdfc.restaurantservice.service;


import com.hdfc.restaurantservice.entity.MenuItem;
import com.hdfc.restaurantservice.exceptions.RestaurantNotFoundException;

import java.util.List;

public interface IMenuItemService {

    public MenuItem addMenuItem(MenuItem menuItem);

    public List<MenuItem> getAllMenuItem();

    public MenuItem updateMenuItem(MenuItem menuItem);

    public void deleteMenuItemById(int menuItemId);

    public MenuItem getMenuItemById(int menuItemId) throws RestaurantNotFoundException;

    public boolean existsById(int menuItemId);
;}
