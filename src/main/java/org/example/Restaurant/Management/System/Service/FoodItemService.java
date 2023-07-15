package org.example.Restaurant.Management.System.Service;

import org.example.Restaurant.Management.System.Model.FoodItem;
import org.example.Restaurant.Management.System.Repository.IFoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    @Autowired
    IFoodItemRepo iFoodItemRepo;

    public List<FoodItem> foodItems() {
        return iFoodItemRepo.findAll();
    }

    public String addFoodItem(List<FoodItem> foodItems) {
        iFoodItemRepo.saveAll(foodItems);
        return "Food Items Saved";
    }
}
