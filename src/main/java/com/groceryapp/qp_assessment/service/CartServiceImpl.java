package com.groceryapp.qp_assessment.service;

import com.groceryapp.qp_assessment.exception.ResourceNotFoundException;
import com.groceryapp.qp_assessment.model.CartItem;
import com.groceryapp.qp_assessment.model.GroceryItem;
import com.groceryapp.qp_assessment.repository.CartRepository;
import com.groceryapp.qp_assessment.repository.GroceryItemRepository;
import com.groceryapp.qp_assessment.request.CartItemRequest;
import com.groceryapp.qp_assessment.response.UserCartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class CartServiceImpl implements  CartService{

    @Autowired
    CartRepository cartRepository;

    @Autowired
    GroceryItemRepository groceryItemRepository;


    @Override
    public void addToCart(Long userId, List<CartItemRequest> cartItems) {
        for (CartItemRequest item : cartItems) {
            GroceryItem groceryItem = groceryItemRepository.findById(item.getGroceryItemId())
                    .orElseThrow(() -> new ResourceNotFoundException("Item not found"));

            if (groceryItem.getQuantity() < item.getQuantity()) {
                throw new IllegalArgumentException("Insufficient inventory for item: " + groceryItem.getName());
            }

            // Add cart item
            CartItem cartItem = new CartItem();
            cartItem.setUserId(userId);
            cartItem.setGroceryItem(groceryItem);
            cartItem.setQuantity(item.getQuantity());
            cartRepository.save(cartItem);

            // Update inventory
            groceryItem.setQuantity(groceryItem.getQuantity() - item.getQuantity());
            groceryItemRepository.save(groceryItem);
        }
    }

    @Override
    public UserCartResponse viewCart(Long userId) {
        List<CartItem> cartItems = cartRepository.findByUserId(userId);

        UserCartResponse response = new UserCartResponse();
        response.setUserId(userId);
        response.setItems(cartItems);
        return response;
    }
}
