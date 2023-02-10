package com.example.exer.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Embeddable @Data @NoArgsConstructor @AllArgsConstructor @ToString
public class LogicielKey implements Serializable {
    private String nom;
    private Version version;
}
