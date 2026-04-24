package com.example.basicspringboot.controller;

import com.example.basicspringboot.model.ApiResponse;
import com.example.basicspringboot.model.Product;
import com.example.basicspringboot.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET /products/all
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Product>>> getAllProducts() {
        List<Product> allProducts = productService.getAllProducts();

        ApiResponse<List<Product>> response = new ApiResponse<>(
                true,
                "All products fetched successfully",
                allProducts
        );

        return ResponseEntity.ok(response);
    }

    // POST /products/add
    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Product>> addProduct(@RequestBody Product product){
        Product addedProduct = productService.addProduct(product);

        ApiResponse<Product> response = new ApiResponse<>(
                true,
                "Product added successfully",
                addedProduct
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> getProductById(@PathVariable("id") Integer productId){
        Product gottenProductById = productService.getProductById(productId);

        if (gottenProductById == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(
                    false,
                    "Null product",
                    null
            ));
        }

        return ResponseEntity.ok(new ApiResponse<>(
                true,
                "Product " + productId + " fetched successfully",
                gottenProductById
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> updateProductById(@RequestBody Product product, @PathVariable("id") Integer productId){
        Product updatedProduct = productService.updateProductById(product, productId);

        if (updatedProduct == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(
                    false,
                    "Null product",
                    null
            ));
        }

        return ResponseEntity.ok(new ApiResponse<>(
                true,
                "Product updated successfully",
                updatedProduct
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> deleteProductById(@PathVariable("id") Integer productId){
        Product product = productService.getProductById(productId);

        if (product == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(
                    false,
                    "Null product",
                    null
            ));
        }

        productService.deleteProductById(productId);

        return ResponseEntity.ok(new ApiResponse<>(
                true,
                "Product deleted successfully",
                product
        ));
    }
}
