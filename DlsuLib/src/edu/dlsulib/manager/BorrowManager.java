package edu.dlsulib.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.dlsulib.beans.BorrowHistory;
import edu.dlsulib.db.DBPool;

public class BorrowManager {
	public static int Borrow(BorrowHistory brwhistory) {
		String sql = "INSERT INTO " + BorrowHistory.TABLE_NAME + " ( " + BorrowHistory.COLUMN_CATALOGID + ", " 
																	   + BorrowHistory.COLUMN_STATUSID + ", "
																	   + BorrowHistory.COLUMN_ACCOUNTID + ", "
																	   + BorrowHistory.COLUMN_DATEBORROWED + ", "
																	   + BorrowHistory.COLUMN_DATEEXPECTRETURN + ", "
																	   + BorrowHistory.COLUMN_DATERETURN 
																	   + " ) VALUES (?, ?, ?, ?, ?, ?);";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int borrowid = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, brwhistory.getCatalogId());
			pstmt.setInt(2, brwhistory.getStatusId());
			pstmt.setInt(3, brwhistory.getAccountId());
			pstmt.setString(4, brwhistory.getDateReturn());
			pstmt.setString(5, brwhistory.getDateExpectReturn());
			pstmt.setString(6, brwhistory.getDateReturn());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				borrowid = rs.getInt(BorrowHistory.COLUMN_BORROWID);
			}
			
			return borrowid;
			
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
		return -1;
	}
	
	
}
