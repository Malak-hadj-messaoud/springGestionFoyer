package com.example.gestionfoyermalak.services;

import com.example.gestionfoyermalak.Repositories.BlocRepository;
import com.example.gestionfoyermalak.Repositories.ChambreRepository;
import com.example.gestionfoyermalak.entities.Bloc;
import com.example.gestionfoyermalak.entities.Chambre;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
@Service
@RequiredArgsConstructor

public class IChambreServiceImp implements IChambreService{
    private final ChambreRepository chambreRepository;
    private final BlocRepository blocRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return (List<Chambre>) chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepository.findById(idChambre).orElseThrow(() -> new IllegalArgumentException("No chambre Found with this id"));
    }




}
