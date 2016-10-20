package es.upm.miw.apaw.p2.sport.daos;

import java.util.List;

import es.upm.miw.apaw.p2.sport.entities.Sport;

public interface SportDao extends GenericDao<Sport, String> {
	boolean isInvalidSport(String sport);

}
