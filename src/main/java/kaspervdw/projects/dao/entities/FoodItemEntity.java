package kaspervdw.projects.dao.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class FoodItemEntity extends PanacheEntity {
    public String name;
}
