package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Infrastructure;

public interface IInfrastructureRepository extends JpaRepository<Infrastructure, Long>{
//findAllInfrastructure
//findInfrastructureById
//findInfrastructureByNom
//findInfrastructureByType
//findInfrastructureByJoueur
//findInfrastructureByPrix
}
