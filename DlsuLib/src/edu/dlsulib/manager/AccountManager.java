package edu.dlsulib.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.dlsulib.beans.UserAccount;
import edu.dlsulib.db.DBPool;

public class AccountManager {
	public static ArrayList<Integer> getAllAccounts() {
		String sql = "SELECT " + UserAccount.COLUMN_ACCOUNTID + " FROM " + UserAccount.TABLE_NAME
				 + ";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Integer> accountIds = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				 accountIds.add(rs.getInt(UserAccount.COLUMN_ACCOUNTID));
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
	
	public static int CreateAccount(int userid, int accountid, int roleid, String userame, String password, String email, int sqlid, String sqlans) {
		String sql = "INSERT INTO " + UserAccount.TABLE_NAME + " ( " + UserAccount.COLUMN_USERID + "," + UserAccount.COLUMN_ACCOUNTID + ","
				+ UserAccount.COLUMN_ROLEID + "," + UserAccount.COLUMN_USERNAME + "," + UserAccount.COLUMN_PASSWORD + ","
				+ UserAccount.COLUMN_EMAILADDRESS + "," + UserAccount.COLUMN_SQID + "," + UserAccount.COLUMN_SQANSWER + ") " + " VALUES " 
				 + " (userid, accountid, roleid, username, password, email, password, email, sqlid, sqlans)" +";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int Accountid = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
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
		String sql = "SELECT " + " * " + " FROM " + UserAccount.TABLE_NAME + " WHERE " + UserAccount.COLUMN_USERNAME + " = "
				+ value + " OR " + UserAccount.COLUMN_EMAILADDRESS + " = " + value + " AND " + UserAccount.COLUMN_PASSWORD
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
	
	public static int getAccountDetails(String value, String password) {
		String sql = "SELECT " + " * " + " FROM " + UserAccount.TABLE_NAME + " WHERE " + UserAccount.COLUMN_USERNAME + " = "
				+ value + " OR " + UserAccount.COLUMN_EMAILADDRESS + " = " + value + " AND " + UserAccount.COLUMN_PASSWORD
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
	
	
}
