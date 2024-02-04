package com.debugs.adminPage.model.vo;

public class DebugUser {

	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String ssn;
	private String email;
	private String phone;
	private String ticketDate;
	private int ticketNo;
	private String ticketName;

	public DebugUser() {

	}

	public DebugUser(int userNo, String userId, String userPwd, String userName, String ssn, String email, String phone,
			String ticketDate, int ticketNo, String ticketName) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.ssn = ssn;
		this.email = email;
		this.phone = phone;
		this.ticketDate = ticketDate;
		this.ticketNo = ticketNo;
		this.ticketName = ticketName;
	}

	public DebugUser(int userNo, String userName, String userId, String userPwd, String phone, String email, String ssn,
			int ticketNo) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.userId = userId;
		this.userPwd = userPwd;
		this.ssn = ssn;
		this.email = email;
		this.phone = phone;
		this.ticketNo = ticketNo;
	}

	public DebugUser(String userName, String userId, String userPwd, String phone, String ssn, String email,
			String ticketName, String ticketDate) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.ssn = ssn;
		this.email = email;
		this.phone = phone;
		this.ticketDate = ticketDate;
		this.ticketName = ticketName;
	}

	public DebugUser(int userNo, String userName, String userId, String userPwd, String phone, String email, String ssn,
			String ticketName) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.userId = userId;
		this.userPwd = userPwd;
		this.phone = phone;
		this.email = email;
		this.ssn = ssn;
		this.ticketName = ticketName;
	}

	public DebugUser(int userNo, String userId, String userName, String ssn, String email, String phone, int ticketNo) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
		this.ssn = ssn;
		this.email = email;
		this.phone = phone;
		this.ticketNo = ticketNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getssn() {
		return ssn;
	}

	public void setssn(String ssn) {
		this.ssn = ssn;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}

	public String getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(String ticketDate) {
		this.ticketDate = ticketDate;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	@Override
	public String toString() {
		return "DebugUser [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", ssn=" + ssn + ", email=" + email + ", phone=" + phone + ", ticketDate=" + ticketDate
				+ ", ticketNo=" + ticketNo + ", ticketName=" + ticketName + "]";
	}

}
