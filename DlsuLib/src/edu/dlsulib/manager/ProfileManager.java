package edu.dlsulib.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.dlsulib.beans.UserProfile;
import edu.dlsulib.db.DBPool;

public class ProfileManager {
	public static int CreateProfile(UserProfile userprofile) {
	String sql = "INSERT INTO " + UserProfile.TABLE_NAME + " ( " 
			+ UserProfile.COLUMN_ACCOUNTID + "," + UserProfile.COLUMN_FIRSTNAME + "," 
			+ UserProfile.COLUMN_LASTNAME + "," + UserProfile.COLUMN_MIDDLENAME + ","
			+ UserProfile.COLUMN_IDNUMBER + "," + UserProfile.COLUMN_BIRTHDATE + "," 
			+ UserProfile.COLUMN_BIRTHMONTH + ", " + UserProfile.COLUMN_BIRTHYEAR 
			+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	Connection conn = DBPool.getInstance().getConnection();
	PreparedStatement pstmt = null;
	
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
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	UserProfile profile = GetProfileUsingAccountId(userprofile.getAccountId());
	return profile.getUserId();	
}
	
	public static UserProfile GetProfileUsingAccountId(int accountId) {
		String sql = "SELECT * FROM " + UserProfile.TABLE_NAME + " WHERE " + UserProfile.COLUMN_ACCOUNTID + " LIKE ?;";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserProfile profile = new UserProfile();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			pstmt.setInt(1, accountId);
			
			if(rs.next()) {
				profile.setUserId(rs.getInt(UserProfile.COLUMN_USERID));
				profile.setAccountId(rs.getInt(UserProfile.COLUMN_ACCOUNTID));
				profile.setFirstname(rs.getString(UserProfile.COLUMN_FIRSTNAME));
				profile.setMiddlename(rs.getString(UserProfile.COLUMN_MIDDLENAME));
				profile.setLastname(rs.getString(UserProfile.COLUMN_LASTNAME));
				profile.setIdNumber(rs.getString(UserProfile.COLUMN_IDNUMBER));
				profile.setBirthDate(rs.getInt(UserProfile.COLUMN_BIRTHDATE));
				profile.setBirthDate(rs.getInt(UserProfile.COLUMN_BIRTHMONTH));
				profile.setBirthDate(rs.getInt(UserProfile.COLUMN_BIRTHYEAR));
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
		
		return profile;
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
	
	public static UserProfile GetProfile(int profileid) {
		String sql = "SELECT * FROM " + UserProfile.TABLE_NAME + " WHERE " + UserProfile.COLUMN_USERID + " LIKE ?;";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserProfile profile = new UserProfile();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			pstmt.setInt(1, profileid);
			
			if(rs.next()) {
				profile.setUserId(rs.getInt(UserProfile.COLUMN_USERID));
				profile.setAccountId(rs.getInt(UserProfile.COLUMN_ACCOUNTID));
				profile.setFirstname(rs.getString(UserProfile.COLUMN_FIRSTNAME));
				profile.setMiddlename(rs.getString(UserProfile.COLUMN_MIDDLENAME));
				profile.setLastname(rs.getString(UserProfile.COLUMN_LASTNAME));
				profile.setIdNumber(rs.getString(UserProfile.COLUMN_IDNUMBER));
				profile.setBirthDate(rs.getInt(UserProfile.COLUMN_BIRTHDATE));
				profile.setBirthDate(rs.getInt(UserProfile.COLUMN_BIRTHMONTH));
				profile.setBirthDate(rs.getInt(UserProfile.COLUMN_BIRTHYEAR));
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
		
		return profile;
	}
	
	public static ArrayList<UserProfile> GetAllProfile() {
		String sql = "SELECT " + " * " + " FROM " + UserProfile.TABLE_NAME + ";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<UserProfile> userprofile = new ArrayList<>();
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				userprofile.add(new UserProfile(rs.getInt(UserProfile.COLUMN_USERID),
								rs.getInt(UserProfile.COLUMN_ACCOUNTID),
								rs.getString(UserProfile.COLUMN_FIRSTNAME),
								rs.getString(UserProfile.COLUMN_MIDDLENAME),
								rs.getString(UserProfile.COLUMN_LASTNAME),
								rs.getString(UserProfile.COLUMN_IDNUMBER),
								rs.getInt(UserProfile.COLUMN_BIRTHDATE),
								rs.getInt(UserProfile.COLUMN_BIRTHMONTH),
								rs.getInt(UserProfile.COLUMN_BIRTHYEAR)));
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
		
		return userprofile;
		
		
	}
	
	
		
}
