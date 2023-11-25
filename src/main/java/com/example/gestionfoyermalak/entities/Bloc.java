package com.example.gestionfoyermalak.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idBlog;
    String nomBloc;
    long capaciteBloc;
    @OneToMany(mappedBy="blocs")
    @JsonIgnore
    Set<Chambre> chambres;

    @ManyToOne
    @JsonIgnore
    Foyer foyers;
}
