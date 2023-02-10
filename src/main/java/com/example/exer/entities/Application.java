package com.example.exer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Application extends Logiciel{
   // @Id
   // public URL getUrl(){
    //    return super.getUrl();
    //}
    @ManyToMany(mappedBy = "applicationsDep")
    @JsonIgnore
    private List<Logiciel> logiciels;
}
