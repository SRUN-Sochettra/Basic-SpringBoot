package com.example.basicspringboot.model;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String productName;
    private Integer productId;
    private Double productPrice;
    private Integer categoryId;
}
