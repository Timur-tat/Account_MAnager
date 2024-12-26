package com.example.data.Entity.SingleTable;

import com.example.data.Entity.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
//@Data
@Entity
public class Car2 extends Cars {
    @Column(nullable = true, unique = true)
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private Status status1;
    @Enumerated(EnumType.STRING)
    private Status status2;
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
        return "Car2{" +
                "name='" + name + '\'' +
                ", status1=" + status1 +
                ", status2=" + status2 +
                ", speed=" + speed +
                '}';
    }
}
