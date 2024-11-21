package com.example.categoryservice.service;

import com.example.categoryservice.dao.entity.CategoryEntity;
import com.example.categoryservice.dao.repository.CategoryRepository;
import com.example.categoryservice.mapper.CategoryMapper;
import com.example.categoryservice.model.requestDto.CategoryRequestDto;
import com.example.categoryservice.model.responseDto.CategoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public List<CategoryResponseDto> getCategories(){
        List<CategoryEntity> list = categoryRepository.findAll();
        return CategoryMapper.INSTANCE.mapEntitiesToDtos(list);
    }

    public CategoryResponseDto getCategory(String id) throws Exception {
        CategoryEntity entity = categoryRepository.findById(id)
                .orElseThrow(() -> new Exception("not Found"));

        return CategoryMapper.INSTANCE.mapEntityToDto(entity);
    }

    public void addCategory(CategoryRequestDto categoryRequestDto){
        CategoryEntity entity=CategoryMapper.INSTANCE.mapRequestDtoToEntity(categoryRequestDto);
        categoryRepository.save(entity);
    }
}
