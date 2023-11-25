package com.example.gestionfoyermalak.Repositories;

import com.example.gestionfoyermalak.entities.Bloc;
import com.example.gestionfoyermalak.entities.Chambre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface BlocRepository extends CrudRepository<Bloc,Long> {
    //List<Chambre> findByChambres(Set<Chambre> chambres);
    List<Bloc> findByChambresIn(Set<Chambre> chambres);

}
