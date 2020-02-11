package dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.jolbox.bonecp.BoneCP;

import dao.implementations.UserDaoImpl;
import dao.implementations.VehiculeDaoImpl;
import dao.interfaces.IUserDao;
import dao.interfaces.IVehiculeDao;

public class DaoFactory {
	static BoneCP connexionPool;
	static DaoFactory instance;

	DaoFactory(BoneCP connectionPool) {
		DaoFactory.connexionPool = connectionPool;
	}

	public static DaoFactory getInstance() {
		if (instance != null) {
			return instance;
		}
		connexionPool = ConnectionPool.createConnectionPool();
		instance = new DaoFactory(connexionPool);
		return instance;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = connexionPool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/*
	 * Méthodes de récupération de l'implémentation des différents DAO (un seul pour
	 * le moment)
	 */
	public IUserDao getUserDao() {
		return new UserDaoImpl(this);
	}

	public IVehiculeDao getVehiculeDao() {
		return new VehiculeDaoImpl(this);
	}

}
