package edu.dlsulib.beans;

import java.io.Serializable;

public class Catalog implements Serializable {
	public static final String TABLE_NAME = "catalog";
	public static final String COLUMN_CATALOGID = "catalogId";
	public static final String COLUMN_STATUSID = "statusId";
	public static final String COLUMN_TYPEID = "typeId";
	public static final String COLUMN_CURRENTBORROWID = "currentBorrowId";
	public static final String COLUMN_LOCATION = "location";
	public static final String COLUMN_TITLE = "title";
	public static final String COLUMN_AUTHOR = "author";
	public static final String COLUMN_PUBLISHER = "publisher";
	public static final String COLUMN_YEAR = "year";
	public static final String COLUMN_TAGS = "tags";
	

	private int catalogId, statusId, typeId, currentBorrowId;
	private String location, title,  author, publisher, year, tags;
	
	
	
	public String getTitle() {
		return title;
	}
	public int getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getCurrentBorrowId() {
		return currentBorrowId;
	}
	public void setCurrentBorrowId(int currentBorrowId) {
		this.currentBorrowId = currentBorrowId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}

}
