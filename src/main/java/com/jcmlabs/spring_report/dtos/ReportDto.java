package com.jcmlabs.spring_report.dtos;

import jakarta.validation.constraints.NotNull;

public record ReportDto(
        @NotNull(message = "Name is required")
        String name,

        @NotNull(message = "description is required, can't be null")
        String description,
        //owner shud be id, tutalink na user account
        String owner) {
}
