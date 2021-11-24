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

import sopra.formation.model.Course;
import sopra.formation.model.Views;
import sopra.formation.repository.ICourseRepository;

@RestController
@RequestMapping("/course")
@CrossOrigin("*")
public class CourseRestController {

	@Autowired
	private ICourseRepository courseRepo;

	@GetMapping("")
	@JsonView(Views.ViewCourse.class)
	public List<Course> findAll() {
		List<Course> courses = courseRepo.findAll();

		return courses;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewCourse.class)
	public Course find(@PathVariable Long id) {
		Optional<Course> optCourse = courseRepo.findById(id);

		if (optCourse.isPresent()) {
			return optCourse.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course non trouvé");
		}
	}
	

	@PostMapping("")
	@JsonView(Views.ViewCourse.class)
	public Course create(@RequestBody Course course) {
		course = courseRepo.save(course);

		return course;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCourse.class)
	public Course update(@PathVariable Long id, @RequestBody Course course) {
		if (!courseRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course non trouvé");
		}

		course = courseRepo.save(course);

		return course;
	}

	@PatchMapping("/{id}")
	@JsonView(Views.ViewCourse.class)
	public Course partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
		if (!courseRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course non trouvé");
		}

		Course courseFind = courseRepo.findById(id).get();


		courseFind = courseRepo.save(courseFind);

		return courseFind;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!courseRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course non trouvé");
		}
		
		courseRepo.deleteById(id);
	}

}
