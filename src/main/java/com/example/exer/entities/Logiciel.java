package com.example.exer.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Logiciel {
    @EmbeddedId
    private LogicielKey key;
    //@NonNull
    private String description;
   //@NonNull
    private URL url;
    @ManyToOne
    private Categorie categoriePrincipale;
    @ManyToMany
    private List<Categorie> categoriesSecondaires;
    @ManyToMany
    private List<Application> applicationsDep;
    @ManyToMany
    private List<Licence> licences;
    @OneToMany
    private final List<Composant> composants= new ArrayList<Composant>();



}
