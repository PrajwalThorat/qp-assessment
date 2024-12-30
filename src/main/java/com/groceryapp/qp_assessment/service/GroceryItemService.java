package com.groceryapp.qp_assessment.service;

import com.groceryapp.qp_assessment.model.GroceryItem;

import java.util.List;

public interface GroceryItemService {

     void saveGroceryItem(GroceryItem item);
     List<GroceryItem> getListGroceryItems();
     void deleteGroceryItem(long itemId);
     void updateGroceryItem(long itemId , GroceryItem groceryItem);
     public void updateInventory(Long id, int quantity);
}
