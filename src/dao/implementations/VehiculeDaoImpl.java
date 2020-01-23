package dao.implementations;

import java.sql.SQLException;
import java.util.Map;

import bean.Vehicule;
import dao.DaoFactory;
import dao.interfaces.IVehiculeDao;

public class VehiculeDaoImpl implements IVehiculeDao {
	
	private DaoFactory daoFactory;
	
	public VehiculeDaoImpl (DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	

	@Override
	public Map<String, Vehicule> showAll() throws SQLException {
		return null;
	}

	@Override
	public Vehicule getVehiculeByImmatriculation(String immatriculation) throws SQLException {
		return null;
	}

	@Override
	public void insertVehicule(Vehicule v) throws SQLException {
		
	}

	@Override
	public void deleteVehicule(Vehicule v) throws SQLException {
		
	}

	@Override
	public void updateVehicule(Vehicule v) throws SQLException {
		
	}

}
