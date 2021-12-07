package sopra.formation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@JsonView(Views.ViewCommon.class)
public class Inventaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	
	@ManyToOne
	@JoinColumn(name="joueur_id")
	@JsonView(Views.ViewInventaire.class)
	private Joueur joueur;
	@ManyToOne
	@JoinColumn(name="infrastructure_id")
	@JsonView(Views.ViewInventaire.class)
	private Infrastructure infrastructure;
	@ManyToOne
	@JoinColumn(name="voiture_id")
	@JsonView(Views.ViewInventaire.class)
	private  Voiture voiture;
	@ManyToOne
	@JoinColumn(name="pilote_id")
	@JsonView(Views.ViewInventaireDetail.class)
	private Pilote pilote;
	
	public Inventaire(Long id,  Joueur joueur, Infrastructure infrastructure,
			Voiture voiture, Pilote pilote) {
		super();
		this.id = id;
		
		this.joueur = joueur;
		this.infrastructure = infrastructure;
		this.voiture = voiture;
		this.pilote = pilote;
	}
	



	public Inventaire() {
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}


	public Infrastructure getInfrastructure() {
		return infrastructure;
	}


	public void setInfrastructure(Infrastructure infrastructure) {
		this.infrastructure = infrastructure;
	}


	public Voiture getVoiture() {
		return voiture;
	}


	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}


	public Pilote getPilote() {
		return pilote;
	}


	public void setPilote(Pilote pilote) {
		this.pilote = pilote;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}




	@Override
	public String toString() {
		return "Inventaire [id=" + id + ", version=" + version + ", joueur=" + joueur + ", infrastructure="
				+ infrastructure + ", voiture=" + voiture + ", pilote=" + pilote + "]";
	}



	
	
	
	
}
