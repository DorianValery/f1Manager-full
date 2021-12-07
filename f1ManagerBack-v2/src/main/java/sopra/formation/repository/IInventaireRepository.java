package sopra.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Inventaire;
import sopra.formation.model.Voiture;

public interface IInventaireRepository extends JpaRepository<Inventaire, Long>{
//findAllInventaire
//findInventaireById
//findInventaireByJoueur
	@Query("select distinct i.voiture.id from Inventaire i  where i.joueur.id=:id and i.voiture != null")
	List <Integer> finddAllInventaireByIdJoueurWithVoitures(@Param("id") Long id);
	
	@Query("select distinct i.infrastructure.id from Inventaire i  where i.joueur.id=:id and i.infrastructure != null")
	List <Integer> finddAllInventaireByIdJoueurWithInfrastructure(@Param("id") Long id);
}
