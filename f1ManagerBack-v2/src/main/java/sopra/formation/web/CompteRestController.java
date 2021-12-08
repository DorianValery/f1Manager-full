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

import sopra.formation.model.Compte;
import sopra.formation.model.Joueur;
import sopra.formation.model.Views;
import sopra.formation.repository.ICompteRepository;
import sopra.formation.repository.IJoueurRepository;
import sopra.formation.web.dto.InscriptionDTO;
import sopra.formation.web.dto.SeConnecterForm;

@RestController
@RequestMapping("/compte")
@CrossOrigin("*")
public class CompteRestController {

	@Autowired
	private ICompteRepository compteRepo;

	@Autowired
	private IJoueurRepository joueurRepo;

	@GetMapping("")
	@JsonView(Views.ViewCompte.class)
	public List<Compte> findAll() {
		List<Compte> comptes = compteRepo.findAll();

		return comptes;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewCompte.class)
	public Compte find(@PathVariable Long id) {
		Optional<Compte> optCompte = compteRepo.findById(id);

		if (optCompte.isPresent()) {
			return optCompte.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Compte non trouvé");
		}
	}

	@GetMapping("{id}/detail")
	// @JsonView(Views.ViewCompteDetail.class)
	public Compte detail(@PathVariable Long id) {
		Optional<Compte> optCompte = compteRepo.findById(id);

		if (optCompte.isPresent()) {
			return optCompte.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Compte non trouvé");
		}
	}

	// se connecter
	@PostMapping("/seconnecter")
	// @JsonView(Views.ViewCompteWithRoles.class)
	@JsonView(Views.ViewCompte.class)
	public Compte seconnecter(@RequestBody SeConnecterForm seconnecter) {
		Optional<Compte> optCompte = compteRepo.findByLoginAndPassword(seconnecter.getLogin(),
				seconnecter.getPassword());

		if (optCompte.isPresent()) {
			return optCompte.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Compte non trouvé");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewCompte.class)
	public Compte create(@RequestBody Compte compte) {
		compte = compteRepo.save(compte);

		return compte;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCompte.class)
	public Compte update(@PathVariable Long id, @RequestBody Compte compte) {
		if (!compteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Compte non trouvé");
		}

		compte = compteRepo.save(compte);

		return compte;
	}

	@PatchMapping("/{id}")
	@JsonView(Views.ViewCompte.class)
	public Compte partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
		if (!compteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Compte non trouvé");
		}

		Compte compteFind = compteRepo.findById(id).get();

		compteFind = compteRepo.save(compteFind);

		return compteFind;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!compteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Compte non trouvé");
		}

		compteRepo.deleteById(id);
	}

	@PostMapping("/inscription")
	@JsonView(Views.ViewCompte.class)
	public Compte create(@RequestBody InscriptionDTO inscription) {
		Joueur joueur = new Joueur();
		joueur.setMail(inscription.getMail());
		joueur.setAge(inscription.getAge());
		joueur.setCiv(inscription.getCivilite());

		joueur = joueurRepo.save(joueur);
		
		Compte compte = new Compte();
		compte.setLogin(inscription.getLogin());
		compte.setPassword(inscription.getPassword());
		compte.setJoueur(joueur);
		
		compte = compteRepo.save(compte);
		
		return compte;
	}
}
