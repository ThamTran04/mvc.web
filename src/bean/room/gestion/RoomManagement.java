package bean.room.gestion;

public class RoomManagement {
	private String room;
	private String date;
	private int startingTime;
	private int finishingTime;
	private String formateur;
	private String promos;

	public RoomManagement(String date, int startingTime, int finishingTime) {
		this.date = date;
		this.startingTime = startingTime;
		this.finishingTime = finishingTime;
	}

	public RoomManagement(String sale, String date, int startingTime, int finishingTime, String formateur,
			String promos) {
		this.room = sale;
		this.date = date;
		this.startingTime = startingTime;
		this.finishingTime = finishingTime;
		this.formateur = formateur;
		this.promos = promos;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getStartHour() {
		return startingTime;
	}

	public void setStartHour(int startHour) {
		this.startingTime = startHour;
	}

	public int getEndHour() {
		return finishingTime;
	}

	public void setEndHour(int endHour) {
		this.finishingTime = endHour;
	}

	public String getFormateur() {
		return formateur;
	}

	public void setFormateur(String formateur) {
		this.formateur = formateur;
	}

	public String getPromos() {
		return promos;
	}

	public void setPromos(String promos) {
		this.promos = promos;
	}

}
