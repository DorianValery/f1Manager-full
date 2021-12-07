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
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@JsonView(Views.ViewCommon.class)
public class Pilote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	 private String nom;
	 private String prenom;
	 private int age;
	 private String nationalite;
	 private double position;
	@Enumerated(EnumType.STRING)
	 @Column(name = "civilite", length = 5)
	 private Civilite civ;
	 private double experience;
	 private double prix;
	 @ManyToOne
	 @JsonView(Views.ViewPiloteDetail.class)
	 private Ecurie ecurie;
	 @OneToMany(mappedBy = "pilote")
	 @JsonView(Views.ViewPiloteDetail.class)
	 private List <Position> positions;
	 @OneToMany(mappedBy = "pilote")
	 @JsonView(Views.ViewPiloteDetail.class)
	 private List<Inventaire> inventaires;
	 private String  imagePilote;
	 
	 public Pilote() {}
	
	public Pilote(Long id, String nom, String prenom, int age, String nationalite, Civilite civ, double experience,
			 double prix, Ecurie ecurie, List<Position> positions, List<Inventaire> inventaires, String imagePilote ) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.nationalite = nationalite;
		this.civ = civ;
		this.experience = experience;
		this.prix = prix;
		this.ecurie = ecurie;
		this.positions = positions;
		this.inventaires = inventaires;
		this.imagePilote=imagePilote;
	}
	
	public Pilote(String nom, String prenom, int age, String nationalite, Civilite civ, double experience,
			 double prix) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.nationalite = nationalite;
		this.civ = civ;
		this.experience = experience;
		
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



	public List<Inventaire> getInventaires() {
		return inventaires;
	}

	public void setInventaires(List<Inventaire> inventaires) {
		this.inventaires = inventaires;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	public String getImagePilote() {
		return imagePilote;
	}

	public void setImagePilote(String imagePilote) {
		this.imagePilote = imagePilote;
	}
	
	 public double getPosition() {
			return position;
		}

		public void setPosition(double position) {
			this.position = position;
		}

		@Override
		public String toString() {
			return "Pilote [id=" + id + ", version=" + version + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age
					+ ", nationalite=" + nationalite + ", position=" + position + ", civ=" + civ + ", experience="
					+ experience + ", etat=" +  ", prix=" + prix + ", ecurie=" + ecurie + ", positions="
					+ positions + ", inventaires=" + inventaires + ", imagePilote=" + imagePilote + "]";
		}


 

}
