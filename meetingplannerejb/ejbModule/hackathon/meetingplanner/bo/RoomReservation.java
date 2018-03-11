package hackathon.meetingplanner.bo;

public class RoomReservation {
	private PlannedMeetings meeting;
	private String fromTime;
	private String toTime;
	private Room room;
	public PlannedMeetings getMeeting() {
		return meeting;
	}
	public void setMeeting(PlannedMeetings meeting) {
		this.meeting = meeting;
	}
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	public String getToTime() {
		return toTime;
	}
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
}
