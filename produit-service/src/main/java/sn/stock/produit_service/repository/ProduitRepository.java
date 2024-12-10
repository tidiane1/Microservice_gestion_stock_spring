package sn.stock.produit_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.stock.produit_service.entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Integer> {
}