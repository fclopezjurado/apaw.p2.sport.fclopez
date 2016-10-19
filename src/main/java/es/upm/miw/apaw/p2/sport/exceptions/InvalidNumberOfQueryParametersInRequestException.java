package es.upm.miw.apaw.p2.sport.exceptions;

import java.util.Map;
import java.util.TreeMap;

import es.upm.miw.apaw.p2.sport.aspects.SerializeMap;

public class InvalidNumberOfQueryParametersInRequestException extends Exception {
	private static final long serialVersionUID = 4592558312490047637L;
	public static final String DESCRIPTION = "El número de parámetros introducidos en la URI no es válido";

	public InvalidNumberOfQueryParametersInRequestException(Map<String, String> requestParams) {
		super(DESCRIPTION + ". " + SerializeMap.getSerializeMap().mapSerialization(requestParams));
	}

	public InvalidNumberOfQueryParametersInRequestException() {
		this(new TreeMap<String, String>());
	}

}
