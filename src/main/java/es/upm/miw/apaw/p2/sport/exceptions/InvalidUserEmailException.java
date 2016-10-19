package es.upm.miw.apaw.p2.sport.exceptions;

public class InvalidUserEmailException extends Exception {
	private static final long serialVersionUID = 215536209172045327L;
	public static final String DESCRIPTION = "Email de usuario no válido";

	public InvalidUserEmailException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public InvalidUserEmailException() {
		this("");
	}

}
