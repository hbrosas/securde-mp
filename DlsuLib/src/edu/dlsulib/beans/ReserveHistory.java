package edu.dlsulib.beans;

import java.io.Serializable;

public class ReserveHistory implements Serializable {
	public static final String TABLE_NAME = "reservehistory";
	public static final String COLUMN_RESERVEID = "reserveId";
	public static final String COLUMN_ROOMID = "roomId";
	public static final String COLUMN_ACCOUNTID = "accountId";
	public static final String COLUMN_DATERESERVED = "dateReserved";
	
	public ReserveHistory() {
		
	}
	
	public ReserveHistory(int reserveId, int roomId, int accountId, String dateReserved) {
		super();
		this.reserveId = reserveId;
		this.roomId = roomId;
		this.accountId = accountId;
		this.dateReserved = dateReserved;
	}
	private int reserveId, roomId, accountId;
	private String dateReserved;
	
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
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getDateReserved() {
		return dateReserved;
	}
	public void setDateReserved(String dateReserved) {
		this.dateReserved = dateReserved;
	}
	
}
