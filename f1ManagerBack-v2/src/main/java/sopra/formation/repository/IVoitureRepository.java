package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Voiture;

public interface IVoitureRepository extends JpaRepository<Voiture, Long>{
//findAllVoiture
//findVoitureById
//findVoitureByMarque
//findVoitureByJoueur
//findVoitureByPrix
}
