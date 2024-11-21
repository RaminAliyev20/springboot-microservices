package com.example.productservice.controller;

import com.example.productservice.config.WebClientConfig;
import com.example.productservice.model.requestDto.ProductRequestDto;
import com.example.productservice.model.requestDto.SimpleMessageDto;
import com.example.productservice.model.responseDto.ProductResponseDto;
import com.example.productservice.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("v1/product")
public class ProductController {

    private final ProductService productService;
    private final WebClient webClient;

    public ProductController(ProductService productService, WebClient webClient) {
        this.productService = productService;
        this.webClient = webClient;
    }

    @GetMapping
    public List<ProductResponseDto> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProduct(@PathVariable Long id) throws Exception {
        return productService.getProduct(id);
    }

    @PostMapping
    public SimpleMessageDto addProduct(@RequestBody ProductRequestDto productRequestDto) {
        productService.addProduct(productRequestDto);
        return new SimpleMessageDto("Successfully added!");
    }
}
