package com.example.exer.repositories;

import com.example.exer.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.net.URL;
@Repository
public interface ApplicationRepo extends JpaRepository<Application, URL> {
}
