package com.deploy.praktikum1.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UserAddRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @Positive(message = "Age must be positive")
    private int age;
}
