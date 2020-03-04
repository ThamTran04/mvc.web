package dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import bean.User;

public interface IUserDao {
	List<User> showAll() throws SQLException;

	User getUserByUserName(String username) throws SQLException;

	void insertUser(User u) throws SQLException;

	void prepareStatementForInsert(String nom, String prenom, String email, String username, String mdp)
			throws SQLException;

}
