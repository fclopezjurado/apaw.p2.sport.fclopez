package es.upm.miw.apaw.p2.sport.exceptions;

public class InvalidSportException extends Exception {
	private static final long serialVersionUID = 6150732997782365376L;
	public static final String DESCRIPTION = "Deporte no válido";

	public InvalidSportException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public InvalidSportException() {
		this("");
	}

}
