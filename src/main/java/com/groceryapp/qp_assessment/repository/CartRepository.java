package com.groceryapp.qp_assessment.repository;


import com.groceryapp.qp_assessment.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {

//    boolean existsByGroceryItemIdAndUserEmail(long groceryItemId, String userEmail);
    List<CartItem> findByUserId(Long userId);
}
