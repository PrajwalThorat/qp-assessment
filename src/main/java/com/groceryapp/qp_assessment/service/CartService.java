package com.groceryapp.qp_assessment.service;


import com.groceryapp.qp_assessment.request.CartItemRequest;
import com.groceryapp.qp_assessment.response.UserCartResponse;


import java.util.List;

public interface CartService {

    public void addToCart(Long userId, List<CartItemRequest> cartItems);
    public UserCartResponse viewCart(Long userId);


}
