package sopra.formation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Ecurie;

public interface IEcurieRepository extends JpaRepository<Ecurie, Long>{
//findAllEcurie
//findEcurieById
//findEcurieByNom
//findEcurieByJoueur
	
	@Query("select distinct e from Ecurie e left join fetch e.pilotes p where e.id=:id")
	Optional<Ecurie> findEcurieWithPilotes(@Param ("id") Long id);
	
}
