package com.jcmlabs.spring_report.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record EmployeeDto(
        String uuid,
        @NotBlank(message = "Name is required")
        @Size(max = 255)
        String name,

        @Size(max = 50)
        String city,

        @NotNull(message = "Salary is required")
        @Positive(message = "Salary must be greater than zero")
        Double salary) {}
