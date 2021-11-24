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

import sopra.formation.model.Pilote;
import sopra.formation.model.Views;
import sopra.formation.repository.IPiloteRepository;

@RestController
@RequestMapping("/pilote")
@CrossOrigin("*")
public class PiloteRestController {

	@Autowired
	private IPiloteRepository piloteRepo;

	@GetMapping("")
	@JsonView(Views.ViewPilote.class)
	public List<Pilote> findAll() {
		List<Pilote> pilotes = piloteRepo.findAll();

		return pilotes;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewPilote.class)
	public Pilote find(@PathVariable Long id) {
		Optional<Pilote> optPilote = piloteRepo.findById(id);

		if (optPilote.isPresent()) {
			return optPilote.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pilote non trouvé");
		}
	}
	
	@GetMapping("{id}/detail")
	@JsonView(Views.ViewPiloteDetail.class)
	public Pilote detail(@PathVariable Long id) {
		Optional<Pilote> optPilote = piloteRepo.findById(id);

		if (optPilote.isPresent()) {
			return optPilote.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pilote non trouvé");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewPilote.class)
	public Pilote create(@RequestBody Pilote pilote) {
		pilote = piloteRepo.save(pilote);

		return pilote;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewPilote.class)
	public Pilote update(@PathVariable Long id, @RequestBody Pilote pilote) {
		if (!piloteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pilote non trouvé");
		}

		pilote = piloteRepo.save(pilote);

		return pilote;
	}

	@PatchMapping("/{id}")
	@JsonView(Views.ViewPilote.class)
	public Pilote partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
		if (!piloteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pilote non trouvé");
		}

		Pilote piloteFind = piloteRepo.findById(id).get();


		piloteFind = piloteRepo.save(piloteFind);

		return piloteFind;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!piloteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pilote non trouvé");
		}
		
		piloteRepo.deleteById(id);
	}
}
