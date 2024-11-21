package com.example.productservice.mapper;

import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.model.requestDto.ProductRequestDto;
import com.example.productservice.model.responseDto.ProductResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class ProductMapper {
    public static final ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    public abstract ProductEntity mapDtoToEntity(ProductResponseDto productDto);

    public abstract ProductResponseDto mapEntityToDto(ProductEntity productEntity);

    public abstract List<ProductResponseDto> mapEntitiesToDtos(List<ProductEntity> productEntity);

    public abstract ProductEntity mapRequestDtoToEntity(ProductRequestDto productRequestDto);
}
