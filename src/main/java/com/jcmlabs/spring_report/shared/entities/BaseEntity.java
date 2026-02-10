package com.jcmlabs.spring_report.shared.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass
@Entity
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;
    private Long createdBy;

    private LocalDateTime updatedAt;
    private Long updatedBy;

    private String uuid;

}
