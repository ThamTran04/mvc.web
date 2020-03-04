package bo;

import java.sql.SQLException;

import bean.User;
import dao.DaoFactory;

/*
 * tiep nhan thong tin usernamme va mdp tu servlet. co tuong tac voi DB và xu li logic truoc khi gui tra lai phan hoi cho controller
 */

public class LoginVerification {
	
	public static User getUser(String username) throws SQLException {
		User u = DaoFactory.getInstance().getUserDao().getUserByUserName(username);
		return u;
	}

	public static boolean checkAdminUser(User user) throws SQLException {
		if (user == null)
			return false;

		User userFromDB = getUser("admin");
		boolean checkAd = userFromDB != null && userFromDB.equals(user);
		return checkAd;
	}

	public static boolean checkUser(User user) throws SQLException {
		if (user == null)
			return false;

		User userFromDB = getUser(user.getUsername());
		boolean checkUser = user.equals(userFromDB); // trong equals da check si "userFromDB" is null hay k roi.
		return checkUser;
	}

	public static boolean checkAccount(User user) throws SQLException {
		if (user == null)
			return false;

		User userFromDB = getUser(user.getUsername());
		boolean checkAccount = user.getUsername().equals(userFromDB.getUsername());
		return checkAccount;
	}

}
