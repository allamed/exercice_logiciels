package com.example.exer.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.net.URL;
import java.util.List;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Composant {
    @EmbeddedId
    private ComposantKey key;
    private String description;
    private URL url;
    @ManyToMany
    private List<Licence> licences;
}
