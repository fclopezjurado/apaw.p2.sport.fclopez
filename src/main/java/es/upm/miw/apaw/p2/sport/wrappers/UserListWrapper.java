package es.upm.miw.apaw.p2.sport.wrappers;

import java.util.ArrayList;
import java.util.List;

public class UserListWrapper {
	private List<String> userList;

	public UserListWrapper() {
		this.userList = new ArrayList<>();
	}

	public List<String> getUserListWrapper() {
		return this.userList;
	}

	public void addUserListWrapper(UserWrapper userWrapper) {
		this.userList.add(userWrapper.getUserNick());
	}

	@Override
	public String toString() {
		String result = "{\"userList\":[ ";
		for (String userNick : userList) {
			result += userNick + ",";
		}
		return result.substring(0, result.length() - 1) + "]}";
	}

}
