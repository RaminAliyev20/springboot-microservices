package com.example.productservice.mapper;

import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.model.requestDto.ProductRequestDto;
import com.example.productservice.model.responseDto.ProductResponseDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-21T14:53:30+0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
public class ProductMapperImpl extends ProductMapper {

    @Override
    public ProductEntity mapDtoToEntity(ProductResponseDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( productDto.getId() );
        productEntity.setName( productDto.getName() );
        productEntity.setDescription( productDto.getDescription() );
        productEntity.setPrice( productDto.getPrice() );

        return productEntity;
    }

    @Override
    public ProductResponseDto mapEntityToDto(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        ProductResponseDto productResponseDto = new ProductResponseDto();

        productResponseDto.setId( productEntity.getId() );
        productResponseDto.setName( productEntity.getName() );
        productResponseDto.setDescription( productEntity.getDescription() );
        productResponseDto.setPrice( productEntity.getPrice() );

        return productResponseDto;
    }

    @Override
    public List<ProductResponseDto> mapEntitiesToDtos(List<ProductEntity> productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        List<ProductResponseDto> list = new ArrayList<ProductResponseDto>( productEntity.size() );
        for ( ProductEntity productEntity1 : productEntity ) {
            list.add( mapEntityToDto( productEntity1 ) );
        }

        return list;
    }

    @Override
    public ProductEntity mapRequestDtoToEntity(ProductRequestDto productRequestDto) {
        if ( productRequestDto == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setName( productRequestDto.getName() );
        productEntity.setDescription( productRequestDto.getDescription() );
        productEntity.setPrice( productRequestDto.getPrice() );
        productEntity.setCategoryId( productRequestDto.getCategoryId() );

        return productEntity;
    }
}
