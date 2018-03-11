package colruyt.meetingplanner.backing;

import hackathon.meetingplanner.bl.EmployeeService;
import hackathon.meetingplanner.bl.RoomService;
import hackathon.meetingplanner.bo.Requestor;
import hackathon.meetingplanner.bo.Room;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import colruyt.hackathon.EmployeeNotAvailableException;
import colruyt.hackathon.RoomNotAvailableException;

@ManagedBean
@RequestScoped
public class MeetingPlannerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String meetingTitle;
	private String requestor;
	private String dateFrom;
	private String dateTo;
	private Boolean confidentialOrNot;
	private List<Requestor> participants;
	private List<Room> allRooms;
	private List<Integer> selectedParticipants;
	private String dateFromTime;
	private String dateToTime;

	public List<Requestor> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Requestor> participants) {
		this.participants = participants;
	}

	public List<Room> getAllRooms() {
		return allRooms;
	}

	public void setAllRooms(List<Room> allRooms) {
		this.allRooms = allRooms;
	}

	public List<Integer> getSelectedParticipants() {
		return selectedParticipants;
	}

	public void setSelectedParticipants(List<Integer> selectedParticipants) {
		this.selectedParticipants = selectedParticipants;
	}

	@EJB
	private EmployeeService empService;
	@EJB
	private RoomService roomService;

	@PostConstruct
	public void init() {
		participants = empService.getEmployees();
		allRooms = roomService.getRooms();
		requestor = "Mahender";
	}

	public void saveMeeting() throws ParseException {
		Date fromDate = null;
		Date toDate = null;
		int count = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		fromDate = sdf.parse(dateFrom + " " + dateFromTime);
		toDate = sdf.parse(dateTo + " " + dateToTime);
		for (Integer r : selectedParticipants) {
			try {
				if (empService.isEmployeeAvailable(r, fromDate, toDate)) {
					count = 0;
				} else {
					count = 1;
					break;
				}
			} catch (EmployeeNotAvailableException e) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage("meetingPlannerForm:participantsID",
						new FacesMessage("Error : Participants Not available"));
				return;
			}
		}

		for (Room room : allRooms) {
			try {
				if (roomService.isRoomAvailable(room.getRoomId(), fromDate,
						toDate)) {
					count = 0;
				} else {
					count = 1;
					break;
				}
			} catch (RoomNotAvailableException e) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage("meetingPlannerForm:participantsID",
						new FacesMessage("Error : Rooms Not available"));
				return;
			}
		}

		if (count == 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("meetingPlannerForm:participantsID",
					new FacesMessage("Meeting booked successfully"));
			return;
		} else {
			System.out.println("Choose other time");
		}
	}

	public void cancel() {
		this.meetingTitle = "";
		this.dateFrom = "";
		this.dateFromTime = "";
		this.dateTo = "";
		this.dateToTime = "";
		this.selectedParticipants.clear();
	}

	public String getMeetingTitle() {
		return meetingTitle;
	}

	public void setMeetingTitle(String meetingTitle) {
		this.meetingTitle = meetingTitle;
	}

	public String getRequestor() {
		return requestor;
	}

	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public Boolean getConfidentialOrNot() {
		return confidentialOrNot;
	}

	public void setConfidentialOrNot(Boolean confidentialOrNot) {
		this.confidentialOrNot = confidentialOrNot;
	}

	public String getDateFromTime() {
		return dateFromTime;
	}

	public void setDateFromTime(String dateFromTime) {
		this.dateFromTime = dateFromTime;
	}

	public String getDateToTime() {
		return dateToTime;
	}

	public void setDateToTime(String dateToTime) {
		this.dateToTime = dateToTime;
	}

}
