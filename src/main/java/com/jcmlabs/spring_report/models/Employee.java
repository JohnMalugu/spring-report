package com.jcmlabs.spring_report.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.SoftDelete;

@Getter
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
@SoftDelete
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private Double salary;
}


