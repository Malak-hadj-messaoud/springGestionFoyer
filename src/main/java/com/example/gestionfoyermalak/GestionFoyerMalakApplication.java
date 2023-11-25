package com.example.gestionfoyermalak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy

public class GestionFoyerMalakApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionFoyerMalakApplication.class, args);
    }

}
