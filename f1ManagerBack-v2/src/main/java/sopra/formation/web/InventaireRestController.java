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

import sopra.formation.model.Inventaire;
import sopra.formation.model.Views;
import sopra.formation.repository.IInventaireRepository;

@RestController
@RequestMapping("/inventaire")
@CrossOrigin("*")
public class InventaireRestController {

	@Autowired
	private IInventaireRepository inventaireRepo;

	@GetMapping("")
	@JsonView(Views.ViewInventaire.class)
	public List<Inventaire> findAll() {
		List<Inventaire> inventaires = inventaireRepo.findAll();

		return inventaires;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewInventaire.class)
	public Inventaire find(@PathVariable Long id) {
		Optional<Inventaire> optInventaire = inventaireRepo.findById(id);

		if (optInventaire.isPresent()) {
			return optInventaire.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventaire non trouvé");
		}
	}
	
	@GetMapping("{id}/detail")
	@JsonView(Views.ViewInventaireDetail.class)
	public Inventaire detail(@PathVariable Long id) {
		Optional<Inventaire> optInventaire = inventaireRepo.findById(id);

		if (optInventaire.isPresent()) {
			return optInventaire.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventaire non trouvé");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewInventaire.class)
	public Inventaire create(@RequestBody Inventaire inventaire) {
		inventaire = inventaireRepo.save(inventaire);

		return inventaire;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewInventaire.class)
	public Inventaire update(@PathVariable Long id, @RequestBody Inventaire inventaire) {
		if (!inventaireRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventaire non trouvé");
		}

		inventaire = inventaireRepo.save(inventaire);

		return inventaire;
	}

	@PatchMapping("/{id}")
	@JsonView(Views.ViewInventaire.class)
	public Inventaire partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
		if (!inventaireRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventaire non trouvé");
		}

		Inventaire inventaireFind = inventaireRepo.findById(id).get();


		inventaireFind = inventaireRepo.save(inventaireFind);

		return inventaireFind;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!inventaireRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventaire non trouvé");
		}
		
		inventaireRepo.deleteById(id);
	}
}
