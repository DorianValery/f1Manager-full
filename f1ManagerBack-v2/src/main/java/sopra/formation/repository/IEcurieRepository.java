package sopra.formation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Ecurie;
import sopra.formation.model.Joueur;


public interface IEcurieRepository extends JpaRepository<Ecurie, Long>{
//findAllEcurie
//findEcurieById
//findEcurieByNom
//findEcurieByJoueur
	
	@Query("select distinct e from Ecurie e left join fetch e.pilotes p where e.id=:id")
	Optional<Ecurie> findEcurieWithPilotes(@Param ("id") Long id);
	@Query("select distinct e from Ecurie e left join fetch e.voitures v where e.id=:id")
	Optional<Ecurie> findEcurieWithVoitures(@Param ("id") Long id);
	@Query("select distinct e from Ecurie e left join fetch e.infrastructures i where e.id=:id")
	Optional<Ecurie> findEcurieWithInfrastructures(@Param ("id") Long id);
	
	//@Query("select distinct e from Ecurie e left join fetch e.argent a where e.id=:id")
	//Optional<Ecurie> findEcurieWithArgent(@Param("id") Long id);
	
	
	@Query("select e.argent from Joueur j join j.ecurie e where j = :joueur")
	int findArgentRawByJoueur(@Param("joueur") Joueur joueur);
	
	//SELECT argent FROM ecurie where inventaire_id=ecurie_id
	//SELECT argent FROM ecurie left join fetch joueur where joueur.inventaire_id=joueur.ecurie_id
}
