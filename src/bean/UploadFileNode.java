package bean;

import java.util.ArrayList;

public class UploadFileNode  {
	 
    private long fileSize;
    private String fileName, uploadStatus;
    private ArrayList<UploadFileNode> children;
         
    public ArrayList<UploadFileNode> getChildren(){    	
    	return children;
    }
    
    public UploadFileNode(String name)  {
    	this.fileName = name;
    	this.fileSize = 0;
    	this.children = new ArrayList<UploadFileNode>();   
    }
    
    public UploadFileNode(String filename, long size) {
    	this.fileName = filename;
    	this.fileSize = size;
    	this.children = new ArrayList<UploadFileNode>();
    }
    
    public long getFileSize() {
        return fileSize;
    }
 
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
 
    public String getFileName() {
        return fileName;
    }
 
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
 
    public String getUploadStatus() {
        return uploadStatus;
    }
 
    public void setUploadStatus(String uploadStatus) {
        this.uploadStatus = uploadStatus;
    }
}