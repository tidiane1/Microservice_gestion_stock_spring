package sn.stock.categorie_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.stock.categorie_service.entity.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Integer> {
}