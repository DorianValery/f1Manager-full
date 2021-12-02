package sopra.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@JsonView(Views.ViewCommon.class)
public class Infrastructure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	private String nom;
	private typeInfra type;
	private int nbIngenieurs;
	private int pitStop;
	private double experience;
	private boolean etat;
	private double prix;
	@OneToOne
	@JoinColumn(name="ecurie")
	@JsonView(Views.ViewInfrastructureDetail.class)
	private Ecurie ecurie;
	@ManyToOne
	@JoinColumn(name="inventaire")
	@JsonView(Views.ViewInfrastructureDetail.class)
	private Inventaire inventaire;
	
	public Infrastructure(Long id, String nom, typeInfra type, int nbIngenieurs, int pitStop, double experience,
			boolean etat, double prix, Ecurie ecurie, Inventaire inventaire) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.nbIngenieurs = nbIngenieurs;
		this.pitStop = pitStop;
		this.experience = experience;
		this.etat = etat;
		this.prix = prix;
		this.ecurie = ecurie;
		this.inventaire = inventaire;
	}
	
	public Infrastructure(Long id, String nom, typeInfra type, int nbIngenieurs, int pitStop, double experience,
			boolean etat, double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.nbIngenieurs = nbIngenieurs;
		this.pitStop = pitStop;
		this.experience = experience;
		this.etat = etat;
		this.prix = prix;
	}

	public Infrastructure() {
		
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

	public typeInfra getType() {
		return type;
	}

	public void setType(typeInfra type) {
		this.type = type;
	}

	public int getNbIngenieurs() {
		return nbIngenieurs;
	}

	public void setNbIngenieurs(int nbIngenieurs) {
		this.nbIngenieurs = nbIngenieurs;
	}

	public int getPitStop() {
		return pitStop;
	}

	public void setPitStop(int pitStop) {
		this.pitStop = pitStop;
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

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Infrastructure [id=" + id + ", nom=" + nom + ", type=" + type + ", nbingenieurs=" + nbIngenieurs
				+ ", pitStop=" + pitStop + ", experience=" + experience + ", etat=" + etat + ", prix=" + prix
				+ ", ecurie=" + ecurie + ", inventaire=" + inventaire + "]";
	}
	
	
}
