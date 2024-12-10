package sn.stock.distributeur_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.stock.distributeur_service.model.Distributeur;
import sn.stock.distributeur_service.service.DistributeurService;

@CrossOrigin("*")
@RestController
@RequestMapping("/distributeur")
public class DistributeurController {
    @Autowired
    private DistributeurService distributeurService;
    @GetMapping("/{id}")
    public ResponseEntity<?> fetchDistributeurById(@PathVariable Integer id){
        return distributeurService.fetchDistributeurById(id);
    }
    @GetMapping
    public ResponseEntity<?> fetchDistributeurs(){
        return distributeurService.fetchDistributeurs();
    }
    @PostMapping
    public ResponseEntity<?> createDistributeur(@RequestBody Distributeur distributeur){
        return distributeurService.createDistributeur(distributeur);
    }
}
