package sopra.formation.model;

public enum typeInfra {
	P("Pilote"), V("Voiture"), M("Marketing");

	private final String label;

	private typeInfra(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}