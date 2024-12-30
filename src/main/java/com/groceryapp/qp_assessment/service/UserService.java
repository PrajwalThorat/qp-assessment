package com.groceryapp.qp_assessment.service;

import com.groceryapp.qp_assessment.model.GroceryItem;
import com.groceryapp.qp_assessment.model.User;

import java.util.List;

public interface UserService {


    User saveUser(User user);
    String deleteUser(long userId);
}
