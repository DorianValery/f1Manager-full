package sopra.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@JsonView(Views.ViewCommon.class)
public class Pilote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 private String nom;
	 private String prenom;
	 private int age;
	 private String nationalite;
	 @Enumerated(EnumType.STRING)
	 @Column(name = "civilite", length = 5)
	 private Civilite civ;
	 private double experience;
	 private boolean etat;
	 private double prix;
	 @ManyToOne
	 @JoinColumn(name="ecurie_id")
	 @JsonView(Views.ViewPiloteDetail.class)
	 private Ecurie ecurie;
	 @OneToMany(mappedBy = "pilote")
	 @JsonView(Views.ViewPiloteDetail.class)
	 private List <Position> positions;
	 @ManyToOne
	 @JoinColumn(name="inventaire_id")
	 @JsonView(Views.ViewPiloteDetail.class)
	 private Inventaire inventaire;
	 
	 public Pilote() {}
	
	public Pilote(Long id, String nom, String prenom, int age, String nationalite, Civilite civ, double experience,
			boolean etat, double prix, Ecurie ecurie, List<Position> positions, Inventaire inventaire) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.nationalite = nationalite;
		this.civ = civ;
		this.experience = experience;
		this.etat = etat;
		this.prix = prix;
		this.ecurie = ecurie;
		this.positions = positions;
		this.inventaire = inventaire;
	}
	
	public Pilote(String nom, String prenom, int age, String nationalite, Civilite civ, double experience,
			boolean etat, double prix) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.nationalite = nationalite;
		this.civ = civ;
		this.experience = experience;
		this.etat = etat;
		this.prix = prix;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public Civilite getCiv() {
		return civ;
	}

	public void setCiv(Civilite civ) {
		this.civ = civ;
	}

	public double getExperience() {
		return experience;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Ecurie getEcurie() {
		return ecurie;
	}

	public void setEcurie(Ecurie ecurie) {
		this.ecurie = ecurie;
	}

	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}

	@Override
	public String toString() {
		return "Pilote [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", nationalite="
				+ nationalite + ", civ=" + civ + ", experience=" + experience + ", etat=" + etat + ", prix=" + prix
				+ ", ecurie=" + ecurie + ", positions=" + positions + ", inventaire=" + inventaire + "]";
	}
	 
	
	
	 

}
