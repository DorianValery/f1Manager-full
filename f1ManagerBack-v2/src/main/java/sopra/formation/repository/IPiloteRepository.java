package sopra.formation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Pilote;


public interface IPiloteRepository extends JpaRepository<Pilote, Long>{
//findAllPilote
//findPiloteById
//findPiloteByNom
//findPiloteByNationalité
//findPiloteByJoueur
//findPiloteByPrix
	
	
	//Query findall Pilote
	
	//findbyID ou l’état est pris en compte (enabled / disabled) :
	//@Query("select distinct p from Pilote p left join fetch p.etat e where p.id = :id")
	//Optional<Pilote> findPiloteByIdWithEtat(@Param("id")Long id);
	
	//findbyID ou l’état est pris en compte (enabled / disabled) + le prix si disabled :
	//@Query("select distinct p from Pilote p join fetch p.prix=p.etat where p.id = :id ") 
	//Optional<Pilote> findPiloteByIdWithEtatAndPrix(@Param("id")Long id);
	
	
}
