package com.example.gestionfoyermalak.Repositories;

import com.example.gestionfoyermalak.entities.Etudiant;
import org.springframework.data.repository.CrudRepository;

public interface EtudiantRepository extends CrudRepository<Etudiant,Long> {
   Etudiant findEtudiantByCin(long cin);
}
