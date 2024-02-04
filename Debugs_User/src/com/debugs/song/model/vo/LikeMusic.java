package com.debugs.song.model.vo;

public class LikeMusic {
	private int userNo;
	private int musicNo;
	private int musicLike;
	
	public LikeMusic() {
		
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

	public int getMusicLike() {
		return musicLike;
	}

	public void setMusicLike(int musicLike) {
		this.musicLike = musicLike;
	}

	public LikeMusic(int userNo, int musicNo, int musicLike) {
		super();
		this.userNo = userNo;
		this.musicNo = musicNo;
		this.musicLike = musicLike;
	}

	@Override
	public String toString() {
		return "LikeMusic [userNo=" + userNo + ", musicNo=" + musicNo + ", musicLike=" + musicLike + "]";
	}
	
	
	
}
