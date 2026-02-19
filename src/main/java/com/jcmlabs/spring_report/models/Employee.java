package com.jcmlabs.spring_report.models;

import com.jcmlabs.spring_report.shared.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
@SQLDelete(sql = "UPDATE employee SET deleted = true WHERE id = ?")
@SQLRestriction("deleted = false")
public class Employee extends BaseEntity {
    private String name;
    private String city;
    private Double salary;
}


