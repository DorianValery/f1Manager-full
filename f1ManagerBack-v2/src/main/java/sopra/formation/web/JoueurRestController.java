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

import sopra.formation.model.Joueur;
import sopra.formation.model.Views;
import sopra.formation.repository.IJoueurRepository;

@RestController
@RequestMapping("/joueur")
@CrossOrigin("*")
public class JoueurRestController {

	@Autowired
	private IJoueurRepository joueurRepo;

	@GetMapping("")
	@JsonView(Views.ViewJoueur.class)
	public List<Joueur> findAll() {
		List<Joueur> joueurs = joueurRepo.findAll();

		return joueurs;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewJoueur.class)
	public Joueur find(@PathVariable Long id) {
		Optional<Joueur> optJoueur = joueurRepo.findById(id);

		if (optJoueur.isPresent()) {
			return optJoueur.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Joueur non trouvé");
		}
	}
	
	@GetMapping("{id}/detail")
	//@JsonView(Views.ViewJoueurDetail.class)
	public Joueur detail(@PathVariable Long id) {
		Optional<Joueur> optJoueur = joueurRepo.findById(id);

		if (optJoueur.isPresent()) {
			return optJoueur.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Joueur non trouvé");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewJoueur.class)
	public Joueur create(@RequestBody Joueur joueur) {
		joueur = joueurRepo.save(joueur);

		return joueur;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewJoueur.class)
	public Joueur update(@PathVariable Long id, @RequestBody Joueur joueur) {
		if (!joueurRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Joueur non trouvé");
		}

		joueur = joueurRepo.save(joueur);

		return joueur;
	}

	@PatchMapping("/{id}")
	@JsonView(Views.ViewJoueur.class)
	public Joueur partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
		if (!joueurRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Joueur non trouvé");
		}

		Joueur joueurFind = joueurRepo.findById(id).get();


		joueurFind = joueurRepo.save(joueurFind);

		return joueurFind;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!joueurRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Joueur non trouvé");
		}
		
		joueurRepo.deleteById(id);
	}
}
