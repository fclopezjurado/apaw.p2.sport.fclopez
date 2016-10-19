package es.upm.miw.apaw.p2.sport.exceptions;

import java.util.Map;

public abstract class InvalidRequestParametersException extends Exception {
	private static final long serialVersionUID = 5108732763094740027L;

	protected String serializeRequestParameters(Map<String, String> requestParams) {
		String serializedRequestParameters = new String("{");
		for (Map.Entry<String, String> entry : requestParams.entrySet()) {
			if (serializedRequestParameters.length() > 1)
				serializedRequestParameters += ", \"";

			serializedRequestParameters += entry.getKey() + "\": \"" + entry.getValue() + "\"";
		}

		return serializedRequestParameters + "}";
	}
}
