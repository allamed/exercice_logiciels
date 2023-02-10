package com.example.exer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity @Data @AllArgsConstructor @NoArgsConstructor

public class Librairie extends Logiciel{
   @ManyToMany
    private List<Librairie> dependances;


}
