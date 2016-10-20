package es.upm.miw.apaw.p2.sport.daos.memory;

import es.upm.miw.apaw.p2.sport.daos.DaoFactory;
import es.upm.miw.apaw.p2.sport.daos.SportDao;
import es.upm.miw.apaw.p2.sport.daos.UserDao;

public class DaoFactoryMemory extends DaoFactory {
	private UserDao userDao;
	private SportDao sportDao;

	public DaoFactoryMemory() {
	}

	@Override
	public UserDao getUserDao() {
		if (userDao == null) {
			userDao = new UserDaoMemory();
		}
		return userDao;
	}

	@Override
	public SportDao getSportDao() {
		if (sportDao == null) {
			sportDao = new SportDaoMemory();
		}
		return sportDao;
	}

}
