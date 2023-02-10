package com.example.exer.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.descriptor.java.ClobJavaType;

import java.io.Serializable;
@Data @NoArgsConstructor @AllArgsConstructor @Embeddable
public class LicenceKey implements Serializable {
    private String nom;
    private Version version;
    private String langue;


}
