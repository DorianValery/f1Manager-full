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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@JsonView(Views.ViewCommon.class)
public class Joueur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Version
	private int version;
	private String pseudo;
	private int age;
	private String mail;
	private String telephone;
	@Enumerated(EnumType.STRING)
	@Column(name = "civilite", length = 5)
	private Civilite civ;
	@OneToMany(mappedBy="joueur")
	@JsonView(Views.ViewJoueurDetail.class)
	private List<Inventaire> inventaires;
	@OneToOne
	@JoinColumn(name="ecurie_id")
	@JsonView(Views.ViewJoueur.class)
	private Ecurie ecurie;
	@OneToOne (mappedBy = "joueur")
	@JsonView(Views.ViewJoueurDetail.class)
	private Compte compte;
	
	public Joueur() {}
	
	public Joueur(long id, String pseudo, int age, String mail, String telephone, Civilite civ, List<Inventaire> inventaires,
			Ecurie ecurie) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.age = age;
		this.mail = mail;
		this.telephone = telephone;
		this.civ = civ;
		this.inventaires = inventaires;
		this.ecurie = ecurie;
	}

	public Joueur(String pseudo, int age, String mail, String telephone, Civilite civ, Inventaire inventaire,
			Ecurie ecurie) {
		super();
		this.pseudo = pseudo;
		this.age = age;
		this.mail = mail;
		this.telephone = telephone;
		this.civ = civ;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Civilite getCiv() {
		return civ;
	}

	public void setCiv(Civilite civ) {
		this.civ = civ;
	}

	public List<Inventaire> getInventaires() {
		return inventaires;
	}

	public void setInventaires(List<Inventaire> inventaires) {
		this.inventaires = inventaires;
	}

	public Ecurie getEcurie() {
		return ecurie;
	}

	public void setEcurie(Ecurie ecurie) {
		this.ecurie = ecurie;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Joueur [id=" + id + ", version=" + version + ", pseudo=" + pseudo + ", age=" + age + ", mail=" + mail
				+ ", telephone=" + telephone + ", civ=" + civ + ", inventaires=" + inventaires + ", ecurie=" + ecurie
				+ ", compte=" + compte + "]";
	}



	
	
}
