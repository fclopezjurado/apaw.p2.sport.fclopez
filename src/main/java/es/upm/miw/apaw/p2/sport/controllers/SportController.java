package es.upm.miw.apaw.p2.sport.controllers;

import es.upm.miw.apaw.p2.sport.daos.DaoFactory;
import es.upm.miw.apaw.p2.sport.entities.Sport;

public class SportController {

	public void createSport(String sportName) {
		DaoFactory.getFactory().getSportDao().create(new Sport(sportName));
	}

	public boolean isInvalidSport(String sportName) {
		return DaoFactory.getFactory().getSportDao().isInvalidSport(sportName);
	}
}
