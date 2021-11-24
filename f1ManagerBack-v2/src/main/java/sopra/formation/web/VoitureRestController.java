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

import sopra.formation.model.Views;
import sopra.formation.model.Voiture;
import sopra.formation.repository.IVoitureRepository;

@RestController
@RequestMapping("/voiture")
@CrossOrigin("*")
public class VoitureRestController {

	@Autowired
	private IVoitureRepository voitureRepo;

	@GetMapping("")
	@JsonView(Views.ViewVoiture.class)
	public List<Voiture> findAll() {
		List<Voiture> voitures = voitureRepo.findAll();

		return voitures;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewVoiture.class)
	public Voiture find(@PathVariable Long id) {
		Optional<Voiture> optvoiture = voitureRepo.findById(id);

		if (optvoiture.isPresent()) {
			return optvoiture.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "voiture non trouvée");
		}
	}
	
	@GetMapping("{id}/detail")
	//@JsonView(Views.ViewVoitureDetail.class)
	public Voiture detail(@PathVariable Long id) {
		Optional<Voiture> optvoiture = voitureRepo.findById(id);

		if (optvoiture.isPresent()) {
			return optvoiture.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "voiture non trouvée");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewVoiture.class)
	public Voiture create(@RequestBody Voiture voiture) {
		voiture = voitureRepo.save(voiture);

		return voiture;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewVoiture.class)
	public Voiture update(@PathVariable Long id, @RequestBody Voiture voiture) {
		if (!voitureRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "voiture non trouvée");
		}

		voiture = voitureRepo.save(voiture);

		return voiture;
	}

	@PatchMapping("/{id}")
	@JsonView(Views.ViewVoiture.class)
	public Voiture partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
		if (!voitureRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "voiture non trouvée");
		}

		Voiture voitureFind = voitureRepo.findById(id).get();


		voitureFind = voitureRepo.save(voitureFind);

		return voitureFind;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!voitureRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "voiture non trouvée");
		}
		
		voitureRepo.deleteById(id);
	}
}
