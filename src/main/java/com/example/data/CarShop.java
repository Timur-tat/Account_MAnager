package com.example.data;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarShop {
    public static void main(String[] args) {

    }
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String citi;
    private String street;
    private String houseNumber;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "model", column = @Column(name = "carsinfo_model")),
            @AttributeOverride( name = "color", column = @Column(name = "carsinfo_color")),
            @AttributeOverride( name = "price", column = @Column(name = "carsinfo_price")),
            @AttributeOverride( name = "complectation", column = @Column(name = "carsinfo_complectation"))
    })
    private CarsInfo carsInfo;

}
