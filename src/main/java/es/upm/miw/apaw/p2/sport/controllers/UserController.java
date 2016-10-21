package es.upm.miw.apaw.p2.sport.controllers;

import java.util.List;

import es.upm.miw.apaw.p2.sport.daos.DaoFactory;
import es.upm.miw.apaw.p2.sport.entities.User;
import es.upm.miw.apaw.p2.sport.entities.Sport;
import es.upm.miw.apaw.p2.sport.wrappers.CompleteUserListWrapper;
import es.upm.miw.apaw.p2.sport.wrappers.UserListWrapper;
import es.upm.miw.apaw.p2.sport.wrappers.UserWrapper;

public class UserController {

	public CompleteUserListWrapper userList() {
		List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
		CompleteUserListWrapper completeUserListWrapper = new CompleteUserListWrapper();
		for (User user : userList) {
			completeUserListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
		}
		return completeUserListWrapper;
	}

	public void createUser(String userNick, String userEmail) {
		DaoFactory.getFactory().getUserDao().create(new User(userNick, userEmail));
	}

	public boolean isInvalidUserNick(String userNick) {
		return DaoFactory.getFactory().getUserDao().isInvalidUserNick(userNick);
	}

	public void addSport(String userNick, String sportName) {
		Sport sport = DaoFactory.getFactory().getSportDao().read(sportName);
		User user = DaoFactory.getFactory().getUserDao().read(userNick);
		DaoFactory.getFactory().getUserDao().addSport(user, sport);
	}

	public UserListWrapper searchUser(String sportName) {
		List<User> userList = DaoFactory.getFactory().getUserDao().findBySport(sportName);
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : userList) {
			userListWrapper.addUserListWrapper(new UserWrapper(user.getNick(), user.getEmail()));
		}
		return userListWrapper;
	}

}
