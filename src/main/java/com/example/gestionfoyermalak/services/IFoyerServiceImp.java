package com.example.gestionfoyermalak.services;

import com.example.gestionfoyermalak.Repositories.BlocRepository;
import com.example.gestionfoyermalak.Repositories.FoyerRepository;
import com.example.gestionfoyermalak.Repositories.UniversiteRepository;
import com.example.gestionfoyermalak.entities.Bloc;
import com.example.gestionfoyermalak.entities.Etudiant;
import com.example.gestionfoyermalak.entities.Foyer;
import com.example.gestionfoyermalak.entities.Universite;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class IFoyerServiceImp implements IFoyerService{

    private final FoyerRepository foyerRepository;
    private final UniversiteRepository universiteRepository;
    private final BlocRepository blocRepository;
    @Override
    public List<Foyer> retrieveAllFoyers() {

        return (List<Foyer> )foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElseThrow(()->new IllegalArgumentException("no foyer found with this id"));
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);

    }

    @Override
    @Transactional
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        //nasna3 el objet univercite eli bech n'affecti fih el foyer
        Universite univercite=universiteRepository.findById(idUniversite).orElseThrow();
        //jebna el list mta3 les bloc mta3 el foyer w bech nhotouhom fi westou
        Set<Bloc>blocs=foyer.getBlocs();
        //sajalnah fil base
        foyerRepository.save(foyer);
        //parcourina 3a list mta3 les bloc w zednahon bel wahda fi west el foyer w sajalnahom fil base
        for(Bloc b:blocs){
            b.setFoyers(foyer);
            blocRepository.save(b);
        }
        //affectina el foyer fil univercite
        univercite.setFoyers(foyer);
        //sajalna el univercité fil base
        //universiteRepository.save(univercite); najem nesta4na 3liha w n3awedhha bel @Transactional tawa wahdou wahdou el objet eli sna3nah eli howa univercite ya3mel el modification eli 3malnahom fil fonction ysajelha fil base
        return foyer;






      //  return Foyer;
    }
}
