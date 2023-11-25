package com.example.gestionfoyermalak.services;

import com.example.gestionfoyermalak.entities.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservation();


    Reservation updateReservation (Reservation  res);

    Reservation retrieveReservation (String idReservation);
     Reservation ajouterReservation(long idChambre, long cinEtudiant);

}
