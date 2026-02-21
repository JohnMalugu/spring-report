package com.jcmlabs.spring_report.dtos;

import jakarta.validation.constraints.NotNull;

public record ReportDto(
        @NotNull(message = "Name is required")
        String name,
        String description,
        String owner) {
}
