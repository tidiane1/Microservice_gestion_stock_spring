package sn.stock.distributeur_service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sn.stock.distributeur_service.dto.Categorie;
import sn.stock.distributeur_service.dto.DistributeurReponse;
import sn.stock.distributeur_service.model.Distributeur;
import sn.stock.distributeur_service.repository.DistributeurRepository;

import java.util.List;
import java.util.Optional;
@Service
public class DistributeurService {
    @Autowired
    private DistributeurRepository distributeurRepository;
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?> createDistributeur(Distributeur distributeur){
        try{
            return new ResponseEntity<Distributeur>(distributeurRepository.save(distributeur), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> fetchDistributeurById(Integer id){
        Optional<Distributeur> distributeur =  distributeurRepository.findById(id);
        if(distributeur.isPresent()){
            Categorie categorie = restTemplate.getForObject("http://localhost:8083/categorie/" + distributeur.get().getCategorieId(), Categorie.class);
            DistributeurReponse distributeurReponse = new DistributeurReponse(
                    distributeur.get().getId(),
                    distributeur.get().getName(),
                    distributeur.get().getAge(),
                    distributeur.get().getGender(),
                    distributeur.get().getAdress(),
                    distributeur.get().getMail(),
                    distributeur.get().getTel(),
                    categorie
            );
            return new ResponseEntity<>(distributeurReponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Distributeur Found",HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<?> fetchDistributeurs(){
        List<Distributeur> distributeurs = distributeurRepository.findAll();
        if(distributeurs.size() > 0){
            return new ResponseEntity<List<Distributeur>>(distributeurs, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No Distributeur",HttpStatus.NOT_FOUND);
        }
    }
}
