package sopra.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@JsonView(Views.ViewCommon.class)
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@ManyToOne
	@JoinColumn(name="pilote_id")
	@JsonView(Views.ViewPosition.class)
	private Pilote pilote;
	@ManyToOne
	@JoinColumn(name="course_id")
	@JsonView(Views.ViewPosition.class)
	private Course course;
	private int position;
	
	public Position(Long id, Pilote pilote, Course course, int position) {
		super();
		this.id = id;
		this.pilote = pilote;
		this.course = course;
		this.position = position;
	}
	
	public Position() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pilote getPilote() {
		return pilote;
	}

	public void setPilote(Pilote pilote) {
		this.pilote = pilote;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", pilote=" + pilote + ", course=" + course + ", position=" + position + "]";
	}
	
	
	
}

