package com.example.data.homework1818;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Film {
    @EmbeddedId
    private FilmID filmID;
    private String name;
    private String language;

}
