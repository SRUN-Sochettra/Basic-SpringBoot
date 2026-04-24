package com.example.basicspringboot.controller;

import com.example.basicspringboot.model.ApiResponse;
import com.example.basicspringboot.model.Category;
import com.example.basicspringboot.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // GET /categories/all
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Category>>> getAllCategories() {
        List<Category> allCategories = categoryService.getAllCategories();

        ApiResponse<List<Category>> response = new ApiResponse<>(
                true,
                "All categories fetched successfully",
                allCategories
        );

        return ResponseEntity.ok(response);
    }

    // GET /categories/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Category>> getCategoryById(@PathVariable("id") Integer categoryId) {
        Category category = categoryService.getCategoryById(categoryId);

        if (category == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(
                    false,
                    "Category not found",
                    null
            ));
        }

        return ResponseEntity.ok(new ApiResponse<>(
                true,
                "Category " + categoryId + " fetched successfully",
                category
        ));
    }

    // POST /categories/add
    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Category>> addCategory(@RequestBody Category category) {
        Category addedCategory = categoryService.addCategory(category);

        ApiResponse<Category> response = new ApiResponse<>(
                true,
                "Category added successfully",
                addedCategory
        );

        return ResponseEntity.ok(response);
    }

    // PUT /categories/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Category>> updateCategoryById(
            @RequestBody Category category,
            @PathVariable("id") Integer categoryId) {

        Category updatedCategory = categoryService.updateCategoryById(category, categoryId);

        if (updatedCategory == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(
                    false,
                    "Category not found",
                    null
            ));
        }

        return ResponseEntity.ok(new ApiResponse<>(
                true,
                "Category updated successfully",
                updatedCategory
        ));
    }

    // DELETE /categories/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Category>> deleteCategoryById(@PathVariable("id") Integer categoryId) {
        Category category = categoryService.getCategoryById(categoryId);

        if (category == null) {
            return ResponseEntity.status(404).body(new ApiResponse<>(
                    false,
                    "Category not found",
                    null
            ));
        }

        categoryService.deleteCategoryById(categoryId);

        return ResponseEntity.ok(new ApiResponse<>(
                true,
                "Category deleted successfully",
                category
        ));
    }
}