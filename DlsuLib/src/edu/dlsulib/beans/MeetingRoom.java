package edu.dlsulib.beans;

import java.io.Serializable;

public class MeetingRoom implements Serializable {
	public static final String TABLE_NAME = "meetingroom";
	public static final String COLUMN_RESERVEID = "reserveId";
	public static final String COLUMN_ROOMID = "roomId";
	public static final String COLUMN_STATUSID = "statusId";
	public static final String COLUMN_ROOMTYPEID = "roomTypeId";
	public static final String COLUMN_STARTTIMESLOT = "startTimeslot";
	public static final String COLUMN_ENDTIMESLOT = "endTimeslot";
	
	private int reserveId, roomId, statusId, roomTypeId;
	private String startTimeslot, endTimeslot;
	
	public int getReserveId() {
		return reserveId;
	}
	public void setReserveId(int reserveId) {
		this.reserveId = reserveId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public String getStartTimeslot() {
		return startTimeslot;
	}
	public void setStartTimeslot(String startTimeslot) {
		this.startTimeslot = startTimeslot;
	}
	public String getEndTimeslot() {
		return endTimeslot;
	}
	public void setEndTimeslot(String endTimeslot) {
		this.endTimeslot = endTimeslot;
	}

}
