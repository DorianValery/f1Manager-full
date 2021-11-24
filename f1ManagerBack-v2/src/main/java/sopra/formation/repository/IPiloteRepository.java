package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Pilote;

public interface IPiloteRepository extends JpaRepository<Pilote, Long>{
//findAllPilote
//findPiloteById
//findPiloteByNom
//findPiloteByNationalité
//findPiloteByJoueur
//findPiloteByPrix
}
