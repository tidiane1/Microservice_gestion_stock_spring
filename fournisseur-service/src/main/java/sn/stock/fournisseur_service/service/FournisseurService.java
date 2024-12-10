package sn.stock.fournisseur_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sn.stock.fournisseur_service.dto.FournisseurReponse;
import sn.stock.fournisseur_service.dto.Produit;
import sn.stock.fournisseur_service.model.Fournisseur;
import sn.stock.fournisseur_service.repository.FournisseurRepository;

import java.util.List;
import java.util.Optional;
@Service
public class FournisseurService {
    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?> createFournisseur(Fournisseur fournisseur){
        try{
            return new ResponseEntity<Fournisseur>(fournisseurRepository.save(fournisseur), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> fetchFournisseurById(Integer id){
        Optional<Fournisseur> fournisseur =  fournisseurRepository.findById(id);
        if(fournisseur.isPresent()){
            Produit produit = restTemplate.getForObject("http://localhost:8082/produit/" + fournisseur.get().getProduitId(), Produit.class);
            FournisseurReponse fournisseurResponse = new FournisseurReponse(
                    fournisseur.get().getId(),
                    fournisseur.get().getName(),
                    fournisseur.get().getAge(),
                    fournisseur.get().getGender(),
                    fournisseur.get().getAdress(),
                    fournisseur.get().getMail(),
                    fournisseur.get().getTel(),
                    produit
            );
            return new ResponseEntity<>(fournisseurResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Fournisseur Found",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> fetchFournisseurs(){
        List<Fournisseur> fournisseurs = fournisseurRepository.findAll();
        if(fournisseurs.size() > 0){
            return new ResponseEntity<List<Fournisseur>>(fournisseurs, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No Fournisseur",HttpStatus.NOT_FOUND);
        }
    }

}
