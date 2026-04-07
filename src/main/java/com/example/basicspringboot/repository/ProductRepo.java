package com.example.basicspringboot.repository;

import com.example.basicspringboot.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductRepo {
    @Select("""
    SELECT 
        product_id AS productId,
        product_name AS productName,
        product_price AS productPrice,
        category_id AS categoryId
    FROM products
""")
    List<Product> getAllProducts();

    @Select("""
    SELECT 
        product_id AS productId,
        product_name AS productName,
        product_price AS productPrice,
        category_id AS categoryId
    FROM products
    WHERE product_id = #{productId}
""")
    Product getProductById(Integer productId);

    @Insert("""
    INSERT INTO products(product_name, product_price, category_id)
    VALUES (#{productName}, #{productPrice}, #{categoryId})
""")
    @Options(useGeneratedKeys = true, keyProperty = "productId", keyColumn = "product_id")
    void addProduct(Product product);

    @Update("""
        UPDATE products
        SET product_name = #{productName},
            product_price = #{productPrice},
            category_id = #{categoryId}
        WHERE product_id = #{productId}
""")
    void updateProductById(Product product);

    @Delete("""
        DELETE FROM products
        WHERE product_id = #{productId}
""")
    void deleteProductById(Integer productId);
}
