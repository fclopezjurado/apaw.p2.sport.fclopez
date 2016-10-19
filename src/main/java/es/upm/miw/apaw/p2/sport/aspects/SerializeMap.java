package es.upm.miw.apaw.p2.sport.aspects;

import java.util.Map;

public class SerializeMap {
	private static SerializeMap serializeMap = null;

	private SerializeMap() {
	}

	public String mapSerialization(Map<String, String> map) {
		String serializedMap = new String("{");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (serializedMap.length() > 1)
				serializedMap += ", ";
			serializedMap += "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"";
		}

		return serializedMap + "}";
	}

	public static SerializeMap getSerializeMap() {
		SerializeMap.serializeMap = new SerializeMap();
		return SerializeMap.serializeMap;
	}

}
