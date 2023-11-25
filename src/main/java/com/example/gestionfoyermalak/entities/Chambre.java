package com.example.gestionfoyermalak.entities;

import com.example.gestionfoyermalak.entities.enumeration.TypeChambre;
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
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)

    long numchambre;
    long numerochambre;
    @Enumerated(EnumType.STRING)
    TypeChambre typeC;
    @OneToMany
    Set<Reservation> reservations;
    @ManyToOne
    Bloc blocs;

}
