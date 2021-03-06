package es.upm.miw.apaw.p2.sport.daos.memory;

import java.util.HashMap;

import es.upm.miw.apaw.p2.sport.entities.Sport;
import es.upm.miw.apaw.p2.sport.daos.SportDao;

public class SportDaoMemory extends GenericMemoryDao<Sport> implements SportDao {

	public SportDaoMemory() {
		this.setMap(new HashMap<String, Sport>());
	}

	@Override
	protected String getId(Sport entity) {
		return entity.getName();
	}

	@Override
	public boolean isInvalidSport(String sportName) {
		for (Sport sport : this.findAll())
			if (sport.getName().equals(sportName))
				return true;

		return false;
	}

}
