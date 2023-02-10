package com.example.exer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Licence {
    @EmbeddedId
    private LicenceKey key;

    @Lob
    private String texte;
    @ManyToMany (mappedBy = "licences" )
    @JsonIgnore
    List<Logiciel> logiciels;
    @ManyToMany (mappedBy = "licences")
    @JsonIgnore
    List<Composant> composantsAttaches;
}
