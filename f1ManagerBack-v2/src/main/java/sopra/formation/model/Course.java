package sopra.formation.model;

import java.time.Duration;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private int nombreTour; 
	private Duration tempsRef;
	private double cashPrize;
	@OneToMany(mappedBy = "course")
	private List <Position> classement;
	private double popularite;
	@ManyToMany
	@JoinTable(name = "ecuriesInscrites", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "ecurie_id"), uniqueConstraints = @UniqueConstraint(columnNames = {
			"course_id", "ecurie_id" }))
	private List<Ecurie> ecuries;
	
	public Course(Long id, String nom, int nombreTour, Duration tempsRef, double cashPrize, List<Position> classement,
			double popularite, List<Ecurie> ecuries) {
		super();
		this.id = id;
		this.nom = nom;
		this.nombreTour = nombreTour;
		this.tempsRef = tempsRef;
		this.cashPrize = cashPrize;
		this.classement = classement;
		this.popularite = popularite;
		this.ecuries = ecuries;
	}

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNombreTour() {
		return nombreTour;
	}

	public void setNombreTour(int nombreTour) {
		this.nombreTour = nombreTour;
	}

	public Duration getTempsRef() {
		return tempsRef;
	}

	public void setTempsRef(Duration tempsRef) {
		this.tempsRef = tempsRef;
	}

	public double getCashPrize() {
		return cashPrize;
	}

	public void setCashPrize(double cashPrize) {
		this.cashPrize = cashPrize;
	}

	public List<Position> getClassement() {
		return classement;
	}

	public void setClassement(List<Position> classement) {
		this.classement = classement;
	}

	public double getPopularite() {
		return popularite;
	}

	public void setPopularite(double popularite) {
		this.popularite = popularite;
	}

	public List<Ecurie> getEcuries() {
		return ecuries;
	}

	public void setEcuries(List<Ecurie> ecuries) {
		this.ecuries = ecuries;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", nom=" + nom + ", nombreTour=" + nombreTour + ", tempsRef=" + tempsRef
				+ ", cashPrize=" + cashPrize + ", classement=" + classement + ", popularite=" + popularite
				+ ", ecuries=" + ecuries + "]";
	}
	
	
	
}
