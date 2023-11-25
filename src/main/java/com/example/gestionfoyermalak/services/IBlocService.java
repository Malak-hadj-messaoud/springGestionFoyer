package com.example.gestionfoyermalak.services;

import com.example.gestionfoyermalak.entities.Bloc;
import com.example.gestionfoyermalak.entities.Chambre;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveBlocs();

    Bloc updateBloc (Bloc  bloc);

    Bloc addBloc (Bloc bloc);

    Bloc retrieveBloc (long  idBloc);

    void removeBloc (long idBloc);

    Bloc affecterChambresABloc(List<Long> numChambre, long idBloc);
}
