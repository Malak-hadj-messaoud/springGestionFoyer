package com.example.gestionfoyermalak.Repositories;

import com.example.gestionfoyermalak.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository extends CrudRepository<Reservation,String> {
    @Query(value = "SELECT * FROM reservation r JOIN chambre_reservations cr WHERE r.id_reservation = cr.reservations_id_reservation AND cr.chambre_numchambre = :idChambre ",nativeQuery = true)
    public  Reservation findByChambre(@Param("idChambre") Long idChambre);
    @Query(value = "SELECT COUNT(*) FROM reservation_etudiants WHERE reservations_id_reservation = :ReservationId ",nativeQuery = true)
    public Long getNumberReservation(@Param("ReservationId") String ReservationId);}

