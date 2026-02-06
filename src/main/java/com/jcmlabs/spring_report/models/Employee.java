package com.jcmlabs.spring_report.models;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private Double salary;
}

// EmployeeDto.java


