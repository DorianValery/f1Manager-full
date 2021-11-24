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

import sopra.formation.model.Infrastructure;
import sopra.formation.repository.IInfrastructureRepository;



@RestController
@RequestMapping("/infrastructure")
@CrossOrigin("*")
public class InfrastructureRestController {

	@Autowired
	private IInfrastructureRepository infrastructureRepo;

	@GetMapping("")
	@JsonView(Views.ViewInfrastructure.class)
	public List<Infrastructure> findAll() {
		List<Infrastructure> infrastructures = infrastructureRepo.findAll();

		return infrastructures;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewInfrastructure.class)
	public Infrastructure find(@PathVariable Long id) {
		Optional<Infrastructure> optInfrastructure = infrastructureRepo.findById(id);

		if (optInfrastructure.isPresent()) {
			return optInfrastructure.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Infrastructure non trouvée");
		}
	}
	
	@GetMapping("{id}/detail")
	@JsonView(Views.ViewInfrastructureDetail.class)
	public Infrastructure detail(@PathVariable Long id) {
		Optional<Infrastructure> optInfrastructure = infrastructureRepo.findById(id);

		if (optInfrastructure.isPresent()) {
			return optInfrastructure.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Infrastructure non trouvée");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewInfrastructure.class)
	public Infrastructure create(@RequestBody Infrastructure infrastructure) {
		infrastructure = infrastructureRepo.save(infrastructure);

		return infrastructure;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewInfrastructure.class)
	public Infrastructure update(@PathVariable Long id, @RequestBody Infrastructure infrastructure) {
		if (!infrastructureRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Infrastructure non trouvée");
		}

		infrastructure = infrastructureRepo.save(infrastructure);

		return infrastructure;
	}

	@PatchMapping("/{id}")
	@JsonView(Views.ViewInfrastructure.class)
	public Infrastructure partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
		if (!infrastructureRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Infrastructure non trouvé");
		}

		Infrastructure infrastructureFind = infrastructureRepo.findById(id).get();

		if (updates.containsKey("nbIngenieurs")) {
			infrastructureFind.setNbIngenieurs((Integer) updates.get("comportemental"));
		}
		
		
		infrastructureFind = infrastructureRepo.save(infrastructureFind);

		return infrastructureFind;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!infrastructureRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Infrastructure non trouvé");
		}
		
		infrastructureRepo.deleteById(id);
	}

}
