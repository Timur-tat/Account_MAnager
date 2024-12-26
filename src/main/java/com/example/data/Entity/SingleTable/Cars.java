package com.example.data.Entity.SingleTable;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
//@Data
@MappedSuperclass
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "cars_type")
public abstract class Cars {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(nullable = true, updatable = true)
        private LocalDateTime createdAt;

        @Column(nullable = true)
        private LocalDateTime updatedAt;

        @PrePersist
        protected void onCreate() {
            this.createdAt = LocalDateTime.now();
            this.updatedAt = LocalDateTime.now();
        }

        @PreUpdate
        protected void onUpdate() {
            this.updatedAt = LocalDateTime.now();
        }


    }
