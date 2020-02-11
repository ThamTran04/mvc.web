package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Motocyclette;
import bean.User;
import bean.Vehicule;
import bean.Voiture;
import dao.DaoFactory;
import utils.AppSession;

public class VehiculeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static List<Vehicule> vehicules = new ArrayList<Vehicule>();

	public static final String CONF_DAO_FACTORY = "DaoFactoryInstance";// "DaoFactoryInstance" vient de la classe
																		// InitialisationDaoFactory

	@Override
	public void init() throws ServletException {
		((DaoFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getVehiculeDao();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = AppSession.getLoginedUser(request.getSession());
		// get User from session (saved from Login)
		String message = "Bonjour " + user.getUsername();
		String parameter = request.getParameter("variable");

		if (vehicules.isEmpty()) {
			vehicules = initiateVehiculList();
		}
		request.setAttribute("message", message);
		request.setAttribute("variable", parameter);
		request.setAttribute("vehicules", vehicules);

		this.getServletContext().getRequestDispatcher("/view JSP/vehicule.jsp").forward(request, response);
	}

	private List<Vehicule> initiateVehiculList() {
		List<Vehicule> vehicules = new ArrayList<Vehicule>();
		Vehicule v1 = new Motocyclette("Suzuki", "ATM", 600, "AT-345-YU");
		Vehicule v2 = new Motocyclette("YAMAHA", "BLP", 500, "AU-376-MT");
		Vehicule v3 = new Voiture("Renault", "Clio", 2010, "Rouge", "CR-384-SJ");
		Vehicule v4 = new Voiture("Mercedes", "E550", 2070, "Blanc", "ML-987-GH");
		vehicules.add(v1);
		vehicules.add(v3);
		vehicules.add(v2);
		vehicules.add(v4);
		return vehicules;
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String immatriculation = req.getParameter("immatriculation");
		String marque = req.getParameter("marque");
		String modele = req.getParameter("modele");
		String couleur = req.getParameter("couleur");
		String puissance = req.getParameter("puissance");
		String annee = req.getParameter("annee");
		String vehicule = req.getParameter("typeVehicule");

		if ("Voiture".equals(vehicule)) {// c'est une voiture
			Voiture v = new Voiture(marque, modele, Integer.parseInt(annee), couleur, immatriculation);
			vehicules.add(v);
		} else {
			Motocyclette m = new Motocyclette(marque, modele, Integer.parseInt(puissance), immatriculation);
			vehicules.add(m);
		}

		req.setAttribute("vehicules", vehicules);
		this.getServletContext().getRequestDispatcher("/view JSP/vehicule.jsp").forward(req, resp);
	}

}
