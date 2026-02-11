package com.jcmlabs.spring_report.dtos;

public record EmployeeDto(
        Long id,
        String name,
        String city, Double salary) {}
