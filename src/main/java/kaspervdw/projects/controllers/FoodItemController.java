package kaspervdw.projects.controllers;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import kaspervdw.projects.controllers.dto.FoodItemDto;
import kaspervdw.projects.dao.FoodItemRepository;
import kaspervdw.projects.mappers.FoodItemMapper;

import java.net.URI;
import java.util.List;

@ApplicationScoped
@Path("/fooditem")
public class FoodItemController {
    FoodItemRepository foodItemRepository;
    FoodItemMapper foodItemMapper;

    @Inject
    public FoodItemController(FoodItemRepository foodItemRepository, FoodItemMapper foodItemMapper) {
        this.foodItemRepository = foodItemRepository;
        this.foodItemMapper = foodItemMapper;
    }

    @GET
    public List<FoodItemDto> getAllFoodItems() {
        return foodItemMapper.listToDto(foodItemRepository.getAllFoodItems());
    }

    @POST
    @Transactional
    public Response addNewFoodItem(FoodItemDto foodItem) {
        Log.info("Adding new food item with id: " + foodItem.id + " and name: " + foodItem.name);
        foodItemRepository.persistNewFoodItem(foodItemMapper.toEntity(foodItem));
        return Response.created(URI.create("/fooditem/" + foodItem.id)).build();
    }

    @GET
    @Path("{id}")
    public FoodItemDto getFoodItemByName(long id) {
        return foodItemMapper.toDto(foodItemRepository.getFoodItemByName(id));
    }
}
