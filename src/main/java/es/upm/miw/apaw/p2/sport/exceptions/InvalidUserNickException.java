package es.upm.miw.apaw.p2.sport.exceptions;

public class InvalidUserNickException extends Exception {
	private static final long serialVersionUID = 6057360221488395360L;
	public static final String DESCRIPTION = "Nick de usuario no válido";

	public InvalidUserNickException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public InvalidUserNickException() {
		this("");
	}

}
