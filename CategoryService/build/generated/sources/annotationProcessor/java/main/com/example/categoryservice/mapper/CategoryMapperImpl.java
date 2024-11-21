package com.example.categoryservice.mapper;

import com.example.categoryservice.dao.entity.CategoryEntity;
import com.example.categoryservice.model.requestDto.CategoryRequestDto;
import com.example.categoryservice.model.responseDto.CategoryResponseDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-21T14:18:15+0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.11 (Amazon.com Inc.)"
)
public class CategoryMapperImpl extends CategoryMapper {

    @Override
    public CategoryEntity mapDtoToEntity(CategoryResponseDto categoryResponseDto) {
        if ( categoryResponseDto == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( categoryResponseDto.getId() );
        categoryEntity.setName( categoryResponseDto.getName() );

        return categoryEntity;
    }

    @Override
    public CategoryResponseDto mapEntityToDto(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();

        categoryResponseDto.setId( categoryEntity.getId() );
        categoryResponseDto.setName( categoryEntity.getName() );

        return categoryResponseDto;
    }

    @Override
    public List<CategoryResponseDto> mapEntitiesToDtos(List<CategoryEntity> categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        List<CategoryResponseDto> list = new ArrayList<CategoryResponseDto>( categoryEntity.size() );
        for ( CategoryEntity categoryEntity1 : categoryEntity ) {
            list.add( mapEntityToDto( categoryEntity1 ) );
        }

        return list;
    }

    @Override
    public CategoryEntity mapRequestDtoToEntity(CategoryRequestDto categoryRequestDto) {
        if ( categoryRequestDto == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setName( categoryRequestDto.getName() );

        return categoryEntity;
    }
}
