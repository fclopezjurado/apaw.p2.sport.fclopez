package es.upm.miw.apaw.p2.sport.wrappers;

import java.util.ArrayList;
import java.util.List;

public class CompleteUserListWrapper {
	private List<UserWrapper> completeUserList;

	public CompleteUserListWrapper() {
		this.completeUserList = new ArrayList<>();
	}

	public List<UserWrapper> getCompleteUserList() {
		return this.completeUserList;
	}

	public void addUserWrapper(UserWrapper userWrapper) {
		this.completeUserList.add(userWrapper);
	}

	@Override
	public String toString() {
		String result = "{\"completeUserList\":[ ";
		for (UserWrapper userWrapper : this.completeUserList) {
			result += userWrapper.toString() + ",";
		}
		return result.substring(0, result.length() - 1) + "]}";
	}

}
