package com.jcmlabs.spring_report.shared.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
@Entity
public class BaseEntity {
    private LocalDateTime createdAt;
    private Long createdBy;

    private LocalDateTime updatedBy;

}
