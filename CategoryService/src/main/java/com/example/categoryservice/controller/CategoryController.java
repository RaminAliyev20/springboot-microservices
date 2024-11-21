package com.example.categoryservice.controller;

import com.example.categoryservice.model.requestDto.CategoryRequestDto;
import com.example.categoryservice.model.requestDto.SimpleMessageDto;
import com.example.categoryservice.model.responseDto.CategoryResponseDto;
import com.example.categoryservice.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/product")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public List<CategoryResponseDto> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    public CategoryResponseDto getCategory(@PathVariable String id) throws Exception {
        return categoryService.getCategory(id);
    }

    @PostMapping
    public SimpleMessageDto addCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        categoryService.addCategory(categoryRequestDto);
        return new SimpleMessageDto("Successfully added!");
    }
}
