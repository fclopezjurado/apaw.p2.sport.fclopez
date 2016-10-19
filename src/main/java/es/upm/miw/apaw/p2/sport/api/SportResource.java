package es.upm.miw.apaw.p2.sport.api;

import es.upm.miw.apaw.p2.sport.controllers.SportController;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidSportException;

public class SportResource {

	// POST **/sports body="sportName"
	public void createSport(String sportName) throws InvalidSportException {
		this.validateSport(sportName);
		new SportController().createSport(sportName);
	}

	private void validateSport(String sportName) throws InvalidSportException {
		if (SportController().isInvalidSport(sportName))
			throw new InvalidSportException(sportName);
	}

}
