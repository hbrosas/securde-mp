package edu.dlsulib.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.dlsulib.beans.UserAccount;
import edu.dlsulib.db.DBPool;

public class AccountManager {
	public static ArrayList<Integer> GetAllAccounts() {
		String sql = "SELECT " + " * " + " FROM " + UserAccount.TABLE_NAME
				 + ";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<UserAccount> account = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				 account.add(new UserAccount(rs.getInt(UserAccount.COLUMN_USERID),
						 					rs.getInt(UserAccount.COLUMN_ACCOUNTID),
						 					rs.getInt(UserAccount.COLUMN_ROLEID),
						 					rs.getInt(UserAccount.COLUMN_SQID),
						 					rs.getString(UserAccount.COLUMN_USERNAME),
						 					rs.getString(UserAccount.COLUMN_PASSWORD),
						 					rs.getString(UserAccount.COLUMN_EMAILADDRESS),
						 					rs.getString(UserAccount.COLUMN_SQANSWER)));
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
		
		return accountIds;
	}	
	
	public static int CreateAccount(int userid, int accountid, int roleid, String username, String password, String email, int sqid, String sqans) {
		String sql = "INSERT INTO " + UserAccount.TABLE_NAME + " ( " + UserAccount.COLUMN_USERID + "," + UserAccount.COLUMN_ACCOUNTID + ","
				+ UserAccount.COLUMN_ROLEID + "," + UserAccount.COLUMN_USERNAME + "," + UserAccount.COLUMN_PASSWORD + ","
				+ UserAccount.COLUMN_EMAILADDRESS + "," + UserAccount.COLUMN_SQID + "," + UserAccount.COLUMN_SQANSWER + ") " + " VALUES " 
				 + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" +";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		int Accountid = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userid);
			pstmt.setInt(2, roleid);
			pstmt.setInt(3, roleid);
			pstmt.setString(4, username);
			pstmt.setString(5, password);
			pstmt.setString(6, email);
			pstmt.setInt(7, sqid);
			pstmt.setString(8, sqans);
			pstmt.executeUpdate();
			Accountid = userid;
			
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
		
		return Accountid;
	}
	
	public static int LoginAccount(String value, String password) {
		String sql = "SELECT " + " * " + " FROM " + UserAccount.TABLE_NAME + " WHERE " + UserAccount.COLUMN_USERNAME + " LIKE "
				+ value + " OR " + UserAccount.COLUMN_EMAILADDRESS + " LIKE " + value + " AND " + UserAccount.COLUMN_PASSWORD
				 + password + ";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int Accountid = 0;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				Accountid = rs.getInt(0);
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
		
		return Accountid;
	}
	
	public static int EditAccount(UserAccount useraccount) {
		String sql = "SELECT " + " * " + " FROM " + UserAccount.TABLE_NAME + " WHERE " + UserAccount.COLUMN_USERNAME + " LIKE "
				+ useraccount.getUsername() + " OR " + UserAccount.COLUMN_EMAILADDRESS + " LIKE " + useraccount.getEmailAddress() + " AND " + useraccount.getPassword()
				 + ";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int Accountid = 0;
		
		
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
		
		return Accountid;
	}
	
	public static int ForgotPasswordAccount(String value, String sqid, String sqans) {
		String sql = "SELECT " + " * " + " FROM " + UserAccount.TABLE_NAME + " WHERE " + UserAccount.COLUMN_USERNAME + " LIKE "
				+ value + " OR " + UserAccount.COLUMN_EMAILADDRESS + " LIKE " + value + " AND " + UserAccount.COLUMN_SQID + " = "
				 + sqid + " AND " + UserAccount.COLUMN_SQANSWER + ";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int Accountid = 0;
		
		
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
		
		return Accountid;
	}
	
	public static int GetAccountDetails(String value, String password) {
		String sql = "SELECT " + " * " + " FROM " + UserAccount.TABLE_NAME + " WHERE " + UserAccount.COLUMN_USERNAME + " LIKE "
				+ value + " OR " + UserAccount.COLUMN_EMAILADDRESS + " LIKE " + value + " AND " + UserAccount.COLUMN_PASSWORD
				 + password + ";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int Accountid = 0;
		
		
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
		
		return Accountid;
		
		
	}
	
	
}
