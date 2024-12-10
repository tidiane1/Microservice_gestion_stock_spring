package sn.stock.fournisseur_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sn.stock.fournisseur_service.model.Fournisseur;

@Repository
public interface FournisseurRepository extends MongoRepository<Fournisseur, Integer>{
}
