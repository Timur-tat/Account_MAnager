package com.example.data.Entity.SingleTable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
//@Data
@Entity
public class Car1 extends Cars{
    @Column(nullable = true, unique = true)
    private String name;

    @Column(nullable = true)
    private int speed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car1{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                '}';
    }
}
