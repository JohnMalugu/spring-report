package com.jcmlabs.spring_report.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmployeeDto(
        String uuid,
        @NotBlank(message = "Name is required")
        @Size(max = 255)
        String name,

        @Size(max = 50)
        String city,

        Double salary) {}
