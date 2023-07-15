package org.example.Restaurant.Management.System.Repository;

import org.example.Restaurant.Management.System.Model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodItemRepo extends JpaRepository<FoodItem, Integer> {
}
