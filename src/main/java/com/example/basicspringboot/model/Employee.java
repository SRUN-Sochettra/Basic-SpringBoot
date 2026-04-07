package com.example.basicspringboot.model;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private Double salary;
    private String department;
    private LocalDateTime createdAt;
}
