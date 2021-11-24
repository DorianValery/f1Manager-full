package sopra.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@JsonView(Views.ViewCommon.class)
public class Joueur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String pseudo;
	private int age;
	private String mail;
	private String telephone;
	@Enumerated(EnumType.STRING)
	@Column(name = "civilite", length = 5)
	private Civilite civ;
	@OneToOne
	@JoinColumn(name="inventaire_id")
	private Inventaire inventaire;
	@OneToOne
	@JoinColumn(name="ecurie_id")
	private Ecurie ecurie;
	@OneToOne (mappedBy = "joueur")
	private Compte compte;
	
	public Joueur() {}
	
	public Joueur(long id, String pseudo, int age, String mail, String telephone, Civilite civ, Inventaire inventaire,
			Ecurie ecurie) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.age = age;
		this.mail = mail;
		this.telephone = telephone;
		this.civ = civ;
		this.inventaire = inventaire;
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

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}

	public Ecurie getEcurie() {
		return ecurie;
	}

	public void setEcurie(Ecurie ecurie) {
		this.ecurie = ecurie;
	}

	@Override
	public String toString() {
		return "Joueur [id=" + id + ", pseudo=" + pseudo + ", age=" + age + ", mail=" + mail + ", telephone="
				+ telephone + ", civ=" + civ + ", inventaire=" + inventaire + ", ecurie=" + ecurie + "]";
	}
	
	
	
}
