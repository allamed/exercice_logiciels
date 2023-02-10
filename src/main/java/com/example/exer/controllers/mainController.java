package com.example.exer.controllers;

import com.example.exer.entities.Application;
import com.example.exer.entities.Categorie;
import com.example.exer.entities.Librairie;
import com.example.exer.entities.Logiciel;
import com.example.exer.repositories.ApplicationRepo;
import com.example.exer.repositories.CategorieRepo;
import com.example.exer.repositories.LibrairieRepo;
import com.example.exer.repositories.LogicielRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class mainController {

    @Autowired
    LogicielRepo logRepo;
    @Autowired
    ApplicationRepo appRepo;
    @Autowired
    LibrairieRepo libRepo;
    @Autowired
    CategorieRepo catRepo;


    @GetMapping(path = "/logs")
    @CrossOrigin(origins = "*")
    public ResponseEntity getLogiciels(){
        List<Logiciel> logs = logRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(logs);
    }

    @GetMapping(path = "/apps")
    @CrossOrigin(origins = "*")
    public ResponseEntity getApplications(){
        List<Application> apps = appRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(apps);
    }
    @GetMapping(path = "/libs")
    @CrossOrigin(origins = "*")
    public ResponseEntity getLibraries(){
        List<Librairie> libs = libRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(libs);
    }

    @GetMapping(path = "/cats")
    @CrossOrigin(origins = "*")
    public ResponseEntity getCategories(){
        List<Categorie> cats = catRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(cats);
    }
}
