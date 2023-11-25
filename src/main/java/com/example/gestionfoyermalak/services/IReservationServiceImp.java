package com.example.gestionfoyermalak.services;

import com.example.gestionfoyermalak.Repositories.BlocRepository;
import com.example.gestionfoyermalak.Repositories.ChambreRepository;
import com.example.gestionfoyermalak.Repositories.EtudiantRepository;
import com.example.gestionfoyermalak.Repositories.ReservationRepository;
import com.example.gestionfoyermalak.entities.Bloc;
import com.example.gestionfoyermalak.entities.Chambre;
import com.example.gestionfoyermalak.entities.Etudiant;
import com.example.gestionfoyermalak.entities.Reservation;
import com.example.gestionfoyermalak.entities.enumeration.TypeChambre;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor

public class IReservationServiceImp implements IReservationService{

    private final ReservationRepository reservationRepository;
    private final ChambreRepository chambreRepository;
    private final EtudiantRepository etudiantRepository;
    private final BlocRepository blocRepository;
    @Override
    public List<Reservation> retrieveAllReservation() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {

        return reservationRepository.findById(idReservation).orElseThrow(() -> new IllegalArgumentException("No Reservation Found with this id"));

    }
    @Override
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {

        Chambre chambre = chambreRepository.findById(idChambre).orElseThrow(null);
        Etudiant etudiant = etudiantRepository.findEtudiantByCin(cinEtudiant);


        Bloc bloc = blocRepository.findById(chambre.getBlocs().getIdBlog()).orElseThrow();
        Reservation chambreReserve = null ;
        chambreReserve = reservationRepository.findByChambre(idChambre) ;

        Reservation res =reservationRepository.findById(   String.valueOf(chambre.getNumerochambre())+"-"+ bloc.getIdBlog() +"-"+ LocalDate.now().getYear()).orElse(null);
        if(res==null) {
            res = new Reservation();
            res.setAnneeUniversaire(LocalDate.of(LocalDate.now().getYear(), 8, 15));
            res.setIdReservation(
                    String.valueOf(chambre.getNumerochambre()) + "-" + bloc.getIdBlog() + "-" + LocalDate.now().getYear()
            );

        }




        if(chambreReserve == null || chambreReserve.getAnneeUniversaire().getYear() < LocalDate.now().getYear() ){
            if(chambre.getTypeC() == TypeChambre.SIMPLE){
                res.setEstValide(false);
            }
            else {
                res.setEstValide(true);
            }
            chambre.getReservations().add(res);
            if (res.getEtudiants()==null)
            {
                Set<Etudiant> etudiants=new HashSet<>();
                etudiants.add(etudiant);
                res.setEtudiants(etudiants);
            }
            else {
                res.getEtudiants().add(etudiant);
            }


            reservationRepository.save(res);
            chambreRepository.save(chambre);

        } else if (res.getAnneeUniversaire().getYear() < LocalDate.now().getYear()) {
            if(chambre.getTypeC() == TypeChambre.SIMPLE){
                res.setEstValide(false);
            } else {
                res.setEstValide(true);
            }
            reservationRepository.save(res);


        } else {
            if(res.isEstValide() ){
                if(reservationRepository.getNumberReservation(res.getIdReservation()) ==  1 && chambre.getTypeC() == TypeChambre.DOUBLE){
                    res.setEstValide(false);
                    reservationRepository.save(res);

                } else if(reservationRepository.getNumberReservation(res.getIdReservation()) == 1 && chambre.getTypeC() == TypeChambre.TRIPLE){
                    res.setEstValide(true);
                    reservationRepository.save(res);
                }else{
                    res.setEstValide(false);
                }
                if (res.getEtudiants()==null)
                {
                    Set<Etudiant>etudiants=new HashSet<>();
                    etudiants.add(etudiant);
                    res.setEtudiants(etudiants);
                }
                else {
                    res.getEtudiants().add(etudiant);
                }


                reservationRepository.save(res);
            }
        }


        return  res ;
    }
}
