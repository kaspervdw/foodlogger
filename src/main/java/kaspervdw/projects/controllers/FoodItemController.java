package kaspervdw.projects.controllers;

import kaspervdw.projects.foodtracker.dao.FoodItemDAO;
import kaspervdw.projects.foodtracker.dao.entities.FoodItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fooditems")
public class FoodItemController {

    @Autowired
    private FoodItemDAO foodItemDAO;

    @GetMapping("/{id}")
    public FoodItemEntity getFoodItem(@PathVariable int id) {
        return foodItemDAO.getFoodItem();
    }
}
