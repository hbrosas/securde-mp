package edu.dlsulib.beans;

import java.io.Serializable;

public class Review implements Serializable {
	public static final String TABLE_NAME = "reviews";
	public static final String COLUMN_REVIEWID = "reviewId";
	public static final String COLUMN_USERID = "userId";
	public static final String COLUMN_CATALOGID = "catalogId";
	public static final String COLUMN_REVIEW = "review";
	public static final String COLUMN_DATEREVIEWED = "dateReviewed";
	
	public Review(int reviewId, int userId, int catalogId, String review, String dateReviewed) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.catalogId = catalogId;
		this.review = review;
		this.dateReviewed = dateReviewed;
	}

	private int reviewId, userId, catalogId;
	private String review, dateReviewed;
	
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getDateReviewed() {
		return dateReviewed;
	}
	public void setDateReviewed(String dateReviewed) {
		this.dateReviewed = dateReviewed;
	}
	
}
