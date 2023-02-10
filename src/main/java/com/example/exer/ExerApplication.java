package com.example.exer;

import com.example.exer.entities.*;
import com.example.exer.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class ExerApplication {

    @Autowired
    CategorieRepo catRepo;
    @Autowired
    LogicielRepo logRepo;
    @Autowired
    LicenceRepo licRepo;
    @Autowired
    ComposantRepo compRepo;



    public static void main(String[] args) {
        SpringApplication.run(ExerApplication.class, args);
    }


    @Bean
    CommandLineRunner start(){

        return args -> {

            Categorie cat1=new Categorie();
            Categorie cat2= new Categorie();
            Categorie cat3= new Categorie();
            Categorie cat4= new Categorie();
            cat1.setNom("cat1"); cat2.setNom("cat2");cat3.setNom("cat3");cat4.setNom("cat4");



            catRepo.save(cat1);
            catRepo.save(cat2);
            catRepo.save(cat3);
            catRepo.save(cat4);
            Version v1= new Version();

            v1.setMax(20);
            v1.setMin(10);

            Version v2= new Version();
            v2.setMax(30);
            v2.setMin(15);

            Logiciel log1= new Application();
            Logiciel log2= new Librairie();
            LogicielKey logkey1=new LogicielKey();
            LogicielKey logkey2=new LogicielKey();
            logkey1.setNom("logKey1");
            logkey1.setVersion(v1);
            logkey2.setNom("logKey2");
            logkey2.setVersion(v2);
            log1.setKey(logkey1);
            log2.setKey(logkey2);
            log1.setCategoriePrincipale(cat1);
            log2.setCategoriePrincipale(cat2);
            List<Categorie> cats= new ArrayList<Categorie>();
            cats.add(cat3);cats.add(cat4);
            log1.setCategoriesSecondaires(cats);
            log2.setCategoriesSecondaires(cats);
            log1.setDescription("desc1");
            log1.setUrl(new URL("https://chat.openai.com/chat"));
            log2.setDescription("desc2");
            log2.setUrl(new URL("https://chat.openai.com/chat"));
            List<Application> apps= new ArrayList<>();
            apps.add((Application) log1);
            log1.setApplicationsDep(apps);

            logRepo.save(log1);
            logRepo.save(log2);
            System.out.println(log1.getKey());



        };
    }
}
