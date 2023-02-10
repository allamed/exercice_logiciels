package com.example.exer.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
@Embeddable @Data @AllArgsConstructor @NoArgsConstructor
public class ComposantKey implements Serializable {
    private String code;
    private Version version;
}
