package sopra.formation.web.dto;

import sopra.formation.model.Course;
import sopra.formation.model.Pilote;
import sopra.formation.model.Position;



public class PositionDTO {


	private Long id;
	private int version;
	private Pilote pilote;
	private Course course;
	private int position;
	
	public PositionDTO(Position position) {
		super();
		this.id = position.getId();
		this.pilote = position.getPilote();
		this.course = position.getCourse();
		if(position.getPosition() != 0) {
			this.position = position.getPosition();
		}
		
	}
	
	public PositionDTO() {
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

