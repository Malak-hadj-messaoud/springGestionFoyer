package com.example.gestionfoyermalak.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idEtudiant;
    String nomEt , prenomEt , ecole;
    long cin;
    Date dateNaissance;

    @ManyToMany
   Set<Reservation> reservations;

}
