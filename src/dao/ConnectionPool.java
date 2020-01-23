package dao;

import java.sql.SQLException;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

import utils.FileProperties;

public class ConnectionPool {
	private final static FileProperties fileProperties = new FileProperties();
	private final static String DB_URL = fileProperties.getDBUrl();
	private final static String DB_USERNAME = fileProperties.getDBUserName();
	private final static String DB_PASSWORD = fileProperties.getDBPassword();

	
	public static BoneCP createConnectionPool() {
		// Khởi tạo config cho BoneCP
		BoneCPConfig config = new BoneCPConfig();
		config.setJdbcUrl(DB_URL);
		config.setUsername(DB_USERNAME);
		config.setPassword(DB_PASSWORD);

		/* Paramétrage de la taille du pool */
		config.setPartitionCount(2);// Số phần vùng kết nối
		config.setMinConnectionsPerPartition(5);// Tổng số kết nối nhỏ nhất trên 1 phân vùng
		config.setMaxConnectionsPerPartition(10);// Tổng số kết nối lớn nhất trên 1 phân vùng

		BoneCP DBConnexionPool=null;
		try {
			DBConnexionPool = new BoneCP(config);
		} catch (SQLException e) {
			e.printStackTrace();
		} /* Création du pool à partir de la configuration, via BoneCP */
		return DBConnexionPool;

	}

	
}
