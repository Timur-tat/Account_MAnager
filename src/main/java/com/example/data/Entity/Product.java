package com.example.data.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("PRODUCT") // Значение для столбца discriminator
@Entity
public class Product extends BaseEntity {

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private Double price;

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}