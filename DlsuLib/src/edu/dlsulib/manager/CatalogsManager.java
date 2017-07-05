package edu.dlsulib.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.dlsulib.beans.Catalog;
import edu.dlsulib.beans.ReserveHistory;
import edu.dlsulib.beans.Catalog;
import edu.dlsulib.db.DBPool;

public class CatalogsManager {
	public static void CreateCatalog(int catid, int statusid, int typeid, int borrowid, String location, String title, String author, String publisher, String year, String tags) {
		String sql = "INSERT INTO " + Catalog.TABLE_NAME + " ( " + Catalog.COLUMN_CATALOGID + "," + Catalog.COLUMN_STATUSID + ","
				+ Catalog.COLUMN_TYPEID + "," + Catalog.COLUMN_CURRENTBORROWID + "," + Catalog.COLUMN_LOCATION + ","
				+ Catalog.COLUMN_AUTHOR + "," + Catalog.COLUMN_PUBLISHER + "," + Catalog.COLUMN_YEAR + "," + Catalog.COLUMN_TAGS + ") " + " VALUES " 
				 + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" +";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int catalogId = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, catid);
			pstmt.setInt(2, statusid);
			pstmt.setInt(3, typeid);
			pstmt.setInt(4, borrowid);
			pstmt.setString(5, location);
			pstmt.setString(6, title);
			pstmt.setString(7, author);
			pstmt.setString(8, publisher);
			pstmt.setString(9, year);
			pstmt.setString(10, tags);
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
	
	public static void ChangeStatus(int catalogID, int statusID, int borrower) {
		String sql = "UPDATE " + Catalog.TABLE_NAME + " SET "
			    + Catalog.COLUMN_STATUSID + "=?, " + Catalog.COLUMN_CURRENTBORROWID
				+ "=? WHERE "+ Catalog.COLUMN_CATALOGID +" =?;";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReserveHistory reservehistory = new ReserveHistory();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(3, catalogID);
			pstmt.setInt(1, statusID);
			pstmt.setInt(2, borrower);
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
	}
	
	public static ArrayList<Catalog> GetAllCatalogs() {
		String sql = "SELECT * FROM " + Catalog.TABLE_NAME + ";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Catalog> allCatalog = new ArrayList<Catalog>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Catalog catalog = new Catalog();
				catalog.setCatalogId(rs.getInt(Catalog.COLUMN_CATALOGID));
				catalog.setTypeId(rs.getInt(Catalog.COLUMN_TYPEID));
				catalog.setStatusId(rs.getInt(Catalog.COLUMN_STATUSID));
				catalog.setCurrentBorrowId(rs.getInt(Catalog.COLUMN_CURRENTBORROWID));
				catalog.setTitle(rs.getString(Catalog.COLUMN_TITLE));
				catalog.setAuthor(rs.getString(Catalog.COLUMN_AUTHOR));
				catalog.setPublisher(rs.getString(Catalog.COLUMN_PUBLISHER));
				catalog.setYear(rs.getString(Catalog.COLUMN_YEAR));
				catalog.setTags(rs.getString(Catalog.COLUMN_TAGS));
				catalog.setLocation(rs.getString(Catalog.COLUMN_LOCATION));
				allCatalog.add(catalog);
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
		
		return allCatalog;
	}
	
	public static boolean DeleteCatalog(int catalogid) {
		String sql = "DELETE " + "FROM" + Catalog.TABLE_NAME
				 + " WHERE " + Catalog.COLUMN_CATALOGID + " LIKE " + "?" + ";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, catalogid);
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
		
		return true;
	}	
	
	public static boolean EditCatalog(Catalog catalog) {
		
		return false;
	}
	
