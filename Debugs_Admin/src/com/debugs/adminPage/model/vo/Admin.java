package com.debugs.adminPage.model.vo;

public class Admin {

	private int adminNo;
	private int adminGrade;
	private String adminName;
	private String adminId;
	private String adminPwd;
	private String adminPhone;
	private String adminMemo;

	public Admin() {

	}

	public Admin(int adminNo, int adminGrade, String adminName, String adminId, String adminPwd, String adminPhone,
			String adminMemo) {
		super();
		this.adminNo = adminNo;
		this.adminGrade = adminGrade;
		this.adminName = adminName;
		this.adminId = adminId;
		this.adminPwd = adminPwd;
		this.adminPhone = adminPhone;
		this.adminMemo = adminMemo;
	}

	public Admin(String adminName, String adminId, String adminPwd, String adminPhone) {
		super();
		this.adminName = adminName;
		this.adminId = adminId;
		this.adminPwd = adminPwd;
		this.adminPhone = adminPhone;
	}

	public Admin(int adminNo, String adminName, String adminId, String adminPwd, String adminPhone) {
		super();
		this.adminNo = adminNo;
		this.adminName = adminName;
		this.adminId = adminId;
		this.adminPwd = adminPwd;
		this.adminPhone = adminPhone;
	}

	public int getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(int adminNo) {
		this.adminNo = adminNo;
	}

	public int getAdminGrade() {
		return adminGrade;
	}

	public void setAdminGrade(int adminGrade) {
		this.adminGrade = adminGrade;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public String getAdminMemo() {
		return adminMemo;
	}

	public void setAdminMemo(String adminMemo) {
		this.adminMemo = adminMemo;
	}

	@Override
	public String toString() {
		return "Admin [adminNo=" + adminNo + ", adminGrade=" + adminGrade + ", adminName=" + adminName + ", adminId="
				+ adminId + ", adminPwd=" + adminPwd + ", adminPhone=" + adminPhone + ", adminMemo=" + adminMemo + "]";
	}

}
