package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Position;

public interface IPositionRepository extends JpaRepository<Position, Long>{

}
