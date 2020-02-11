package servlet;


import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UploadFileNode;

import config.properties.UploadDirectoryProperties;


@WebServlet("/files")
public class FilesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String uploadDir = UploadDirectoryProperties.getInstance().getDirectoryPath();
		 File rootUploadDirectory = new File(uploadDir);	     	 
		 UploadFileNode root = new UploadFileNode("Upload files");
		BuildFolder(rootUploadDirectory, root);   			
	        
		request.setAttribute("node",root);
		this.getServletContext().getRequestDispatcher("/view JSP/files.jsp").forward(request, response);
	}
	
	private void BuildFolder(File folder, UploadFileNode node) {
		
        File[] allFiles = folder.listFiles();      
		for (File file : allFiles) {	        	
	        UploadFileNode child = new UploadFileNode(file.getName(), file.length() / 1024);	            
	        node.getChildren().add(child);	        
	        
	        if(file.isDirectory()) {
	        		BuildFolder(file,  child);
	        }
		}		
	}
}
