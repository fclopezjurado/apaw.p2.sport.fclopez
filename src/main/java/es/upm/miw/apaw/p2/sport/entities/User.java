package es.upm.miw.apaw.p2.sport.entities;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String nick;
	private String email;
	private List<Sport> sportsList;

	public User(String nick, String email) {
		this.setNick(nick);
		this.setEmail(email);
		this.setSportsList();
	}

	public String getNick() {
		return this.nick;
	}

	private void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return this.email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	public List<Sport> getSportsList() {
		return this.sportsList;
	}

	private void setSportsList() {
		this.sportsList = new ArrayList<Sport>();
	}
	
	public void addSport(Sport sport) {
		this.getSportsList().add(sport);
	}

}
