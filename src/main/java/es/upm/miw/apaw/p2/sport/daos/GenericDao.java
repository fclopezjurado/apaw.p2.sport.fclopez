package es.upm.miw.apaw.p2.sport.daos;

import java.util.List;

public interface GenericDao<T, ID> {

	void create(T entity);

	T read(ID id);

	void update(T entity);

	List<T> findAll();

}
