package es.upm.miw.apaw.p2.sport.exceptions;

import java.util.Map;
import java.util.TreeMap;

import es.upm.miw.apaw.p2.sport.aspects.SerializeMap;

public class InvalidQueryParametersInRequestException extends Exception {
	private static final long serialVersionUID = 938579940992492252L;
	public static final String DESCRIPTION = "El nombre del parámetro introducido en la URI no es válido";

	public InvalidQueryParametersInRequestException(Map<String, String> requestParams) {
		super(DESCRIPTION + ". " + SerializeMap.getSerializeMap().mapSerialization(requestParams));
	}

	public InvalidQueryParametersInRequestException() {
		this(new TreeMap<String, String>());
	}

}
