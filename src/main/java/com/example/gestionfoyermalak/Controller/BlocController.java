package com.example.gestionfoyermalak.Controller;

import com.example.gestionfoyermalak.Repositories.BlocRepository;
import com.example.gestionfoyermalak.entities.Bloc;
import com.example.gestionfoyermalak.entities.Chambre;
import com.example.gestionfoyermalak.services.IBlocService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bloc")
//@RequiredArgsConstructor
public class BlocController {
    @Autowired
    private  IBlocService iBlocService;

    @GetMapping
    public List<Bloc> retrieveBlocs(){
        return iBlocService.retrieveBlocs();
    }

    @PostMapping
    public Bloc addBloc(@RequestBody Bloc bloc){
    return iBlocService.addBloc(bloc);
    }

    @PutMapping
    public Bloc updateBloc(@RequestBody Bloc bloc){
        return iBlocService.updateBloc(bloc);
    }

    @GetMapping("{idBloc}")
    public Bloc retrieveBloc(@PathVariable long idBloc){
        return iBlocService.retrieveBloc(idBloc);
    }


    @DeleteMapping("{idBloc}")
    public void removeBloc(@PathVariable long idBloc){
        iBlocService.removeBloc(idBloc);
    }


    @PutMapping("{idBloc}")
    public  Bloc affecterChambresABloc(@RequestBody List<Long> numChambre, @PathVariable long idBloc){
        return iBlocService.affecterChambresABloc(numChambre,idBloc);
    }




}
