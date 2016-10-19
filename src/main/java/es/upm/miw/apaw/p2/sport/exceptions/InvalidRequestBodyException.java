package es.upm.miw.apaw.p2.sport.exceptions;

public class InvalidRequestBodyException extends Exception {
	private static final long serialVersionUID = 6626662996046832258L;
	public static final String DESCRIPTION = "El contenido del cuerpo de la petición no es válido";

	public InvalidRequestBodyException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public InvalidRequestBodyException() {
		this("");
	}

}
