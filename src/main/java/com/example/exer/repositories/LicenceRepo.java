package com.example.exer.repositories;

import com.example.exer.entities.Application;
import com.example.exer.entities.Licence;
import com.example.exer.entities.LicenceKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.net.URL;
@Repository
public interface LicenceRepo extends JpaRepository<Licence, LicenceKey> {
}
