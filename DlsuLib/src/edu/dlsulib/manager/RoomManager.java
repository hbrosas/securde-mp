package edu.dlsulib.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.dlsulib.beans.UserAccount;
import edu.dlsulib.db.DBPool;

public class RoomManager {
	public static int GetRoom() {
		String sql = "SELECT " + " * " + " FROM " + UserAccount.TABLE_NAME + " WHERE " + UserAccount.COLUMN_USERNAME + " LIKE "
				+ value + " OR " + UserAccount.COLUMN_EMAILADDRESS + " LIKE " + value + " AND " + UserAccount.COLUMN_PASSWORD
				 + password + ";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int roomid = 0;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				Accountid = rs.getInt(UserAccount.COLUMN_ACCOUNTID);
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
		
		return roomid;
		
		
	}
}	
