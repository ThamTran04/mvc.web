package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import bo.AccountEnregistrement;

public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/view JSP/inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest requete, HttpServletResponse response) throws IOException {
		String nom = requete.getParameter("surname");
		String prenom = requete.getParameter("name");
		String utilisateur = requete.getParameter("utilisateur");
		String email = requete.getParameter("email");
		String mdp = requete.getParameter("password");
		User user = new User(nom, prenom, utilisateur, email, mdp);
		
		try {
			AccountEnregistrement.insertAccount(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		response.sendRedirect("wellcome");
		
		requete.setAttribute("nom", nom);
		try {
			this.getServletContext().getRequestDispatcher("/view JSP/wellcome.jsp").forward(requete, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
