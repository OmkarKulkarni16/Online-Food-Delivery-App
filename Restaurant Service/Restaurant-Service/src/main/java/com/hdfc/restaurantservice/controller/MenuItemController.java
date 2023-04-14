package com.hdfc.restaurantservice.controller;


import com.hdfc.restaurantservice.entity.MenuItem;
import com.hdfc.restaurantservice.exceptions.RestaurantNotFoundException;
import com.hdfc.restaurantservice.service.IMenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menuItem")
public class MenuItemController {

    @Autowired
    IMenuItemService menuItemService;


    @PostMapping("/add-item")
    public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem){
        MenuItem menuItem1 = menuItemService.addMenuItem(menuItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(menuItem1);
    }

    @GetMapping("/getAll")
    public List<MenuItem> getAllMenuItem(){
        return menuItemService.getAllMenuItem();
    }

    @PutMapping("/update-item")
    public ResponseEntity<MenuItem> updateMenuItem(@RequestBody MenuItem menuItem){
        MenuItem menuItem1 = menuItemService.updateMenuItem(menuItem);

        return ResponseEntity.status(HttpStatus.CREATED).body(menuItem1);
    }

    @DeleteMapping("/delete-by/{menuItemId}")
    public ResponseEntity<String> deleteById(@PathVariable int menuItemId){
        menuItemService.deleteMenuItemById(menuItemId);
        return ResponseEntity.status(HttpStatus.GONE).body("Menu Item Got Deleted Successfully");
    }


    @GetMapping("/get-by/{menuItemId}")
    public MenuItem getMenuItemById(@PathVariable int menuItemId) throws RestaurantNotFoundException {

        return menuItemService.getMenuItemById(menuItemId);
    }
}
