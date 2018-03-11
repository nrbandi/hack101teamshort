package hackathon.meetingplanner.bl;

import hackathon.meetingplanner.bo.PlannedMeetings;
import hackathon.meetingplanner.bo.Requestor;
import hackathon.meetingplanner.bo.Room;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import colruyt.hackathon.EmployeeNotAvailableException;

@Stateless
@LocalBean
public class EmployeeService {
	/**
	 * 
	 */
	private List<PlannedMeetings> plannedMeetings = new ArrayList<PlannedMeetings>();

	public EmployeeService() {

	}

	public void setMeetings() throws ParseException {

		PlannedMeetings object = null;
		Requestor requestor = null;
		Room room = null;
		Date fromDate = null;
		Date toDate = null;
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		String toDateString = null;
		String dateString = null;
		for (int i = 0; i < 10; i++) {
			int j = i;
			object = new PlannedMeetings();
			requestor = new Requestor();
			room = new Room();
			dateString = (++j) + "/03/2018 " + (j + 2) + ":" + "00";
			toDateString = (j) + "/03/2018 " + (j + 3) + ":" + "00";
			fromDate = sdf.parse(dateString);
			toDate = sdf.parse(toDateString);
			room.setRoomId(i + 5);
			requestor.setEmpId(i + 100);
			object.setFromTime(fromDate);
			object.setToTime(toDate);
			if (i < 5) {
				object.setRequestor(requestor);
			}
			object.setRoom(room);
			plannedMeetings.add(object);
		}

	}

	public List<Requestor> getEmployees() {
		List<Requestor> employees = new ArrayList<Requestor>();
		Requestor requestor = null;
		for (int i = 0; i < 10; i++) {
			requestor = new Requestor();
			requestor.setEmpId(i + 100);
			requestor.setName("Colruyt" + i + i);
			employees.add(requestor);
		}
		return employees;
	}

	public List<PlannedMeetings> getPlannedMeetings() {
		return plannedMeetings;
	}

	public void setPlannedMeetings(List<PlannedMeetings> plannedMeetings) {
		this.plannedMeetings = plannedMeetings;
	}

	public boolean isEmployeeAvailable(int empId, Date fromDate, Date toDate)
			throws EmployeeNotAvailableException, ParseException {
		setMeetings();
		for (int i = 0; i < plannedMeetings.size(); i++) {
			if (plannedMeetings.get(i).getRequestor() != null) {
				if (empId == plannedMeetings.get(i).getRequestor().getEmpId()) {
					if (fromDate.toString().equals(
							plannedMeetings.get(i).getFromTime().toString())) {
						throw new EmployeeNotAvailableException();
					}
					// return false;
				}
			}
		}
		return true;
	}
}
