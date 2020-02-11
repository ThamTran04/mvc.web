package dao;

import java.sql.SQLException;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

import config.properties.DBConfigProperties;

public class ConnectionPool {
	private final static DBConfigProperties DBProperties = new DBConfigProperties();
	private final static String DB_URL = DBProperties.getDBUrl();
	private final static String DB_USERNAME = DBProperties.getDBusername();
	private final static String DB_PASSWORD = DBProperties.getDBpassword();
	private final static String DB_DRIVER = DBProperties.getDBdriver();

	
	public static BoneCP createConnectionPool() {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		BoneCPConfig config = new BoneCPConfig();// Khởi tạo config cho BoneCP
		config.setJdbcUrl(DB_URL);
		config.setUsername(DB_USERNAME);
		config.setPassword(DB_PASSWORD);
//		config.setIdleConnectionTestPeriodInMinutes(1);
//		config.setConnectionTestStatement("SELECT 1");

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
