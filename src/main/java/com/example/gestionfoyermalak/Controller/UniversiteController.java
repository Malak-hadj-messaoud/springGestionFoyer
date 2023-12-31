package com.example.gestionfoyermalak.Controller;

import com.example.gestionfoyermalak.entities.Universite;
import com.example.gestionfoyermalak.services.IUniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("universite")
public class UniversiteController {
    @Autowired
    private IUniversiteService iUniversiteService;


    @GetMapping
    public List<Universite> retrieveAllUniversities(){
        return iUniversiteService.retrieveAllUniversities();
    }
    @PostMapping
    public Universite addUniversite(@RequestBody Universite u){
        return iUniversiteService.addUniversite(u);
    }
    @PutMapping
    public Universite updateUniversite(@RequestBody Universite u){
        return iUniversiteService.updateUniversite(u);
    }
    @GetMapping("{idUniversite}")
    public Universite retrieveUniversite(@PathVariable long idUniversite){
        return iUniversiteService.retrieveUniversite(idUniversite);
    }
    @PutMapping("{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite (@PathVariable long idFoyer,@PathVariable String nomUniversite){
        return iUniversiteService.affecterFoyerAUniversite(idFoyer,nomUniversite);
    } ;

    @PutMapping("{idUniversite}")
    public Universite desaffecterFoyerAUniversite (@PathVariable long idUniversite) {
        return iUniversiteService.desaffecterFoyerAUniversite(idUniversite);
    }


}
