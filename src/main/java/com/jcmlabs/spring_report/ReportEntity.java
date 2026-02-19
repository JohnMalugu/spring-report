package com.jcmlabs.spring_report;

import com.jcmlabs.spring_report.shared.entities.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.SoftDelete;

@Entity
@Table(name = "report")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE report SET deleted = true WHERE id = ?")
@SQLRestriction("deleted = false")
public class ReportEntity extends BaseEntity {
    private String test;
    private String description;
}
