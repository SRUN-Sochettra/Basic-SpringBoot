package com.example.basicspringboot.service;

import com.example.basicspringboot.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductById(Integer productId);
    public Product addProduct(Product product);
    public Product updateProductById(Product product, Integer productId);
    public void deleteProductById(Integer productId);
}
