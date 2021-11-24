package sopra.formation.web.dto;

import java.time.Duration;
import java.util.List;

import sopra.formation.model.Course;
import sopra.formation.model.Ecurie;
import sopra.formation.model.Position;

public class CourseDTO {

	private Long id;
	private String nom;
	private int nombreTour; 
	private Duration tempsRef;
	private double cashPrize;
	private List <Position> classement;
	private double popularite;
	private List<Ecurie> ecuries;
	private int degats1;
	private int usurePneus1;
	private int degats2;
	private int usurePneus2;


	public CourseDTO(Course course) {
		super();
		this.id = course.getId();
		this.nom = course.getNom();
		this.nombreTour = course.getNombreTour();
		this.tempsRef = course.getTempsRef();
		this.cashPrize = course.getCashPrize();
		this.classement = course.getClassement();
		this.popularite = course.getCashPrize();
		this.ecuries = course.getEcuries();
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


	public int getDegats1() {
		return degats1;
	}


	public void setDegats1(int degats1) {
		this.degats1 = degats1;
	}


	public int getUsurePneus1() {
		return usurePneus1;
	}


	public void setUsurePneus1(int usurePneus1) {
		this.usurePneus1 = usurePneus1;
	}


	public int getDegats2() {
		return degats2;
	}


	public void setDegats2(int degats2) {
		this.degats2 = degats2;
	}


	public int getUsurePneus2() {
		return usurePneus2;
	}


	public void setUsurePneus2(int usurePneus2) {
		this.usurePneus2 = usurePneus2;
	}
		
}
