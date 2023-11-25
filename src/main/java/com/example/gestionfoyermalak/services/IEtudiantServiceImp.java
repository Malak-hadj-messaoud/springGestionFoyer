package com.example.gestionfoyermalak.services;

import com.example.gestionfoyermalak.Repositories.EtudiantRepository;
import com.example.gestionfoyermalak.entities.Etudiant;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class IEtudiantServiceImp implements IEtudiantService{
    private final EtudiantRepository etudiantRepository;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return (List<Etudiant> )etudiantRepository.findAll();
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return (List<Etudiant> )etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElseThrow(() -> new IllegalArgumentException("No Etudiant Found with this id"));
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);

    }
}
