package com.jcmlabs.spring_report;

import com.jcmlabs.spring_report.shared.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "report")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE report SET deleted = true WHERE id = ?")
@SQLRestriction("deleted = false")
public class ReportEntity extends BaseEntity {

    @Column(name = "name",unique = true)
    private String name;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Column(name = "owner")
    private String owner;
}
