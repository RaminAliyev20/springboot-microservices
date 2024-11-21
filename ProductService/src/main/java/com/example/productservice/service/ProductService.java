package com.example.productservice.service;

import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dao.repository.ProductRepository;
import com.example.productservice.mapper.ProductMapper;
import com.example.productservice.model.requestDto.ProductRequestDto;
import com.example.productservice.model.responseDto.CategoryResponseDto;
import com.example.productservice.model.responseDto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final WebClient webClient;

    public List<ProductResponseDto> getProducts(){
        List<ProductEntity> list = productRepository.findAll();
        return ProductMapper.INSTANCE.mapEntitiesToDtos(list);
    }

    public ProductResponseDto getProduct(Long id) throws Exception {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() -> new Exception("not Found"));

        CategoryResponseDto category = webClient.get()
                .uri("http://localhost:8092/v1/category/" + entity.getCategoryId())
                .retrieve()
                .bodyToMono(CategoryResponseDto.class)
                .block();

        System.out.println("Category Response: " + category);

        ProductResponseDto productResponseDto = ProductMapper.INSTANCE.mapEntityToDto(entity);

        productResponseDto.setCategoryResponseDto(category);

        System.out.println(productResponseDto);

        return productResponseDto;
    }


    public void addProduct(ProductRequestDto productRequestDto){
        ProductEntity entity=ProductMapper.INSTANCE.mapRequestDtoToEntity(productRequestDto);
        productRepository.save(entity);
    }
}
