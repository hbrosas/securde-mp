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
		int borrowID = 0;
		try {
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, brwhistory.getCatalogId());
			pstmt.setInt(2, brwhistory.getStatusId());
			pstmt.setInt(3, brwhistory.getAccountId());
			pstmt.setString(4, brwhistory.getDateBorrowed());
			pstmt.setString(5, brwhistory.getDateExpectReturn());
			pstmt.executeUpdate();
			
			try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	            	borrowID = generatedKeys.getInt(1);
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
			
			return borrowID;
			
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
