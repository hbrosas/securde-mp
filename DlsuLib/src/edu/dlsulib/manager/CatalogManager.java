package edu.dlsulib.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.dlsulib.beans.Catalog;
import edu.dlsulib.beans.Catalog;
import edu.dlsulib.db.DBPool;

public class CatalogManager {
	public static int CreateCatalog(int catid, int statusid, int typeid, int borrowid, String location, String title, String author, String publisher, String year, String tags) {
		String sql = "INSERT INTO " + Catalog.TABLE_NAME + " ( " + Catalog.COLUMN_CATALOGID + "," + Catalog.COLUMN_STATUSID + ","
				+ Catalog.COLUMN_TYPEID + "," + Catalog.COLUMN_CURRENTBORROWID + "," + Catalog.COLUMN_LOCATION + ","
				+ Catalog.COLUMN_AUTHOR + "," + Catalog.COLUMN_PUBLISHER + "," + Catalog.COLUMN_YEAR + "," + Catalog.COLUMN_TAGS + ") " + " VALUES " 
				 + " (catid, statusid, typeid, borrowid, location, title, author, publisher, year, tags)" +";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int catalogId = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				 catalogId = rs.getInt(0);
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
		
		return catalogId;
	}
	
	public static ArrayList<Integer> GetAllCatalogs() {
		String sql = "SELECT " + Catalog.COLUMN_ACCOUNTID + " FROM " + Catalog.TABLE_NAME
				 + ";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Integer> catalogIds = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				 catalogIds.add(rs.getInt(Catalog.COLUMN_CATALOGID));
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
		
		return catalogIds;
	}	
	
	public static boolean EditCatalog(int statusid, int borrowid, String author, String title, String year, String publisher) {
		
		return false;
	}
	
	public static int GetCatalog(String author, String title, String year) {
		String sql = "SELECT " + " * " + " FROM " + Catalog.TABLE_NAME + " WHERE " + Catalog.COLUMN_AUTHOR + " = "
				+ author + " OR " + Catalog.COLUMN_TITLE + " = " + title + " AND " + Catalog.COLUMN_YEAR
				 + year + ";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int catalogId = 0;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				catalogId = rs.getInt(Catalog.COLUMN_CATALOGID);
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
		
		return catalogId;
	}
	
}
