package es.upm.miw.apaw.p2.sport.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.upm.miw.apaw.p2.sport.daos.UserDao;
import es.upm.miw.apaw.p2.sport.entities.Sport;
import es.upm.miw.apaw.p2.sport.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {

	public UserDaoMemory() {
		this.setMap(new HashMap<String, User>());
	}

	@Override
	public boolean isInvalidUserNick(String userNick) {
		for (User user : this.findAll())
			if (user.getNick().equals(userNick))
				return true;

		return false;
	}

	@Override
	public boolean isInvalidUserEmail(String userEmail) {
		for (User user : this.findAll())
			if (user.getEmail().equals(userEmail))
				return true;

		return false;
	}

	@Override
	public List<User> findBySport(String sportName) {
		List<User> usersBySport = new ArrayList<User>();

		for (User user : this.findAll())
			for (Sport sport : user.getSportsList())
				if (sport.getName().equals(sportName))
					usersBySport.add(user);

		return usersBySport;
	}

	@Override
	protected String getId(User entity) {
		return entity.getNick();
	}

	@Override
	public void addSport(User user, Sport sport) {
		user.addSport(sport);
		this.update(user.getNick(), user);
	}

}
