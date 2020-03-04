package dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import bean.room.gestion.RoomManagement;
import dao.DaoFactory;
import dao.interfaces.IUserDao;

public class UserDaoImpl implements IUserDao {
	private static final String SQL_SELECT_ALL = "select * from user";
	private static final String SQL_SELECT_BY_USERNAME = "select * from user where userNamse=?";
	private static final String SQL_INSERT = "insert into user(nom, prenom, email, userNamse, pwd) value(?, ?, ?, ?, ?)";

	private DaoFactory daoFactory;

	public UserDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<User> showAll() throws SQLException {
		Connection connexion = daoFactory.getConnection();
		Statement statement = connexion.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
		List<User> users = new ArrayList<User>();
		while (resultSet.next()) {
			User user = new User(resultSet.getString("nom"), resultSet.getString("prenom"),
					resultSet.getString("email"), resultSet.getString("email"), resultSet.getString("pwd"));
			// ces mots "(userNamse, email, pwd)" sont obligatoires identiques a ceux qui
			// sont nommes dans la database;
			users.add(user);
		}

		resultSet.close();
		statement.close();
		connexion.close();

		return users;
	}

	@Override
	public User getUserByUserName(String username) throws SQLException {
		Connection connexion = daoFactory.getConnection();
		PreparedStatement preStatement = connexion.prepareStatement(SQL_SELECT_BY_USERNAME);
		preStatement.setString(1, username);
		ResultSet resultSet = preStatement.executeQuery();
		User user = null;

		while (resultSet.next()) {
			user = new User(resultSet.getString("userNamse"), resultSet.getString("pwd"));
		}

//		resultSet.close();
//		preStatement.close();
//		connexion.close();

		DaoUtilitaire.fermeturesSilencieuses(resultSet, preStatement, connexion);

		return user;
	}

	@Override
	public void prepareStatementForInsert(String nom, String prenom, String email, String username, String mdp)
			throws SQLException {
		Connection connexion = daoFactory.getConnection();
		PreparedStatement preStatement = connexion.prepareStatement(SQL_INSERT);
		preStatement.setString(1, nom);
		preStatement.setString(2, prenom);
		preStatement.setString(3, email);
		preStatement.setString(4, username);
		preStatement.setString(5, mdp);
		preStatement.executeUpdate(); // execute Query
		preStatement.close();
	}

	@Override
	public void insertUser(User u) throws SQLException {
		try {
			prepareStatementForInsert(u.getNom(), u.getPrenom(), u.getEmail(), u.getUsername(), u.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
