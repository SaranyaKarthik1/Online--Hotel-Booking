package Assignments;

public class HotelRoom {
	private String roomnumber = null;
	private boolean roombooked = false;

	public HotelRoom(String string) {
		// TODO Auto-generated constructor stub
	}

	public String getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}

	public boolean isRoombooked() {
		return roombooked;
	}

	public void setRoombooked(boolean roombooked) {
		this.roombooked = roombooked;
	}

	void cancel() {
		roombooked = false;
	}

	public static void add(String[] roomnumber2) {
		// TODO Auto-generated method stub
		
	}

}
