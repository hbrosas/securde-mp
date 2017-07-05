package edu.dlsulib.beans;

import java.io.Serializable;
import java.sql.Date;

public class BorrowHistory implements Serializable {
	public static final String TABLE_NAME = "borrowhistory";
	public static final String COLUMN_BORROWID = "borrowId";
	public static final String COLUMN_CATALOGID = "catalogId";
	public static final String COLUMN_STATUSID = "statusId";
	public static final String COLUMN_ACCOUNTID = "accountId";
	public static final String COLUMN_DATEBORROWED = "dateBorrowed";
	public static final String COLUMN_DATEEXPECTRETURN = "dateExpectReturn";
	public static final String COLUMN_DATERETURN = "dateReturn";
	
	private int borrowId, catalogId, statusId, accountId;
	private String dateBorrowed, dateExpectReturn, dateReturn;
	
	public int getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
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
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getDateBorrowed() {
		return dateBorrowed;
	}
	public void setDateBorrowed(String dateBorrowed) {
		this.dateBorrowed = dateBorrowed;
	}
	public String getDateExpectReturn() {
		return dateExpectReturn;
	}
	public void setDateExpectReturn(String dateExpectReturn) {
		this.dateExpectReturn = dateExpectReturn;
	}
	public String getDateReturn() {
		return dateReturn;
	}
	public void setDateReturn(String dateReturn) {
		this.dateReturn = dateReturn;
	}

}
