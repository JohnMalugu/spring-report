package com.jcmlabs.spring_report.models;

import com.jcmlabs.spring_report.shared.entities.BaseEntity;
import jakarta.persistence.Entity;

@Entity
public class UserAccount extends BaseEntity {
    private String firstName;
    private String middleName;
    private String lastName;
}
