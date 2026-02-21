package com.jcmlabs.spring_report.dtos;

import jakarta.validation.constraints.NotNull;

public record ReportDto(
        @NotNull
        String name,
        String description,
        String owner) {
}
