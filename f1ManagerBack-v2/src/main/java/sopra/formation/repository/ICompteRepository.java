package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Compte;

public interface ICompteRepository extends JpaRepository<Compte, Long> {	
//findAllCompte
//@Query("select c from Compte c")
//List<Compte> findAllCompte(@Param("compte") Compte compte);

//findCompteById
//@Query("select c from Compte c where c.id = :id")
//Optional<Compte> findCompteById(@Param("id") Long id);

//findCompteByType
//@Query("select c from Compte c where c.type = :type")
//Optional<Compte> findCompteByType(@Param("type") String type);

}
