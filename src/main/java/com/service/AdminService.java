package com.service;


import com.model.GroceryItem;
import com.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final GroceryItemRepository groceryItemRepository;

    @Autowired
    public AdminService(GroceryItemRepository groceryItemRepository) {
        this.groceryItemRepository = groceryItemRepository;
    }

    public void addGroceryItem(GroceryItem item) {
        groceryItemRepository.save(item);
    }

    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public void removeGroceryItem(Long id) {
        groceryItemRepository.deleteById(id);
    }

    public void updateGroceryItem(Long id, GroceryItem updatedItem) {
        Optional<GroceryItem> existingItemOptional = groceryItemRepository.findById(id);
        if (existingItemOptional.isPresent()) {
            GroceryItem existingItem = existingItemOptional.get();
            existingItem.setName(updatedItem.getName());
            existingItem.setPrice(updatedItem.getPrice());
            existingItem.setQuantity(updatedItem.getQuantity());
            existingItem.setDescription(updatedItem.getDescription());
            groceryItemRepository.save(existingItem);
        }
        // Handle if the item is not found or other appropriate action
    }

    public void manageInventory(Long id, int quantity) {
        Optional<GroceryItem> existingItemOptional = groceryItemRepository.findById(id);
        existingItemOptional.ifPresent(item -> {
            int updatedQuantity = item.getQuantity() + quantity;
            if (updatedQuantity >= 0) {
                item.setQuantity(updatedQuantity);
                groceryItemRepository.save(item);
            } else {
                // Handle insufficient inventory error
            }
        });
        // Handle if the item is not found or other appropriate action
    }
}
