package kaspervdw.projects.mappers;

import kaspervdw.projects.controllers.dto.FoodItemDto;
import kaspervdw.projects.dao.entities.FoodItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "jakarta-cdi")
public interface FoodItemMapper {
    FoodItemDto toDto(FoodItemEntity entity);
    @Mapping(target = "id", ignore = true)
    FoodItemEntity toEntity(FoodItemDto dto);
    List<FoodItemDto> listToDto(List<FoodItemEntity> entityList);
}
