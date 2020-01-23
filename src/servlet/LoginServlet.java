package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import bo.LoginVerification;
import utils.AppSession;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest requete, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/view JSP/login.jsp").forward(requete, response);
	}

	@Override
	protected void doPost(HttpServletRequest requete, HttpServletResponse response) throws IOException {

		String username = requete.getParameter("username"); // ce mot "username" se trouve dans le fichier login.jsp
		String pwd = requete.getParameter("password");
		User user = new User(username, pwd);
		boolean checkUser = false;
		boolean checkAd = false;

		try {
			checkUser = LoginVerification.checkUser(user);
			checkAd = LoginVerification.checkAdminUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (checkUser) {
			HttpSession session = requete.getSession();
			AppSession.storeLoginedUser(session, user);
			AppSession.setCookieUser(response, username, pwd);
			if (checkAd) {
				response.sendRedirect("admin");
			} else {
				response.sendRedirect("vehicule");
			}
		} else {
			response.sendRedirect("login?err=1"); // cas de déchec de login: revenir à la page Login
		}

	}

}
