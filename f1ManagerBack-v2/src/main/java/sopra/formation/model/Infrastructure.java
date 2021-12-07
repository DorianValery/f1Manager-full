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
	private double prix;
	@ManyToOne
	@JoinColumn(name="ecurie_id")
	@JsonView(Views.ViewInfrastructureDetail.class)
	private Ecurie ecurie;
	@OneToMany(mappedBy="infrastructure")
	@JsonView(Views.ViewInfrastructureDetail.class)
	private List<Inventaire> inventaires;
	
	public Infrastructure(Long id, String nom, typeInfra type, int nbIngenieurs, int pitStop, double experience,
			boolean etat, double prix, Ecurie ecurie, List<Inventaire> inventaires) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.nbIngenieurs = nbIngenieurs;
		this.pitStop = pitStop;
		this.experience = experience;
		this.prix = prix;
		this.ecurie = ecurie;
		this.inventaires = inventaires;
	}
	
	public Infrastructure(Long id, String nom, typeInfra type, int nbIngenieurs, int pitStop, double experience,
		 double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.nbIngenieurs = nbIngenieurs;
		this.pitStop = pitStop;
		this.experience = experience;
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

	@Override
	public String toString() {
		return "Infrastructure [id=" + id + ", version=" + version + ", nom=" + nom + ", type=" + type
				+ ", nbIngenieurs=" + nbIngenieurs + ", pitStop=" + pitStop + ", experience=" + experience + ", etat="
				 + ", prix=" + prix + ", ecurie=" + ecurie + ", inventaires=" + inventaires + "]";
	}


	
	
}
