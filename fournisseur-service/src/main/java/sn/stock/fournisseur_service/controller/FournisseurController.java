package sn.stock.fournisseur_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.stock.fournisseur_service.model.Fournisseur;
import sn.stock.fournisseur_service.service.FournisseurService;

@CrossOrigin("*")
@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {
    @Autowired
    private FournisseurService fournisseurService;
    @GetMapping("/{id}")
    public ResponseEntity<?> fetchFournisseurById(@PathVariable Integer id){
        return fournisseurService.fetchFournisseurById(id);
    }
    @GetMapping
    public ResponseEntity<?> fetchFournisseurs(){
        return fournisseurService.fetchFournisseurs();
    }
    @PostMapping
    public ResponseEntity<?> createFournisseur(@RequestBody Fournisseur fournisseur){
        return fournisseurService.createFournisseur(fournisseur);
    }
}
