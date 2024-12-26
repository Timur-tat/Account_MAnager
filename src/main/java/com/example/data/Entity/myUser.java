package com.example.data.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

//@DiscriminatorValue("myUser") // Значение для столбца discriminator
@Entity
public class myUser extends BaseEntity {

    @Column(nullable = true, unique = true)
    private String username;

    @Column(nullable = true)
    private String password;

    // Геттеры и сеттеры
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "myUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}