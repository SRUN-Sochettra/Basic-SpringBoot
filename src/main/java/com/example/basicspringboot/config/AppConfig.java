package com.example.basicspringboot.config;

import com.example.basicspringboot.repository.ProductRepo;
import com.example.basicspringboot.service.ProductService;
import com.example.basicspringboot.service.imp.ProductServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ProductService productService(ProductRepo productRepo) {
        return new ProductServiceImp(productRepo);
    }
}
