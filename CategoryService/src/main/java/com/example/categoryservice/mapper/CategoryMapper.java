package com.example.categoryservice.mapper;


import com.example.categoryservice.dao.entity.CategoryEntity;
import com.example.categoryservice.model.requestDto.CategoryRequestDto;
import com.example.categoryservice.model.responseDto.CategoryResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class CategoryMapper {
    public static final CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    public abstract CategoryEntity mapDtoToEntity(CategoryResponseDto categoryResponseDto);

    public abstract CategoryResponseDto mapEntityToDto(CategoryEntity categoryEntity);

    public abstract List<CategoryResponseDto> mapEntitiesToDtos(List<CategoryEntity> categoryEntity);

    public abstract CategoryEntity mapRequestDtoToEntity(CategoryRequestDto categoryRequestDto);
}
