package com.hdfc.restaurantservice.service;


import com.hdfc.restaurantservice.entity.MenuItem;

import java.util.List;

public interface IMenuItemService {

    public MenuItem addMenuItem(MenuItem menuItem);

    public List<MenuItem> getAllMenuItem();

    public MenuItem updateMenuItem(MenuItem menuItem);

    public void deleteMenuItemById(int menuItemId)
;}
