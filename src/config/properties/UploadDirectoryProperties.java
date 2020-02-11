package config.properties;

import utils.ReadingFileProperties;

public class UploadDirectoryProperties extends ReadingFileProperties {
	private String fileName = "upload.properties";
	private String directory = "uploadDirectory";//venant du fichier "DB.config.properties" de la folder "resources"
	private static UploadDirectoryProperties instance;
	
	public static UploadDirectoryProperties getInstance () {
		if (instance==null)
			instance=new UploadDirectoryProperties();
		return instance;
	}
	
	@Override
	protected String getFileName() {
		return fileName;
	}
	
	public String getDirectoryPath() {
		return ReadingFile().getProperty(directory);
	}
	
}
