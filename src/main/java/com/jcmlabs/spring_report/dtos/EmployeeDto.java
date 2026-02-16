package com.jcmlabs.spring_report.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record EmployeeDto(

        Long id, String uuid,

        @NotBlank(message = "Name is required") @Size(min = 2, max = 255, message = "Name must be between 2 and 255 characters") String name,

        @Size(max = 50) String city,

        @NotNull(message = "Salary is required") @Positive(message = "Salary must be greater than zero") Double salary) {
}
