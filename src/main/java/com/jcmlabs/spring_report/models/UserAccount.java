package com.jcmlabs.spring_report.models;

import com.jcmlabs.spring_report.shared.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserAccount extends BaseEntity {
    private String firstName;
    private String middleName;
    private String lastName;
}
