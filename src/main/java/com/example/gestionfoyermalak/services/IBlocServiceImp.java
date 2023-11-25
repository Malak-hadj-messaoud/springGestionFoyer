package com.example.gestionfoyermalak.services;

import com.example.gestionfoyermalak.Repositories.BlocRepository;
import com.example.gestionfoyermalak.Repositories.ChambreRepository;
import com.example.gestionfoyermalak.entities.Bloc;
import com.example.gestionfoyermalak.entities.Chambre;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.webjars.NotFoundException;

import java.util.*;

@Service
@RequiredArgsConstructor

public class IBlocServiceImp implements IBlocService{
    private final BlocRepository blocRepository;
    private final ChambreRepository chambreRepository;

    @Override
    public List<Bloc> retrieveBlocs() {
        return (List<Bloc>) blocRepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElseThrow(()->new IllegalArgumentException("No bloc found with this id"));
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepository.deleteById(idBloc);

    }


    @Override
    @Transactional
    public Bloc affecterChambresABloc(List<Long> numChambres, long idBloc) {
        Bloc bloc=blocRepository.findById(idBloc).orElseThrow();
        List<Chambre>chambres=(List)chambreRepository.findAllById(numChambres);
        for(Chambre ch : chambres){
            ch.setBlocs(bloc);
        }
        //chambreRepository.saveAll(chambres);
        return bloc;


     //   Bloc bloc = blocRepository.findById(idBloc)
              //  .orElseThrow(() -> new NotFoundException("Bloc non trouvé avec l'identifiant : " + idBloc));





       //// for (Long i : numChambres) {
           // Chambre chambre = chambreRepository.findById(i)
          //          .orElseThrow(() -> new NotFoundException("chambre non trouvé avec l'identifiant : " + i));
        //    chambre.setBlocs(bloc);
    //    }
      //  return bloc ;
    }


}
