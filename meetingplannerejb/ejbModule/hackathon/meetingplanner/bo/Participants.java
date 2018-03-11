package hackathon.meetingplanner.bo;

public class Participants {
	public Requestor getParticipant() {
		return participant;
	}
	public void setParticipant(Requestor participant) {
		this.participant = participant;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public boolean isMandatory() {
		return mandatory;
	}
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}
	private Requestor participant;
	private boolean availability;
	private boolean mandatory;
}
