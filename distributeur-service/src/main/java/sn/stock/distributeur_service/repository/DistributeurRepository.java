package sn.stock.distributeur_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sn.stock.distributeur_service.model.Distributeur;

@Repository
public interface DistributeurRepository extends MongoRepository<Distributeur, Integer>{
}
