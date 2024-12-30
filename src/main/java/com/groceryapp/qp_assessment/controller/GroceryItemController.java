package com.groceryapp.qp_assessment.controller;


import com.groceryapp.qp_assessment.model.GroceryItem;
import com.groceryapp.qp_assessment.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
public class GroceryItemController {

    @Autowired
    GroceryItemService groceryItemService;


    @GetMapping("/grocery-items")
    public List<GroceryItem> fetchListOfGroceryItems(){
        return groceryItemService.getListGroceryItems();
    }

    @PostMapping("/grocery-item")
    public ResponseEntity<String> addGroceryItem(@RequestBody GroceryItem groceryItem) {
        groceryItemService.saveGroceryItem(groceryItem);
        return ResponseEntity.ok("Grocery item added successfully.");
    }

    @DeleteMapping("/grocery-item/{id}")
    public ResponseEntity<String> deleteGroceryItem(@PathVariable Long id) {
        groceryItemService.deleteGroceryItem(id);
        return ResponseEntity.ok("Grocery item deleted successfully.");
    }


    @PutMapping("/grocery-item/{id}")
    public ResponseEntity<String> updateGroceryItem(
            @PathVariable Long id,
            @RequestBody GroceryItem groceryItem) {
        groceryItemService.updateGroceryItem(id, groceryItem);
        return ResponseEntity.ok("Grocery item updated successfully.");
    }


    @PutMapping("/inventory/{id}")
    public ResponseEntity<String> updateInventory(
            @PathVariable Long id,
            @RequestParam int quantity) {
        groceryItemService.updateInventory(id, quantity);
        return ResponseEntity.ok("Inventory updated successfully.");
    }

}
