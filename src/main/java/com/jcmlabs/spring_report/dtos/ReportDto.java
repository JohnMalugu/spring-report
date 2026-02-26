package com.jcmlabs.spring_report.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ReportDto(
        @NotNull(message = "Name is required")
        @Size(min = 10, max = 50)
        String name,

        @NotNull(message = "description is required, can't be null")
        @Size(min = 50, max = 200)
        String description,

        //owner shud be id, tutalink na user account(multiple user roles)
        String owner) { }
