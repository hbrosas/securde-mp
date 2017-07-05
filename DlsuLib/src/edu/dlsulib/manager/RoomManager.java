package edu.dlsulib.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.dlsulib.beans.MeetingRoom;
import edu.dlsulib.db.DBPool;

public class RoomManager {
	public static MeetingRoom GetRoom(int roomid) {
		String sql = "SELECT " + " * " + " FROM " + MeetingRoom.TABLE_NAME + " WHERE " + MeetingRoom.COLUMN_ROOMID + " LIKE "
				+ "?" + ";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomid);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				MeetingRoom meetingroom = new MeetingRoom(rs.getInt(MeetingRoom.COLUMN_RESERVEID),
								rs.getInt(MeetingRoom.COLUMN_ROOMID),
								rs.getInt(MeetingRoom.COLUMN_STATUSID),
								rs.getInt(MeetingRoom.COLUMN_ROOMTYPEID),
								rs.getString(MeetingRoom.COLUMN_STARTTIMESLOT),
								rs.getString(MeetingRoom.COLUMN_ENDTIMESLOT));
				return meetingroom;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static ArrayList<MeetingRoom> GetAllRoom() {
		String sql = "SELECT " + " * " + " FROM " + MeetingRoom.TABLE_NAME
				+ ";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				ArrayList<MeetingRoom> meetingroom = new ArrayList<>();
				meetingroom.add(new MeetingRoom(rs.getInt(MeetingRoom.COLUMN_RESERVEID),
								rs.getInt(MeetingRoom.COLUMN_ROOMID),
								rs.getInt(MeetingRoom.COLUMN_STATUSID),
								rs.getInt(MeetingRoom.COLUMN_ROOMTYPEID),
								rs.getString(MeetingRoom.COLUMN_STARTTIMESLOT),
								rs.getString(MeetingRoom.COLUMN_ENDTIMESLOT)));
				return meetingroom;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static MeetingRoom GetAllAvailableRooms() {
		String sql = "SELECT " + " * " + " FROM " + MeetingRoom.TABLE_NAME + " WHERE " + MeetingRoom.COLUMN_RESERVEID + " LIKE "
				+ "null" + ";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.set(1, null);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				MeetingRoom meetingroom = new MeetingRoom(rs.getInt(MeetingRoom.COLUMN_RESERVEID),
								rs.getInt(MeetingRoom.COLUMN_ROOMID),
								rs.getInt(MeetingRoom.COLUMN_STATUSID),
								rs.getInt(MeetingRoom.COLUMN_ROOMTYPEID),
								rs.getString(MeetingRoom.COLUMN_STARTTIMESLOT),
								rs.getString(MeetingRoom.COLUMN_ENDTIMESLOT));
				return meetingroom;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
}	
