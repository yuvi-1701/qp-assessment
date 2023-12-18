package com.controller;

import com.model.GroceryItem;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Endpoint to add a new grocery item
    @PostMapping("/grocery-items")
    public ResponseEntity<String> addGroceryItem(@RequestBody GroceryItem item) {
        adminService.addGroceryItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body("Grocery item added successfully");
    }

    // Endpoint to view all existing grocery items
    @GetMapping("/grocery-items")
    public ResponseEntity<?> getAllGroceryItems() {
        return ResponseEntity.ok(adminService.getAllGroceryItems());
    }

    // Endpoint to remove a specific grocery item by ID
    @DeleteMapping("/grocery-items/{id}")
    public ResponseEntity<String> removeGroceryItem(@PathVariable Long id) {
        adminService.removeGroceryItem(id);
        return ResponseEntity.status(HttpStatus.OK).body("Grocery item removed successfully");
    }

    // Endpoint to update details of a specific grocery item by ID
    @PutMapping("/grocery-items/{id}")
    public ResponseEntity<String> updateGroceryItemDetails(@PathVariable Long id, @RequestBody GroceryItem updatedItem) {
        adminService.updateGroceryItem(id, updatedItem);
        return ResponseEntity.status(HttpStatus.OK).body("Grocery item updated successfully");
    }

    // Endpoint to manage inventory levels of grocery items
    @PutMapping("/manage-inventory/{id}")
    public ResponseEntity<String> manageInventory(@PathVariable Long id, @RequestParam int quantity) {
        adminService.manageInventory(id, quantity);
        return ResponseEntity.status(HttpStatus.OK).body("Inventory managed successfully");
    }
}
