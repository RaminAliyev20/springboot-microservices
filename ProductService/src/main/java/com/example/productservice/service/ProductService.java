package com.example.productservice.service;

import com.example.productservice.dao.entity.ProductEntity;
import com.example.productservice.dao.repository.ProductRepository;
import com.example.productservice.mapper.ProductMapper;
import com.example.productservice.model.requestDto.ProductRequestDto;
import com.example.productservice.model.responseDto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public List<ProductResponseDto> getProducts(){
        List<ProductEntity> list = productRepository.findAll();
        return ProductMapper.INSTANCE.mapEntitiesToDtos(list);
    }

    public ProductResponseDto getProduct(Long id) throws Exception {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() -> new Exception("not Found"));

        return ProductMapper.INSTANCE.mapEntityToDto(entity);
    }

    public void addProduct(ProductRequestDto productRequestDto){
        ProductEntity entity=ProductMapper.INSTANCE.mapRequestDtoToEntity(productRequestDto);
        productRepository.save(entity);
    }
}
