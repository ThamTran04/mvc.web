package servlet;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 /***** Get The Absolute Path Of The Web Application *****/
        String applicationPath = this.getServletContext().getRealPath("");
        
		String filename =  request.getParameter("fileName");
		String filePath = "/image/" + filename;
		ServletContext context = getServletContext();
		String fullPath = context.getRealPath(filePath);

		Path path = Paths.get(fullPath); // On récupère le champ du fichier
		byte[] data = Files.readAllBytes(path);

		// thiet lap thong tin tra ve // définir les paramètres de la response
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment; filename=" + filename);
		response.setContentLength(data.length);
		InputStream inputSream = new BufferedInputStream(new ByteArrayInputStream(data));

		// ghi file ra response _ outputstream 
		OutputStream outStream = response.getOutputStream();
		try {
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			while ((bytesRead = inputSream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
		} finally {
			inputSream.close();
			outStream.close();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
