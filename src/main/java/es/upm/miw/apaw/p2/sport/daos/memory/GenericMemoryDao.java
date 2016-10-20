package es.upm.miw.apaw.p2.sport.daos.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.upm.miw.apaw.p2.sport.daos.GenericDao;

public abstract class GenericMemoryDao<T> implements GenericDao<T, String> {
	private Map<String, T> map;

	protected void setMap(Map<String, T> map) {
		this.map = map;
	}

	@Override
	public void create(T entity) {
		map.put(this.getId(entity), entity);
	}

	@Override
	public T read(String id) {
		return map.get(id);
	}

	@Override
	public List<T> findAll() {
		return new ArrayList<T>(map.values());
	}

	protected abstract String getId(T entity);

}
