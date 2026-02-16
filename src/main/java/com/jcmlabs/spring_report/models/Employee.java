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
@AllArgsConstructor
@Table(name = "employee")
@SoftDelete
public class Employee extends BaseEntity {
    private String name;
    private String city;
    private Double salary;
}


