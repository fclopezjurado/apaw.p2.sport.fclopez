package es.upm.miw.apaw.p2.sport.daos;

import java.util.List;

import es.upm.miw.apaw.p2.sport.entities.Sport;
import es.upm.miw.apaw.p2.sport.entities.User;

public interface UserDao extends GenericDao<User, String> {
	boolean isInvalidUserNick(String userNick);

	boolean isInvalidUserEmail(String userEmail);

	List<User> findBySport(String sportName);
	
	void addSport(User user, Sport sport);

}
