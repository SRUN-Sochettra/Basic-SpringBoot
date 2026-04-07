package com.example.basicspringboot.service.imp;

import com.example.basicspringboot.model.Product;
import com.example.basicspringboot.repository.ProductRepo;
import com.example.basicspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImp implements ProductService {
    private final ProductRepo productRepo;
    @Autowired
    public ProductServiceImp(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getAllProducts(){
        return productRepo.getAllProducts();
    }

    @Override
    public Product getProductById(Integer productId){
        return productRepo.getProductById(productId);
    }

    @Override
    public Product addProduct(Product product){
        productRepo.addProduct(product);
        return product;
    }

    @Override
    public Product updateProductById(Product product, Integer productId){
        Product productToUpdate = productRepo.getProductById(productId);
        if (productToUpdate != null) {
            product.setProductId(productId);
            productRepo.updateProductById(product);
            return product;
        }
        return null;
    }

    @Override
    public void deleteProductById(Integer productId){
        productRepo.deleteProductById(productId);
    }
}
