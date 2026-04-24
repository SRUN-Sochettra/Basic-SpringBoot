package com.example.basicspringboot.service;

import com.example.basicspringboot.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Integer categoryId);
    Category addCategory(Category category);
    Category updateCategoryById(Category category, Integer categoryId);
    void deleteCategoryById(Integer categoryId);
}