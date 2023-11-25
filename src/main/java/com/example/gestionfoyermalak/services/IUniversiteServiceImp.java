package com.example.gestionfoyermalak.services;

import com.example.gestionfoyermalak.Repositories.FoyerRepository;
import com.example.gestionfoyermalak.Repositories.UniversiteRepository;
import com.example.gestionfoyermalak.entities.Foyer;
import com.example.gestionfoyermalak.entities.Universite;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class IUniversiteServiceImp implements IUniversiteService{

    private final UniversiteRepository universiteRepository;
    private final FoyerRepository foyerRepository;
    @Override
    public List<Universite> retrieveAllUniversities() {
        return (List<Universite>) universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElseThrow(() -> new IllegalArgumentException("No université Found with this id"));
    }


    @Transactional
    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        //jeb objet uni fih (1,djerba,isetsjerba,null)
        Universite universite=universiteRepository.findUniversiteByNomUnivercite(nomUniversite);
        //jeb objet foyer hab el id mta3ou (id:...)
        Foyer foyer= foyerRepository.findById(idFoyer).orElseThrow();
        //affectina el foyer fi univercite
        universite.setFoyers(foyer);
        //universiteRepository.save(universite); n3awedhha bel @Transactional
        return universite;






      //  Universite universite=universiteRepository.findUniversiteByNomUnivercite(nomUniversite);//jebna el univercite hasb el no mta3ha
      ////  Foyer foyer=foyerRepository.findById(idFoyer).orElseThrow(() -> new IllegalArgumentException("No Foyer Found with this id"));//jebna el foyer hasb el id

    ////    universite.setFoyers(foyer);//hotina el foyer fi west el univercite
      //  return universiteRepository.save(universite) ;//sajalna el khedma eli khdemnaha fi west el univercite
    }
    @Transactional
    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite=universiteRepository.findById(idUniversite).orElseThrow();
        universite.setFoyers(null);
        return universite;




        /*

        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new IllegalArgumentException("No univercite Found with this id"));

        universite.setFoyers(null);


        return universite;*/
    }
}
