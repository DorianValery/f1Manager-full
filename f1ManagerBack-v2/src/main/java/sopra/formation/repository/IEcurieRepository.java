package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Ecurie;

public interface IEcurieRepository extends JpaRepository<Ecurie, Long>{
//findAllEcurie
//findEcurieById
//findEcurieByNom
//findEcurieByJoueur
}
