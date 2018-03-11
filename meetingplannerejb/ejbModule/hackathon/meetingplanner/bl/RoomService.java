package hackathon.meetingplanner.bl;

import hackathon.meetingplanner.bo.Room;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import colruyt.hackathon.RoomNotAvailableException;

@Stateless
@LocalBean
public class RoomService {
	@EJB
	private EmployeeService service;

	public RoomService() {

	}

	public List<Room> getRooms() {
		List<Room> rooms = new ArrayList<Room>();
		Room room = null;
		for (int i = 0; i < 5; i++) {
			room = new Room();
			room.setRoomId(i + 5);
			room.setLocation("HYDE");
			rooms.add(room);
		}
		return rooms;
	}

	public boolean isRoomAvailable(int roomId, Date fromDate, Date toDate)
			throws RoomNotAvailableException {
		for (int i = 0; i < 9; i++) {
			if (roomId == service.getPlannedMeetings().get(i).getRoom()
					.getRoomId()) {
				if (fromDate.toString().equals(
						service.getPlannedMeetings().get(i).getFromTime()
								.toString())) {
					throw new RoomNotAvailableException();
				}
				// return false;
			}
		}
		return true;
	}
}
