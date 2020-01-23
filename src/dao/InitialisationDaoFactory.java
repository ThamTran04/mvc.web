package dao;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitialisationDaoFactory implements ServletContextListener {
	private DaoFactory daoFactory;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();/* avoir ServletContext quand chargement application */
		this.daoFactory = DaoFactory.getInstance(); /* Instanciation de la DAOFactory */
		context.setAttribute("DaoFactoryInstance", this.daoFactory);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		/* Rien à réaliser lors de la fermeture de l'application... */
	}

}
