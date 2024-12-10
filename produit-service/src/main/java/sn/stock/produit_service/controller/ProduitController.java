package sn.stock.produit_service.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.stock.produit_service.entity.Produit;
import sn.stock.produit_service.service.ProduitService;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/produit")
@RestController
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @PostMapping
    public Produit addProduit(@RequestBody Produit produit){
        return produitService.addProduit(produit);
    }
    @GetMapping
    public List<Produit> fetchProduits(){
        return  produitService.fetchProduits();
    }
    @GetMapping("/{id}")
    public Produit fetchProduitById(@PathVariable int id){
        return produitService.fetchProduitById(id);
    }
}
