package es.upm.miw.apaw.p2.sport.api;

import es.upm.miw.apaw.p2.sport.controllers.SportController;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidSportException;

public class SportResource {

	// POST **/sports body="sportName"
	public void createSport(String sportName) throws InvalidSportException {
		this.validateSport(sportName, false);
		new SportController().createSport(sportName);
	}

	public void validateSport(String sportName, boolean sportMustExist) throws InvalidSportException {
		if ((new SportController().isInvalidSport(sportName) && !sportMustExist)
				|| (!new SportController().isInvalidSport(sportName) && sportMustExist))
			throw new InvalidSportException(sportName);
	}

}
