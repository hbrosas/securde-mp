package edu.dlsulib.beans;

import java.io.Serializable;

public class UserProfile implements Serializable {

	public static final String TABLE_NAME = "userprofile";
	public static final String COLUMN_USERID = "userId";
	public static final String COLUMN_ACCOUNTID = "accountId";
	public static final String COLUMN_FIRSTNAME = "firstname";
	public static final String COLUMN_MIDDLENAME = "middlename";
	public static final String COLUMN_LASTNAME = "lastname";
	public static final String COLUMN_IDNUMBER = "idNumber";
	public static final String COLUMN_BIRTHDATE = "birthDate";
	public static final String COLUMN_BIRTHMONTH = "birthMonth";
	public static final String COLUMN_BIRTHYEAR = "birthYear";
	
	public UserProfile(int userId, int accountId, String firstname, String middlename, String lastname, String idNumber,
			int birthDate, int birthMonth, int birthYear) {
		super();
		this.userId = userId;
		this.accountId = accountId;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.idNumber = idNumber;
		this.birthDate = birthDate;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
	}
	
	private int userId, accountId;
	private String firstname, middlename, lastname, idNumber;
	private int birthDate, birthMonth, birthYear;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public int getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}
	public int getBirthMonth() {
		return birthMonth;
	}
	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
}
