package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileProperties {
	private Properties p = null;

	private Properties Load() {

		if (p != null) //test
			return p;

		ClassLoader cloader = getClass().getClassLoader();
		InputStream inStream = cloader.getResourceAsStream("config.properties");
		p = new Properties();
		try {
			p.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}

	public String getDBUrl() {
		return Load().getProperty("DBurl");
	}

	public String getDBUserName() {
		return Load().getProperty("DBusername");
	}

	public String getDBPassword() {
		return Load().getProperty("DBpassword");
	}

	public String getDBDriver() {
		return Load().getProperty("DBdriver");
	}
	
	public String getPartitionCount () {
		return Load().getProperty("partitionCount");
	}

}
