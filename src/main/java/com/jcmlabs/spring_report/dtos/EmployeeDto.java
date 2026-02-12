package com.jcmlabs.spring_report.dtos;

public record EmployeeDto(
        Long id,

        @NotBlank(message = "Name is required")
        @Size(max = 255)
        String name,
        String city,
        Double salary) {}
