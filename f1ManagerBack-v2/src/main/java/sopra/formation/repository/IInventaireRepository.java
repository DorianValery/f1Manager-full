package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Inventaire;

public interface IInventaireRepository extends JpaRepository<Inventaire, Long>{
//findAllInventaire
//findInventaireById
//findInventaireByJoueur
}
