package edu.dlsulib.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.dlsulib.beans.Review;
import edu.dlsulib.beans.UserAccount;
import edu.dlsulib.db.DBPool;

public class ReviewManager {
	public static void AddReview(int catalogid, String review) {
		String sql = "INSERT INTO " + Review.TABLE_NAME  + " ( " + Review.COLUMN_CATALOGID + ", " + Review.COLUMN_REVIEW
				 + ", " + Review.COLUMN_DATEREVIEWED + ") " + " VALUES (?, ?, NOW()) " + ";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			pstmt.setInt(1, catalogid);
			pstmt.setString(2, review);
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
	
	public static ArrayList<Review> GetAllReviews() {
		String sql = "SELECT " + "*" + " FROM " + Review.TABLE_NAME
				 + ";";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Review> reviews = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				 reviews.add(new Review(rs.getInt(Review.COLUMN_REVIEWID),
						 rs.getInt(Review.COLUMN_USERID), 
						 rs.getInt(Review.COLUMN_CATALOGID),
						 rs.getString(Review.COLUMN_REVIEW),
						 rs.getString(Review.COLUMN_DATEREVIEWED)));
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
		return reviews;
	}	
	
	
}	
