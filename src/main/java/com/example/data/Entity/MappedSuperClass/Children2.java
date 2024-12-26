package com.example.data.Entity.MappedSuperClass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Children2 extends Parents{
    @Column(nullable = true, unique = true)
    private String lastname;

    @Column(nullable = true)
    private int age;




}
