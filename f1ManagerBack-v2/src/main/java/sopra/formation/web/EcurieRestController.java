package sopra.formation.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Ecurie;
import sopra.formation.repository.IEcurieRepository;


@RestController
@RequestMapping("/ecurie")
@CrossOrigin("*")
public class EcurieRestController {

		@Autowired
		private IEcurieRepository ecurieRepo;

		@GetMapping("")
		//@JsonView(Views.ViewEcurie.class)
		public List<Ecurie> findAll() {
			List<Ecurie> ecuries = ecurieRepo.findAll();

			return ecuries;
		}

		@GetMapping("{id}")
		//@JsonView(Views.ViewEcurie.class)
		public Ecurie find(@PathVariable Long id) {
			Optional<Ecurie> optEcurie = ecurieRepo.findById(id);

			if (optEcurie.isPresent()) {
				return optEcurie.get();
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ecurie non trouvé");
			}
		}

		@PostMapping("")
		//@JsonView(Views.ViewEcurie.class)
		public Ecurie create(@Valid @RequestBody Ecurie ecurie, BindingResult result) {
			if(result.hasErrors()) {
				throw new EcurieValidationException();
			}
			
			ecurie = ecurieRepo.save(ecurie);

			return ecurie;
		}

		@PutMapping("/{id}")
		//@JsonView(Views.ViewEcurie.class)
		public Ecurie update(@PathVariable Long id, @RequestBody Ecurie ecurie) {
			if (!ecurieRepo.existsById(id)) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ecurie non trouvé");
			}

			ecurie = ecurieRepo.save(ecurie);

			return ecurie;
		}
		
		@DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {
			if (!ecurieRepo.existsById(id)) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ecurie non trouvé");
			}
			
			ecurieRepo.deleteById(id);
		}

	}


