package com.example.basicspringboot.model;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Integer categoryId;
    private String categoryName;
}