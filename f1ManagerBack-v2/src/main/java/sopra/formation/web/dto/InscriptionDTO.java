package sopra.formation.web.dto;

import sopra.formation.model.Civilite;

public class InscriptionDTO {

	private String login;

	private String password;

	private String mail;

	private int age;

	private Civilite civilite;

	public InscriptionDTO() {

	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getMail() {
		return mail;
	}

	public int getAge() {
		return age;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

}
