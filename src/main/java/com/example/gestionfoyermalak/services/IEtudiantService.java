package com.example.gestionfoyermalak.services;

import com.example.gestionfoyermalak.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();
    List<Etudiant> addEtudiants (List<Etudiant> etudiants);
    Etudiant updateEtudiant (Etudiant e);
    Etudiant retrieveEtudiant(long idEtudiant);

    void removeEtudiant(long idEtudiant);

}
