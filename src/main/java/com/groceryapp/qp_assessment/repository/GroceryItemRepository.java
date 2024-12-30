package com.groceryapp.qp_assessment.repository;

import com.groceryapp.qp_assessment.model.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GroceryItemRepository extends JpaRepository<GroceryItem , Long> {


}
