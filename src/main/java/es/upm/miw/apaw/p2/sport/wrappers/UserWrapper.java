package es.upm.miw.apaw.p2.sport.wrappers;

public class UserWrapper {
	private String userNick;
	private String userEmail;

	public UserWrapper() {
	}

	public UserWrapper(String userNick, String userEmail) {
		this.setUserNick(userNick);
		this.setUserEmail(userEmail);
	}

	public String getUserNick() {
		return this.userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "{\"userNick\":" + this.userNick + ",\"userEmail\":\"" + this.userEmail + "\"}";
	}

}
