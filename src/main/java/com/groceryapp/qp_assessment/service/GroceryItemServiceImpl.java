package com.groceryapp.qp_assessment.service;


import com.groceryapp.qp_assessment.exception.ResourceNotFoundException;
import com.groceryapp.qp_assessment.model.GroceryItem;
import com.groceryapp.qp_assessment.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemServiceImpl implements GroceryItemService{

    @Autowired
    GroceryItemRepository groceryItemRepository;



    @Override
    public void saveGroceryItem(GroceryItem item) {
        groceryItemRepository.save(item);
    }

    @Override
    public List<GroceryItem> getListGroceryItems() {
        return groceryItemRepository.findAll();
    }

    @Override
    public void deleteGroceryItem(long itemId) {
        GroceryItem getItem = groceryItemRepository.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("Item " +
                "not found with id: " + itemId));
        groceryItemRepository.deleteById(itemId);
    }

    @Override
    public void updateGroceryItem(long itemId, GroceryItem item) {
        GroceryItem existingItem =
                groceryItemRepository.findById(itemId).orElseThrow(() -> new ResourceNotFoundException(
                "Item " +
                "not found with id: " + itemId));
        existingItem.setName(item.getName());
        existingItem.setPrice(item.getPrice());
        existingItem.setQuantity(item.getQuantity());
        groceryItemRepository.save(existingItem);
    }


    @Override
    public void updateInventory(Long id, int quantity) {
        GroceryItem item = groceryItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
        item.setQuantity(quantity);
        groceryItemRepository.save(item);
    }
}
