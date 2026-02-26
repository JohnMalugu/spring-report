package com.jcmlabs.spring_report.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ReportDto(
        @NotNull(message = "Name is required")
        @Size(min = 10, max = 50)
        String name,

        @NotNull(message = "description is required, can't be null")
        @Size
        String description,

        //owner shud be id, tutalink na user account, user is an entity (we will have multiple user types)
        String owner) { }
