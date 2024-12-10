package sn.stock.categorie_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.stock.categorie_service.entity.Categorie;
import sn.stock.categorie_service.service.CategorieService;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/categorie")
@RestController
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @PostMapping
    public Categorie addCategorie(@RequestBody Categorie categorie){
        return categorieService.addCategorie(categorie);
    }
    @GetMapping
    public List<Categorie> fetchCategories(){
        return  categorieService.fetchCategories();
    }
    @GetMapping("/{id}")
    public Categorie fetchCategorieById(@PathVariable int id){
        return categorieService.fetchCategorieById(id);
    }
}
