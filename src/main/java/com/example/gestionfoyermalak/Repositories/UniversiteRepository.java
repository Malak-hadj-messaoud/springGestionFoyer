package com.example.gestionfoyermalak.Repositories;

import com.example.gestionfoyermalak.entities.Universite;
import org.springframework.data.repository.CrudRepository;

public interface UniversiteRepository extends CrudRepository<Universite,Long> {
    Universite findUniversiteByNomUnivercite(String nomUnivercite);
}