	public static ArrayList<Catalog> SearchCatalog(String value, String by, int type) {
		String sql = "SELECT * FROM " + Catalog.TABLE_NAME + " WHERE ";
		String keyword = "%" + value + "%";
		if(by.equalsIgnoreCase("title")) {
			if(type != -1) { // meron type
				sql += Catalog.COLUMN_TITLE + " LIKE ? AND " + Catalog.COLUMN_TYPEID + " =?;";
			} else {
				sql += Catalog.COLUMN_TITLE + " LIKE ?;";
			}
		} else if(by.equalsIgnoreCase("location")) {
			if(type != -1) { // meron type
				sql += Catalog.COLUMN_LOCATION + " LIKE ? AND " + Catalog.COLUMN_TYPEID + " =?;";
			} else {
				sql += Catalog.COLUMN_LOCATION + " LIKE ?;";
			}
		} else if(by.equalsIgnoreCase("author")) {
			if(type != -1) { // meron type
				sql += Catalog.COLUMN_AUTHOR + " LIKE ? AND " + Catalog.COLUMN_TYPEID + " =?;";
			} else {
				sql += Catalog.COLUMN_AUTHOR + " LIKE ?;";
			}
		} else if(by.equalsIgnoreCase("publisher")) {
			if(type != -1) { // meron type
				sql += Catalog.COLUMN_PUBLISHER + " LIKE ? AND " + Catalog.COLUMN_TYPEID + " =?;";
			} else {
				sql += Catalog.COLUMN_PUBLISHER + " LIKE ?;";
			}
		} else if(by.equalsIgnoreCase("tags")) {
			if(type != -1) { // meron type
				sql += Catalog.COLUMN_TAGS + " LIKE ? AND " + Catalog.COLUMN_TYPEID + " =?;";
			} else {
				sql += Catalog.COLUMN_TAGS + " LIKE ?;";
			}
		}
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Catalog> srchdcatalogs = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			if(type != -1) {
				pstmt.setString(1, keyword);
				pstmt.setInt(2, type);
			} else pstmt.setString(1, keyword);
				
			rs = pstmt.executeQuery();

			while(rs.next()) {
				Catalog catalog2 = new Catalog();
				catalog2.setCatalogId(rs.getInt(Catalog.COLUMN_CATALOGID));
				catalog2.setTypeId(rs.getInt(Catalog.COLUMN_TYPEID));
				catalog2.setStatusId(rs.getInt(Catalog.COLUMN_STATUSID));
				catalog2.setCurrentBorrowId(rs.getInt(Catalog.COLUMN_CURRENTBORROWID));
				catalog2.setTitle(rs.getString(Catalog.COLUMN_TITLE));
				catalog2.setAuthor(rs.getString(Catalog.COLUMN_AUTHOR));
				catalog2.setPublisher(rs.getString(Catalog.COLUMN_PUBLISHER));
				catalog2.setYear(rs.getString(Catalog.COLUMN_YEAR));
				catalog2.setTags(rs.getString(Catalog.COLUMN_TAGS));
				catalog2.setLocation(rs.getString(Catalog.COLUMN_LOCATION));
				srchdcatalogs.add(catalog2);
			}
			
			return srchdcatalogs;
			
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
	
	public static Catalog GetCatalog(int catalogid) {
		String sql = "SELECT * FROM " + Catalog.TABLE_NAME + " WHERE " + Catalog.COLUMN_CATALOGID + " LIKE ?;";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Catalog catalog = new Catalog();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, catalogid);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				catalog.setCatalogId(rs.getInt(Catalog.COLUMN_CATALOGID));
				catalog.setStatusId(rs.getInt(Catalog.COLUMN_STATUSID));
				catalog.setTypeId(rs.getInt(Catalog.COLUMN_TYPEID));
				catalog.setCurrentBorrowId(rs.getInt(Catalog.COLUMN_CURRENTBORROWID));
				catalog.setLocation(rs.getString(Catalog.COLUMN_LOCATION));
				catalog.setAuthor(rs.getString(Catalog.COLUMN_AUTHOR));
				catalog.setTitle(rs.getString(Catalog.COLUMN_TITLE));
				catalog.setYear(rs.getString(Catalog.COLUMN_YEAR));
				catalog.setTags(rs.getString(Catalog.COLUMN_TAGS));
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
		
		return catalog;

	}
	
}
