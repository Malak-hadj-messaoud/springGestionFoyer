package com.example.gestionfoyermalak.Controller;

import com.example.gestionfoyermalak.entities.Foyer;
import com.example.gestionfoyermalak.services.IFoyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("foyer")
public class FoyerController {
    @Autowired
    private IFoyerService iFoyerService;

    @GetMapping
    public List<Foyer> retrieveAllFoyers(){
       return iFoyerService.retrieveAllFoyers();
    }

    @PostMapping
    public Foyer addFoyer(@RequestBody Foyer f){
        return iFoyerService.addFoyer(f);
    }

    @PutMapping
    public Foyer updateFoyer(@RequestBody Foyer f){
        return iFoyerService.updateFoyer(f) ;
    }

    @GetMapping("{idFoyer}")
    public Foyer retrieveFoyer(@PathVariable long idFoyer){
        return iFoyerService.retrieveFoyer(idFoyer);
    }

    @DeleteMapping("{idFoyer}")
    public void removeFoyer(@PathVariable long idFoyer){
        iFoyerService.removeFoyer(idFoyer);
    }


    @PostMapping("{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite (@RequestBody Foyer foyer,@PathVariable long idUniversite) {
        return iFoyerService.ajouterFoyerEtAffecterAUniversite(foyer,idUniversite);
    }
}
