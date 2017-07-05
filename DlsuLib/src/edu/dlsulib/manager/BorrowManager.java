package edu.dlsulib.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.dlsulib.beans.BorrowHistory;
import edu.dlsulib.db.DBPool;

public class BorrowManager {
	public static int Borrow(BorrowHistory brwhistory) {
		String sql = "INSERT INTO " + BorrowHistory.TABLE_NAME 
				+ " (" + BorrowHistory.COLUMN_CATALOGID + ", " 
			   + BorrowHistory.COLUMN_STATUSID + ", "
			   + BorrowHistory.COLUMN_ACCOUNTID + ", "
			   + BorrowHistory.COLUMN_DATEBORROWED + ", "
			   + BorrowHistory.COLUMN_DATEEXPECTRETURN
			   + ") VALUES (?, ?, ?, ?, ?);";

		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int accountID = 0;
		try {
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			rs = pstmt.getGeneratedKeys();
			pstmt.setInt(1, brwhistory.getCatalogId());
			pstmt.setInt(2, brwhistory.getStatusId());
			pstmt.setInt(3, brwhistory.getAccountId());
			pstmt.setString(4, brwhistory.getDateBorrowed());
			pstmt.setString(5, brwhistory.getDateExpectReturn());
			pstmt.executeUpdate();
			
			while(rs.next()) {
				accountID = rs.getInt(BorrowHistory.COLUMN_CATALOGID);
			}
			
			return accountID;
			
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
		return -1;
	}
	
	
}
