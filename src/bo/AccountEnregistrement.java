package bo;

import java.sql.SQLException;

import bean.User;
import dao.DaoFactory;

public class AccountEnregistrement {

	public static void insertAccount(User u) throws SQLException {
		DaoFactory.getInstance().getUserDao().insertUser(u);
	}

}
