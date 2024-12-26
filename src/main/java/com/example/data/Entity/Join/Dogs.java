//package com.example.data.Entity.Join;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "dogs_type", discriminatorType = DiscriminatorType.STRING)
//public class Dogs {
//
//
//        @Id
//        @GeneratedValue(strategy = GenerationType.AUTO)
//        private Long id;
//
//        @Column(nullable = true, updatable = true)
//        private LocalDateTime createdAt;
//
//        @Column(nullable = true)
//        private LocalDateTime updatedAt;
//
//        @PrePersist
//        protected void onCreate() {
//            this.createdAt = LocalDateTime.now();
//            this.updatedAt = LocalDateTime.now();
//        }
//
//        @PreUpdate
//        protected void onUpdate() {
//            this.updatedAt = LocalDateTime.now();
//        }
//}
