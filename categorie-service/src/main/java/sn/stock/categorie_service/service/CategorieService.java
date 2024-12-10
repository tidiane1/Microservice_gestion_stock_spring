package sn.stock.categorie_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.stock.categorie_service.entity.Categorie;
import sn.stock.categorie_service.repository.CategorieRepository;

import java.util.List;
@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    public Categorie addCategorie(Categorie categorie){
        return categorieRepository.save(categorie);
    }
    public List<Categorie> fetchCategories(){
        return categorieRepository.findAll();
    }
    public Categorie fetchCategorieById(int id){
        return categorieRepository.findById(id).orElse(null);
    }
}
