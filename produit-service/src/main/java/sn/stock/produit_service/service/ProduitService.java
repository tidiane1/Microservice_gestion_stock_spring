package sn.stock.produit_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.stock.produit_service.entity.Produit;
import sn.stock.produit_service.repository.ProduitRepository;

import java.util.List;
@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public Produit addProduit(Produit produit){
        return produitRepository.save(produit);
    }
    public List<Produit> fetchProduits(){
        return produitRepository.findAll();
    }
    public Produit fetchProduitById(int id){
        return produitRepository.findById(id).orElse(null);
    }
}
