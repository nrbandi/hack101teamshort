package hackathon.meetingplanner.bo;

import java.io.Serializable;

public class Room implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int roomId;
	private String location;
	private int noOfSeats;
	private boolean vc;
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public boolean isVc() {
		return vc;
	}
	public void setVc(boolean vc) {
		this.vc = vc;
	}
}
