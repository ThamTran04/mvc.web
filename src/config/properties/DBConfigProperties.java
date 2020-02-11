package config.properties;

import utils.ReadingFileProperties;

public class DBConfigProperties  extends ReadingFileProperties {
	private String fileName = "DB.config.properties";
	public String url = "DBurl";//venant du fichier "DB.config.properties" de la folder "resources"
	private String username = "DBusername";
	private String password = "DBpassword";
	private String driver = "DBdriver";
	private String partitionCount = "partitionCount";
	private String maxDBConnection = "maxDBConnection";
	private String minDBConnection = "minDBConnection";
		
	@Override
	protected String getFileName() {
		return fileName;
	}
	
	public String getDBUrl() {
		return ReadingFile().getProperty(url);
	}
	
	public String getDBusername() {
		return ReadingFile().getProperty(username);
	}
	
	public String getDBpassword() {
		return ReadingFile().getProperty(password);
	}
	
	public String getDBdriver() {
		return ReadingFile().getProperty(driver);
	}
	
	public String getMaxDBConnection() {
		return ReadingFile().getProperty(maxDBConnection);
	}
	
	public String getMinDBConnection() {
		return ReadingFile().getProperty(minDBConnection);
	}
	
	public String getPartitionCount() {
		return ReadingFile().getProperty(partitionCount);
	}

}
