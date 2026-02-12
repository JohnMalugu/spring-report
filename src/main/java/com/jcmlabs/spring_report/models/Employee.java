package com.jcmlabs.spring_report.models;

import com.jcmlabs.spring_report.shared.entities.BaseEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SoftDelete;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "employee")
@SoftDelete
@AllArgsConstructor
public class Employee extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private Double salary;
}


