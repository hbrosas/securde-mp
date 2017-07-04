package edu.dlsulib.beans;

import java.io.Serializable;

public class UserAccount implements Serializable {
	public static final String TABLE_NAME = "useraccount";
	public static final String COLUMN_USERID = "userId";
	public static final String COLUMN_ACCOUNTID = "accountId";
	public static final String COLUMN_ROLEID = "roleId";
	public static final String COLUMN_USERNAME = "username";
	public static final String COLUMN_PASSWORD = "password";
	public static final String COLUMN_EMAILADDRESS = "emailAddress";
	public static final String COLUMN_SQID = "SQId";
	public static final String COLUMN_SQANSWER = "SQAnswer";
	
	public UserAccount(int userId, int accountId, int roleId, int sQId, String username, String password,
			String emailAddress, String sQAnswer) {
		super();
		this.userId = userId;
		this.accountId = accountId;
		this.roleId = roleId;
		SQId = sQId;
		this.username = username;
		this.password = password;
		this.emailAddress = emailAddress;
		SQAnswer = sQAnswer;
	}
	
	private int userId, accountId, roleId, SQId;
	private String username, password, emailAddress, SQAnswer;
	
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
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getSQId() {
		return SQId;
	}
	public void setSQId(int sQId) {
		SQId = sQId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getSQAnswer() {
		return SQAnswer;
	}
	public void setSQAnswer(String sQAnswer) {
		SQAnswer = sQAnswer;
	}
}
