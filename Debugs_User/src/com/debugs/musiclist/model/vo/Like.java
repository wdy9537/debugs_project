package com.debugs.musiclist.model.vo;

public class Like {
	private int userNo;
	private int musicNo;
	
	public Like() {
		
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getMusicNo() {
		return musicNo;
	}

	public void setMusicNo(int musicNo) {
		this.musicNo = musicNo;
	}

	@Override
	public String toString() {
		return "Like [userNo=" + userNo + ", musicNo=" + musicNo + "]";
	}

	public Like(int userNo, int musicNo) {
		super();
		this.userNo = userNo;
		this.musicNo = musicNo;
	}
}
