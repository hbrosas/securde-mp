package edu.dlsulib.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.dlsulib.beans.UserProfile;
import edu.dlsulib.db.DBPool;

public class ProfileManager {
	public static void CreateProfile(UserProfile userprofile) {
	String sql = "INSERT INTO " + UserProfile.TABLE_NAME + " ( " + UserProfile.COLUMN_USERID + "," + UserProfile.COLUMN_ACCOUNTID + ","
			+ UserProfile.COLUMN_FIRSTNAME + "," + UserProfile.COLUMN_LASTNAME + "," + UserProfile.COLUMN_MIDDLENAME + ","
			+ UserProfile.COLUMN_IDNUMBER + "," + UserProfile.COLUMN_BIRTHDATE + "," + UserProfile.COLUMN_BIRTHMONTH 
			+ ", " + UserProfile.COLUMN_BIRTHYEAR + ") " + " VALUES " 
			 + " (?, ?, ?, ?, ?, ?, ?, ?, ?)" +";";
	
	Connection conn = DBPool.getInstance().getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;	
	int userId = 0;
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, userprofile.getUserId());
		pstmt.setInt(2, userprofile.getAccountId());
		pstmt.setString(3, userprofile.getFirstname());
		pstmt.setString(4, userprofile.getLastname());
		pstmt.setString(5, userprofile.getMiddlename());
		pstmt.setString(6, userprofile.getIdNumber());
		pstmt.setInt(7, userprofile.getBirthDate());
		pstmt.setInt(8, userprofile.getBirthMonth());
		pstmt.setInt(9, userprofile.getBirthYear());
		pstmt.executeUpdate();
		
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
	
	}
	
	public static void EditProfile(UserProfile userprofile) {
		String sql = "UPDATE " + UserProfile.TABLE_NAME + " ( " + UserProfile.COLUMN_USERID + "," + UserProfile.COLUMN_ACCOUNTID + ","
				+ UserProfile.COLUMN_FIRSTNAME + "," + UserProfile.COLUMN_LASTNAME + "," + UserProfile.COLUMN_MIDDLENAME + ","
				+ UserProfile.COLUMN_IDNUMBER + "," + UserProfile.COLUMN_BIRTHDATE + "," + UserProfile.COLUMN_BIRTHMONTH 
				+ ", " + UserProfile.COLUMN_BIRTHYEAR + ") " + " VALUES " 
				 + " (?, ?, ?, ?, ?, ?, ?, ?, ?)" +";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		int userId = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userprofile.getUserId());
			pstmt.setInt(2, userprofile.getAccountId());
			pstmt.setString(3, userprofile.getFirstname());
			pstmt.setString(4, userprofile.getLastname());
			pstmt.setString(5, userprofile.getMiddlename());
			pstmt.setString(6, userprofile.getIdNumber());
			pstmt.setInt(7, userprofile.getBirthDate());
			pstmt.setInt(8, userprofile.getBirthMonth());
			pstmt.setInt(9, userprofile.getBirthYear());
			pstmt.executeUpdate();
			
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
		
		}
		
		
}
