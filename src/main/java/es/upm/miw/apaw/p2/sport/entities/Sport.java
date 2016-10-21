package es.upm.miw.apaw.p2.sport.entities;

public class Sport {
	private String name;

	public Sport(String name) {
		this.setName(name);
	}

	public String getName() {
		return this.name;
	}

	private void setName(String name) {
		this.name = name;
	}

}
