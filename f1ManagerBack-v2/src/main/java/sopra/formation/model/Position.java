package sopra.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@JsonView(Views.ViewCommon.class)
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="pilote_id")
	@JsonView(Views.ViewPosition.class)
	private Pilote pilote;
	@ManyToOne
	@JoinColumn(name="course_id")
	@JsonView(Views.ViewPosition.class)
	private Course course;
	private byte position;
	
	public Position(Long id, Pilote pilote, Course course, byte position) {
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

	public byte getPosition() {
		return position;
	}

	public void setPosition(byte position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", pilote=" + pilote + ", course=" + course + ", position=" + position + "]";
	}
	
	
	
}

