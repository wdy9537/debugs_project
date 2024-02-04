package com.debugs.adminPage.model.vo;

import java.sql.Date;

public class Blacklist {

	private int blacklistNo;
	private String blacklistName;
	private String blacklistUserNo;
	private String blacklistReason;
	private String blacklistStatus;
	private String blacklistDate;

	public Blacklist() {

	}

	public Blacklist(int blacklistNo, String blacklistName, String blacklistUserNo, String blacklistReason,
			String blacklistStatus, String blacklistDate) {
		super();
		this.blacklistNo = blacklistNo;
		this.blacklistName = blacklistName;
		this.blacklistUserNo = blacklistUserNo;
		this.blacklistReason = blacklistReason;
		this.blacklistStatus = blacklistStatus;
		this.blacklistDate = blacklistDate;
	}

	public Blacklist(String blacklistName, String blacklistUserNo, String blacklistReason, String blacklistDate) {
		super();
		this.blacklistName = blacklistName;
		this.blacklistUserNo = blacklistUserNo;
		this.blacklistReason = blacklistReason;
		this.blacklistDate = blacklistDate;
	}

	public int getBlacklistNo() {
		return blacklistNo;
	}

	public void setBlacklistNo(int blacklistNo) {
		this.blacklistNo = blacklistNo;
	}

	public String getBlacklistReason() {
		return blacklistReason;
	}

	public void setBlacklistReason(String blacklistReason) {
		this.blacklistReason = blacklistReason;
	}

	public String getBlacklistStatus() {
		return blacklistStatus;
	}

	public void setBlacklistStatus(String blacklistStatus) {
		this.blacklistStatus = blacklistStatus;
	}

	public String getBlacklistDate() {
		return blacklistDate;
	}

	public void setBlacklistDate(String blacklistDate) {
		this.blacklistDate = blacklistDate;
	}

	public String getBlacklistUserNo() {
		return blacklistUserNo;
	}

	public void setBlacklistUserNo(String blacklistUserNo) {
		this.blacklistUserNo = blacklistUserNo;
	}

	public String getBlacklistName() {
		return blacklistName;
	}

	public void setBlacklistName(String blacklistName) {
		this.blacklistName = blacklistName;
	}

	@Override
	public String toString() {
		return "Blacklist [blacklistNo=" + blacklistNo + ", blacklistReason=" + blacklistReason + ", blacklistStatus="
				+ blacklistStatus + ", blacklistDate=" + blacklistDate + ", blacklistUserNo=" + blacklistUserNo
				+ ", blacklistName=" + blacklistName + "]";
	}

}
