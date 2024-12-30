package com.groceryapp.qp_assessment.controller;


import com.groceryapp.qp_assessment.model.GroceryItem;
import com.groceryapp.qp_assessment.request.CartItemRequest;
import com.groceryapp.qp_assessment.response.UserCartResponse;
import com.groceryapp.qp_assessment.service.CartService;
import com.groceryapp.qp_assessment.service.GroceryItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    GroceryItemService groceryItemService;

    @Autowired
    CartService cartService;




    @GetMapping("/grocery-items")
    public List<GroceryItem> fetchListOfGroceryItems(){
        return groceryItemService.getListGroceryItems();
    }


    @PostMapping("/cart/add")
    public ResponseEntity<String> addToCart(
            @RequestParam Long userId,
            @RequestBody List<CartItemRequest> cartItems) {
        cartService.addToCart(userId, cartItems);
        return ResponseEntity.ok("Items added to cart successfully.");
    }

    // View user cart
    @GetMapping("/cart/{userId}")
    public UserCartResponse viewCart(@PathVariable Long userId) {
        return cartService.viewCart(userId);
    }

}
