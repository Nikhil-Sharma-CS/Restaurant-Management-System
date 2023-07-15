package org.example.Restaurant.Management.System.Controller;

import org.example.Restaurant.Management.System.Model.FoodItem;
import org.example.Restaurant.Management.System.Service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    FoodItemService foodItemService;

    //Getting all food items
    @GetMapping("foodItem")
    List<FoodItem> foodItems()
    {
        return foodItemService.foodItems();
    }

    //Add Food Items
    @PostMapping("addFoodItem")
    String addFoodItem(@RequestBody List<FoodItem> foodItems)
    {
        return foodItemService.addFoodItem(foodItems);
    }
}
