package com.example.gestionfoyermalak.Controller;


import com.example.gestionfoyermalak.entities.Etudiant;
import com.example.gestionfoyermalak.services.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("etudiant")
public class EtudiantController {


    @Autowired
    private IEtudiantService iEtudiantService;

    @GetMapping
    public List<Etudiant> retrieveAllEtudiants(){
        return iEtudiantService.retrieveAllEtudiants();
    }

    @PostMapping
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants){
        return iEtudiantService.addEtudiants(etudiants);
    }

    @PutMapping
    public Etudiant updateEtudiant(@RequestBody Etudiant e){
        return iEtudiantService.updateEtudiant(e);
    }

    @GetMapping("{idEtudiant}")
    public Etudiant retrieveEtudiant(@PathVariable long idEtudiant){
        return iEtudiantService.retrieveEtudiant(idEtudiant) ;
    }

    @DeleteMapping("{idEtudiant}")
    public void removeEtudiant(@PathVariable long idEtudiant){
        iEtudiantService.retrieveEtudiant(idEtudiant);
    }



}
