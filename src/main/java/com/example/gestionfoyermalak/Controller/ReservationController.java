package com.example.gestionfoyermalak.Controller;

import com.example.gestionfoyermalak.entities.Reservation;
import com.example.gestionfoyermalak.services.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservation")
public class ReservationController {
    @Autowired
    private IReservationService iReservationService;

    @GetMapping
    public List<Reservation> retrieveAllReservation(){
        return iReservationService.retrieveAllReservation();
    }

    @PutMapping
    public Reservation updateReservation(@RequestBody Reservation res){
        return iReservationService.updateReservation(res);
    }

    @GetMapping("{idReservation}")
    public Reservation retrieveReservation(@PathVariable String idReservation){
        return iReservationService.retrieveReservation(idReservation);
    }

    @PostMapping("{idChambre}/{cinEtudiant}")
    public Reservation ajouterReservation(@PathVariable long idChambre, @PathVariable long cinEtudiant){
        return iReservationService.ajouterReservation(idChambre,cinEtudiant);
    }
}
