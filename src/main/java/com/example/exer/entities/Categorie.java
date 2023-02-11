package com.example.exer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Categorie {
    @Id
    private String nom;
    @ManyToMany(mappedBy = "categoriesSecondaires")
    @JsonIgnore
    private List<Logiciel> logicielsSec;
    @OneToMany(mappedBy = "categoriePrincipale")
    @JsonIgnore
    private List<Logiciel> logicielsPrin;

}
