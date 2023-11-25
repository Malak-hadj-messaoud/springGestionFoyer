package com.example.gestionfoyermalak.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation {
    @Id
    String idReservation;
    LocalDate anneeUniversaire;
    boolean estValide;
    @ManyToMany(mappedBy = "reservations")//kan ma3adech fama etudiant ma3adech fama reservation
    Set<Etudiant> etudiants;


}
