package dao.interfaces;

import java.sql.SQLException;
import java.util.Map;
import bean.Vehicule;

public interface IVehiculeDao {
	Map<String, Vehicule> showAll () throws SQLException;
	Vehicule getVehiculeByImmatriculation (String immatriculation) throws SQLException;
	void insertVehicule (Vehicule v) throws SQLException;
	void deleteVehicule (Vehicule v) throws SQLException;
	void updateVehicule (Vehicule v) throws SQLException;
}
