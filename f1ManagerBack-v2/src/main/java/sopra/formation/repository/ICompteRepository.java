package sopra.formation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

	
/*	@Query("select distinct c from Compte c left join c.type where c.login=:login and  c.password=:password")
	Optional<Compte> findByLoginAndPasswordWithRoles(@Param("login") String login, @Param("password") String password);
}*/

@Query("select distinct c from Compte c where c.login=:login and  c.password=:password")
Optional<Compte> findByLoginAndPassword(@Param("login") String login, @Param("password") String password);
}

