package com.example.basicspringboot.repository;

import com.example.basicspringboot.model.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryRepo {

    @Select("""
        SELECT 
            category_id AS categoryId,
            category_name AS categoryName
        FROM categories
    """)
    List<Category> getAllCategories();

    @Select("""
        SELECT 
            category_id AS categoryId,
            category_name AS categoryName
        FROM categories
        WHERE category_id = #{categoryId}
    """)
    Category getCategoryById(Integer categoryId);

    @Insert("""
        INSERT INTO categories(category_name)
        VALUES (#{categoryName})
    """)
    @Options(useGeneratedKeys = true, keyProperty = "categoryId", keyColumn = "category_id")
    void addCategory(Category category);

    @Update("""
        UPDATE categories
        SET category_name = #{categoryName}
        WHERE category_id = #{categoryId}
    """)
    void updateCategoryById(Category category);

    @Delete("""
        DELETE FROM categories
        WHERE category_id = #{categoryId}
    """)
    void deleteCategoryById(Integer categoryId);
}