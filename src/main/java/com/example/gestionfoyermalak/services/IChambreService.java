package com.example.gestionfoyermalak.services;

import com.example.gestionfoyermalak.entities.Chambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();

    Chambre  addChambre(Chambre c);
    Chambre updateChambre (Chambre  c);

    Chambre retrieveChambre (long idChambre);


}
