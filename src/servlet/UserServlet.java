package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.DaoFactory;
import dao.interfaces.IUserDao;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String CONF_DAO_FACTORY = "DaoFactoryInstance";
	// "DaoFactoryInstance" vient de la classe InitialisationDaoFactory
	private IUserDao userDao = null;
	
	@Override
	public void init() throws ServletException {
		this.userDao = ((DaoFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getUserDao();
	}
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			List<User> users = null;
			try {
				users = userDao.showAll();
			} catch (SQLException e) {		
				e.printStackTrace();
			}
			req.setAttribute("users", users);
			this.getServletContext().getRequestDispatcher("/view JSP/reservation.jsp").forward(req, resp);

		}
	}
