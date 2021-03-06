package es.upm.miw.apaw.p2.sport.api;

import es.upm.miw.apaw.p2.sport.controllers.UserController;
import es.upm.miw.apaw.p2.sport.wrappers.UserListWrapper;
import es.upm.miw.apaw.p2.sport.wrappers.CompleteUserListWrapper;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidUserNickException;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidUserEmailException;
import es.upm.miw.apaw.p2.sport.exceptions.InvalidSportException;

public class UserResource {

	// GET **/users
	public CompleteUserListWrapper userList() {
		return new UserController().userList();
	}

	// POST **/users body="nick:email"
	public void createUser(String userNick, String userEmail)
			throws InvalidUserNickException, InvalidUserEmailException {
		this.validateUserNick(userNick, false);
		this.validateUserEmail(userEmail);
		new UserController().createUser(userNick, userEmail);
	}

	private void validateUserNick(String userNick, boolean userMustExist) throws InvalidUserNickException {
		if ((new UserController().isInvalidUserNick(userNick) && !userMustExist)
				|| (!new UserController().isInvalidUserNick(userNick) && userMustExist))
			throw new InvalidUserNickException(userNick);
	}

	private void validateUserEmail(String userEmail) throws InvalidUserEmailException {
		if (userEmail == null || userEmail.isEmpty()) {
			throw new InvalidUserEmailException(userEmail);
		}
	}

	// PUT **/users/{nick}/sport body="sportName"
	public void addSport(String userNick, String sportName, SportResource sportResource)
			throws InvalidUserNickException, InvalidSportException {
		this.validateUserNick(userNick, true);
		sportResource.validateSport(sportName, true);
		new UserController().addSport(userNick, sportName);
	}

	// GET **/users/search?sport=*
	public UserListWrapper searchUser(String sportName, SportResource sportResource) throws InvalidSportException {
		sportResource.validateSport(sportName, true);
		return new UserController().searchUser(sportName);
	}

}
