package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest requete, HttpServletResponse response)
			throws ServletException, IOException {

		requete.getSession().invalidate();// AppSession.removeCookies(requete, response);
		response.sendRedirect("login");
	}

}
