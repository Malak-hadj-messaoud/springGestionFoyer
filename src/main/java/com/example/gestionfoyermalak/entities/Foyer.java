package com.example.gestionfoyermalak.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idFoyer;
    String nomFoyer;
    long capaciteFoyer;
    @OneToOne(mappedBy = "foyers")
    Universite univercites;

    @OneToMany(mappedBy="foyers")
    Set<Bloc> blocs;
}
