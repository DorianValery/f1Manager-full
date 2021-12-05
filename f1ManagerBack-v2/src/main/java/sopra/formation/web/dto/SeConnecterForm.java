package sopra.formation.web.dto;

public class SeConnecterForm {

	private String login;
	private String password;
	
public SeConnecterForm() {
		
	}
	
public SeConnecterForm(String login, String password) {
		this.login=login;
		this.password=password;
	}

public String getLogin() {
	return login;
}

public String getPassword() {
	return password;
}

public void setLogin(String login) {
	this.login = login;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "SeConnecterForm [login=" + login + ", password=" + password + "]";
}

}
