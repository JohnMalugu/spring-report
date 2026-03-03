package com.jcmlabs.spring_report.models;

import com.jcmlabs.spring_report.enums.Gender;
import com.jcmlabs.spring_report.shared.entities.BaseEntity;
import jakarta.persistence.Column;
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

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    private Gender gender;
}
