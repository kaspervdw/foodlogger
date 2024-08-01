package kaspervdw.projects.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;
import kaspervdw.projects.dao.entities.FoodItemEntity;

import java.util.List;

@RequestScoped
public class FoodItemRepository implements PanacheRepository<FoodItemEntity> {
    public FoodItemEntity getFoodItemByName(long id) {
        return findById(id);
    }

    public List<FoodItemEntity> getAllFoodItems() {
        return findAll().list();
    }

    public void persistNewFoodItem(FoodItemEntity foodItem) {
        persist(foodItem);
    }
}
