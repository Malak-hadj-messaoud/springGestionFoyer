package com.example.gestionfoyermalak.Controller;

import com.example.gestionfoyermalak.entities.Chambre;
import com.example.gestionfoyermalak.services.IChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("chambre")
public class ChambreController {
    @Autowired
    private IChambreService iChambreService;

    @GetMapping
    public List<Chambre> retrieveAllChambres() {
        return iChambreService.retrieveAllChambres();
    }

    @PostMapping
    public Chambre addChambre(@RequestBody Chambre c) {
        return iChambreService.addChambre(c);
    }

    @PutMapping
    public Chambre updateChambre(@RequestBody Chambre c) {
        return iChambreService.updateChambre(c);
    }

    @GetMapping("{idChambre}")
    public Chambre retrieveChambre(@PathVariable long idChambre) {
        return iChambreService.retrieveChambre(idChambre);
    }
}
