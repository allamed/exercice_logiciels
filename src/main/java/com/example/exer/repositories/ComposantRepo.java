package com.example.exer.repositories;

import com.example.exer.entities.Application;
import com.example.exer.entities.Composant;
import com.example.exer.entities.ComposantKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.net.URL;
@Repository
public interface ComposantRepo extends JpaRepository<Composant, ComposantKey> {
}
