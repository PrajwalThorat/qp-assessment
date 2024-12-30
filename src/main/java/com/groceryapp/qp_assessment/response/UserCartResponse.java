package com.groceryapp.qp_assessment.response;


import com.groceryapp.qp_assessment.model.CartItem;
import lombok.Data;


import java.util.List;



public class UserCartResponse {

    private Long userId;
    private List<CartItem> items;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}
