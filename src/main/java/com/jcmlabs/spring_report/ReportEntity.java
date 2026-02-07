package com.jcmlabs.spring_report;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SoftDelete;

@Entity
@Table(name = "report")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SoftDelete
public class ReportEntity {
    private String test;
}
