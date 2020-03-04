package dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.room.gestion.RoomManagement;

public interface IGestionSale {
	List<RoomManagement> roomGestion () throws SQLException;
	void insertRoomReservation (List<RoomManagement> roomReservation) throws SQLException;
	void deleteRoomReservation (ArrayList<RoomManagement> roomAnnulation) throws SQLException;

}
