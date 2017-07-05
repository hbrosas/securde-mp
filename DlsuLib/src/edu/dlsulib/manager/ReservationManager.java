package edu.dlsulib.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.dlsulib.beans.MeetingRoom;
import edu.dlsulib.beans.ReserveHistory;
import edu.dlsulib.db.DBPool;

public class ReservationManager {
	public static ReserveHistory Reserve(ReserveHistory rsvhistory) {
		String sql = "INSERT INTO " + ReserveHistory.TABLE_NAME + " ( "
			    + ReserveHistory.COLUMN_ROOMID
				+ ", " + ReserveHistory.COLUMN_ACCOUNTID + ", " + ReserveHistory.COLUMN_DATERESERVED
				+ " ) " + " VALUES(?,?,?);";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReserveHistory reservehistory = new ReserveHistory();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rsvhistory.getRoomId());
			pstmt.setInt(2, rsvhistory.getAccountId());
			pstmt.setString(3, rsvhistory.getDateReserved());
			rs = pstmt.executeQuery();
			
			reservehistory.setRoomId(rs.getInt(ReserveHistory.COLUMN_ROOMID));
			reservehistory.setAccountId(rs.getInt(ReserveHistory.COLUMN_ACCOUNTID));	
			reservehistory.setDateReserved(rs.getString(ReserveHistory.COLUMN_DATERESERVED));
			
			return reservehistory;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static void EditReserve(ReserveHistory rsvhistory) {
		String sql = "UPDATE " + ReserveHistory.TABLE_NAME + " ( "
			    + ReserveHistory.COLUMN_ROOMID
				+ ", " + ReserveHistory.COLUMN_ACCOUNTID + ", " + ReserveHistory.COLUMN_DATERESERVED
				+ " ) " + " VALUES(?,?,?);";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReserveHistory reservehistory = new ReserveHistory();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rsvhistory.getRoomId());
			pstmt.setInt(2, rsvhistory.getAccountId());
			pstmt.setString(3, rsvhistory.getDateReserved());
			rs = pstmt.executeQuery();
			
			reservehistory.setRoomId(rs.getInt(ReserveHistory.COLUMN_ROOMID));
			reservehistory.setAccountId(rs.getInt(ReserveHistory.COLUMN_ACCOUNTID));	
			reservehistory.setDateReserved(rs.getString(ReserveHistory.COLUMN_DATERESERVED));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static ReserveHistory GetReservation(ReserveHistory rsvhistory) {
		String sql = "SELECT " + ReserveHistory.TABLE_NAME + " WHERE "
			    + ReserveHistory.COLUMN_ROOMID + " LIKE ?"
				+ " AND " + ReserveHistory.COLUMN_ACCOUNTID + " LIKE ? " + " AND " + ReserveHistory.COLUMN_DATERESERVED
				+ " LIKE ?;";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReserveHistory reservehistory = new ReserveHistory();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rsvhistory.getRoomId());
			pstmt.setInt(2, rsvhistory.getAccountId());
			pstmt.setString(3, rsvhistory.getDateReserved());
			rs = pstmt.executeQuery();
			
			reservehistory.setRoomId(rs.getInt(ReserveHistory.COLUMN_ROOMID));
			reservehistory.setAccountId(rs.getInt(ReserveHistory.COLUMN_ACCOUNTID));	
			reservehistory.setDateReserved(rs.getString(ReserveHistory.COLUMN_DATERESERVED));
			
			return reservehistory;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static ArrayList<ReserveHistory> GetAllReservation(ReserveHistory rsvhistory) {
		String sql = "SELECT " + ReserveHistory.TABLE_NAME + " WHERE "
			    + ReserveHistory.COLUMN_ROOMID + " LIKE ?"
				+ " AND " + ReserveHistory.COLUMN_ACCOUNTID + " LIKE ? " + " AND " + ReserveHistory.COLUMN_DATERESERVED
				+ " LIKE ?;";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ReserveHistory> reservehistory = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rsvhistory.getRoomId());
			pstmt.setInt(2, rsvhistory.getAccountId());
			pstmt.setString(3, rsvhistory.getDateReserved());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			reservehistory.add(new ReserveHistory(rs.getInt(ReserveHistory.COLUMN_RESERVEID),
												  rs.getInt(ReserveHistory.COLUMN_ROOMID),
												  rs.getInt(ReserveHistory.COLUMN_ACCOUNTID),
												  rs.getString(ReserveHistory.COLUMN_DATERESERVED)));
			}
			
			return reservehistory;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}	
	
	public static boolean isReserved(int roomid) {
		String sql = "SELECT " + MeetingRoom.TABLE_NAME + " WHERE "
			    + ReserveHistory.COLUMN_ROOMID + " LIKE ?"
				+ " AND " + " AND " + MeetingRoom.COLUMN_STATUSID + " LIKE ?;";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roomid);
			pstmt.setInt(2, 2);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
}
