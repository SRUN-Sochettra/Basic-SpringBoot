package com.example.basicspringboot.service.imp;

import com.example.basicspringboot.model.Category;
import com.example.basicspringboot.repository.CategoryRepo;
import com.example.basicspringboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryServiceImp(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.getAllCategories();
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        return categoryRepo.getCategoryById(categoryId);
    }

    @Override
    public Category addCategory(Category category) {
        categoryRepo.addCategory(category);
        return category;
    }

    @Override
    public Category updateCategoryById(Category category, Integer categoryId) {
        Category categoryToUpdate = categoryRepo.getCategoryById(categoryId);
        if (categoryToUpdate != null) {
            category.setCategoryId(categoryId);
            categoryRepo.updateCategoryById(category);
            return category;
        }
        return null;
    }

    @Override
    public void deleteCategoryById(Integer categoryId) {
        categoryRepo.deleteCategoryById(categoryId);
    }
}