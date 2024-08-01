package kaspervdw.projects.dao;

import kaspervdw.projects.foodtracker.dao.entities.FoodItemEntity;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FoodItemDAO extends JpaRepository<> {

    public FoodItemEntity getFoodItem() {
        return new FoodItemEntity(1, "Kaas");
    }

}
