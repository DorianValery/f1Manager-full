package sopra.formation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@JsonView(Views.ViewCommon.class)
public class Voiture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	private String marque;
	private int maniabilite;
	private int vitesse;
	private int poids;
	//private boolean etat;
	private int prix;
	private String image ;
	@ManyToOne
	@JoinColumn(name="ecurie_id")
	@JsonView(Views.ViewVoitureDetail.class)
	private Ecurie ecurie;
	@OneToMany(mappedBy = "voiture")
	@JsonView(Views.ViewVoitureDetail.class)
	private List<Inventaire> inventaires;
	
	public Voiture(Long id, String marque, int maniabilite, int vitesse, int poids, /*boolean etat,*/ int prix,
			Ecurie ecurie, List<Inventaire> inventaires) {
		super();
		this.id = id;
		this.marque = marque;
		this.maniabilite = maniabilite;
		this.vitesse = vitesse;
		this.poids = poids;
		//this.etat = etat;
		this.prix = prix;
		this.ecurie = ecurie;
		this.inventaires = inventaires;
	}

	public Voiture() {
		// TODO Auto-generated constructor stub
	}

	
	public Voiture(String marque, int maniabilite, int vitesse, int poids, boolean etat, int prix) {
		this.marque = marque;
		this.maniabilite = maniabilite;
		this.vitesse = vitesse;
		this.poids = poids;
		//this.etat = etat;
		this.prix = prix;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getManiabilite() {
		return maniabilite;
	}

	public void setManiabilite(int maniabilite) {
		this.maniabilite = maniabilite;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	/*public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}*/

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Voiture [id=" + id + ", version=" + version + ", marque=" + marque + ", maniabilite=" + maniabilite
				+ ", vitesse=" + vitesse + ", poids=" + poids + ", etat=" +  ", prix=" + prix + ", image=" + image
				+ ", ecurie=" + ecurie + ", inventaires=" + inventaires + "]";
	}


	
	
	
	
}
