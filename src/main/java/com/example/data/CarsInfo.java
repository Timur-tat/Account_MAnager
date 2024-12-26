package com.example.data;

import jakarta.persistence.Embeddable;
import lombok.Data;


@Data
@Embeddable
public class CarsInfo {
    public static void main(String[] args) {

    }
    private String model;
    private String color;
    private int price;
    private String complectation;
}
