package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Course;

public interface ICourseRepository extends JpaRepository<Course, Long>{
//findAllCourse
//@Query("select c from Course c")
//List<Course> findAllCourse(@Param("course") Course course);

//findCourseById
//@Query("select c from Course c where c.id = :id")
//Optional<Course> findCourseById(@Param("id") Long id);

//findCourseByNom
//@Query("select c from Course c where c.nom= :nom")
//Optional<Course> findCourseByNom(@Param("nom") String );

//findCourseByJoueur
}
