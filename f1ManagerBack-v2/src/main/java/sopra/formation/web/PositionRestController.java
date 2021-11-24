package sopra.formation.web;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Position;
import sopra.formation.model.Views;
import sopra.formation.repository.IPositionRepository;

@RestController
@RequestMapping("/position")
@CrossOrigin("*")
public class PositionRestController {

	@Autowired
	private IPositionRepository positionRepo;

	@GetMapping("")
	@JsonView(Views.ViewPosition.class)
	public List<Position> findAll() {
		List<Position> positions = positionRepo.findAll();

		return positions;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewPosition.class)
	public Position find(@PathVariable Long id) {
		Optional<Position> optPosition = positionRepo.findById(id);

		if (optPosition.isPresent()) {
			return optPosition.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Position non trouvé");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewPosition.class)
	public Position create(@RequestBody Position position) {
		position = positionRepo.save(position);

		return position;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewPosition.class)
	public Position update(@PathVariable Long id, @RequestBody Position position) {
		if (!positionRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Position non trouvé");
		}

		position = positionRepo.save(position);

		return position;
	}

	@PatchMapping("/{id}")
	@JsonView(Views.ViewPosition.class)
	public Position partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
		if (!positionRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Position non trouvé");
		}

		Position positionFind = positionRepo.findById(id).get();


		positionFind = positionRepo.save(positionFind);

		return positionFind;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!positionRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Position non trouvé");
		}
		
		positionRepo.deleteById(id);
	}

}
