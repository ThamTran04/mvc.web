package dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.room.gestion.RoomManagement;
import dao.DaoFactory;
import dao.interfaces.IGestionSale;

public class GestionSaleDaoImpl implements IGestionSale {
	private static final String SQL_SELECT_ALL = "select * from room_gestion";
	private static final String SQL_INSERT = "insert into room_gestion(sale, date, starting_time, finishing_time, formateur, promos) value(?, ?, ?, ?, ?, ?)";
	private static final String SQL_DELETE = "delete from room_gestion where sale=? and date=? and starting_time=?";

	public DaoFactory daoFactory;

	public GestionSaleDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<RoomManagement> roomGestion() throws SQLException {
		Connection connexion = daoFactory.getConnection();
		Statement statement = connexion.createStatement();
		ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
		List<RoomManagement> gestion = new ArrayList<RoomManagement>();
		while (resultSet.next()) {
			RoomManagement reservation = new RoomManagement(resultSet.getString("sale"), resultSet.getString("date"),
					resultSet.getInt("starting_time"), resultSet.getInt("finishing_time"),
					resultSet.getString("formateur"), resultSet.getString("promos"));
			gestion.add(reservation);
		}

		DaoUtilitaire.fermeturesSilencieuses(resultSet, statement, connexion);

		return gestion;
	}

	public void prepareStatementForInsert(String sale, String date, int startingTime, int finishingTime,
			String formateur, String promos) throws SQLException {
		Connection connexion = daoFactory.getConnection();
		PreparedStatement preStatement = connexion.prepareStatement(SQL_INSERT);
		preStatement.setString(1, sale);
		preStatement.setString(2, date);
		preStatement.setInt(3, startingTime);
		preStatement.setInt(4, finishingTime);
		preStatement.setString(5, formateur);
		preStatement.setString(6, promos);
		preStatement.executeUpdate(); // execute Query
		preStatement.close();
	}

	@Override
	public void insertRoomReservation(List<RoomManagement> roomReservation) throws SQLException {
		roomReservation.forEach(r -> {
			try {
				prepareStatementForInsert(r.getRoom(), r.getDate(), r.getStartHour(), r.getEndHour(), r.getFormateur(),
						r.getPromos());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});

	}

	public void prepareStatementForDelete(String sale, String date, int startingTime, int finishingTime,
			String formateur, String promos) throws SQLException {
		Connection connexion = daoFactory.getConnection();
		PreparedStatement preStatement = connexion.prepareStatement(SQL_DELETE);
		preStatement.setString(1, sale);
		preStatement.setString(2, date);
		preStatement.setInt(3, startingTime);
		preStatement.setInt(4, finishingTime);
		preStatement.setString(5, formateur);
		preStatement.setString(6, promos);
		preStatement.executeUpdate(); // execute Query
		preStatement.close();
	}

	@Override
	public void deleteRoomReservation(ArrayList<RoomManagement> roomAnnulation) throws SQLException {
		for (RoomManagement r : roomAnnulation) {
			prepareStatementForDelete(r.getRoom(), r.getDate(), r.getStartHour(), r.getEndHour(), r.getFormateur(),
					r.getPromos());
		}
	}

	
	public static void main(String[] args) {
		List<RoomManagement> list = new ArrayList<RoomManagement>();
		RoomManagement r1 = new RoomManagement("a", "lundi", 8, 12, "ciryl", "java");
		RoomManagement r2 = new RoomManagement("b", "mardi", 13, 14, "jemi", "dev web");
		list.add(r1);
		list.add(r2);
		DaoFactory d = DaoFactory.getInstance();

		GestionSaleDaoImpl g = new GestionSaleDaoImpl(d);
		try {
			g.insertRoomReservation(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
