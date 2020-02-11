package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class ReadingFileProperties {
	private Properties p = null;
	
	protected abstract  String getFileName( );
	
	protected Properties ReadingFile () {
		if (p != null)
			return p;

		ClassLoader cloader = getClass().getClassLoader();
		InputStream inStream = cloader.getResourceAsStream(getFileName());
		p = new Properties();
		try {
			p.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}

}
