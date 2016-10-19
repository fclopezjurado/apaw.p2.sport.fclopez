package es.upm.miw.apaw.p2.sport.exceptions;

import java.util.Map;
import java.util.TreeMap;

public class InvalidQueryParametersInRequestException extends Exception {
	private static final long serialVersionUID = 938579940992492252L;
	public static final String DESCRIPTION = "El nombre del parámetro introducido en la URI no es válido";

	public InvalidQueryParametersInRequestException(Map<String, String> requestParams) {
		super(DESCRIPTION + ". " + InvalidQueryParametersInRequestException.serializeRequestParameters(requestParams));
	}

	private static String serializeRequestParameters(Map<String, String> requestParams) {
		String serializedRequestParameters = new String("{");
		for (Map.Entry<String, String> entry : requestParams.entrySet()) {
			if (serializedRequestParameters.length() > 1)
				serializedRequestParameters += ", \"";

			serializedRequestParameters += entry.getKey() + "\": \"" + entry.getValue() + "\"";
		}

		return serializedRequestParameters + "}";
	}

	public InvalidQueryParametersInRequestException() {
		this(new TreeMap<String, String>());
	}

}
