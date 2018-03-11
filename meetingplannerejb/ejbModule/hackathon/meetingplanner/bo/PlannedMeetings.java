package hackathon.meetingplanner.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PlannedMeetings implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int meetingId;
	private Date fromTime;
	private Date toTime;
	private Requestor requestor;
	private boolean confidential;
	private Room room;
	private int priority;
	private List<Participants> participants;

	public int getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	public Date getFromTime() {
		return fromTime;
	}

	public void setFromTime(Date fromTime) {
		this.fromTime = fromTime;
	}

	public Date getToTime() {
		return toTime;
	}

	public void setToTime(Date toTime) {
		this.toTime = toTime;
	}

	public List<Participants> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participants> participants) {
		this.participants = participants;
	}

	public Requestor getRequestor() {
		return requestor;
	}

	public void setRequestor(Requestor requestor) {
		this.requestor = requestor;
	}

	public boolean isConfidential() {
		return confidential;
	}

	public void setConfidential(boolean confidential) {
		this.confidential = confidential;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
}
