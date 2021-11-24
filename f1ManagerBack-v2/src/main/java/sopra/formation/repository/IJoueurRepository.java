package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Joueur;

public interface IJoueurRepository extends JpaRepository<Joueur, Long>{
//findAllJoueur
//findJoueurById
//findJoueurByEmail
//findJoueurByPeudo
//findJoueurByTelephone
}
