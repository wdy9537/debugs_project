package com.debugs.userPage.mainPage.model.vo;

public class Playlist {
	
	private int playlistNo;
	private String playlistTh;
	private String playlistSubject;
	private int userNo;
	private int playlistType;
	/*
	 * PLAYLIST_NO NUMBER 
	 * PLAYLIST_TH VARCHAR2(30 BYTE) 
	 * PLAYLIST_SUBJECT VARCHAR2(50
	 * BYTE) 
	 * USER_NO NUMBER 
	 * PLAYLIST_TYPE NUMBER
	 */

	public Playlist() {

	}
	public Playlist(int playlistNo, String playlistTh, String playlistSubject, int userNo, int playlistType) {
		super();
		this.playlistNo = playlistNo;
		this.playlistTh = playlistTh;
		this.playlistSubject = playlistSubject;
		this.userNo = userNo;
		this.playlistType = playlistType;
	}
	public int getPlaylistNo() {
		return playlistNo;
	}
	public void setPlaylistNo(int playlistNo) {
		this.playlistNo = playlistNo;
	}
	public String getPlaylistTh() {
		return playlistTh;
	}
	public void setPlaylistTh(String playlistTh) {
		this.playlistTh = playlistTh;
	}
	public String getPlaylistSubject() {
		return playlistSubject;
	}
	public void setPlaylistSubject(String playlistSubject) {
		this.playlistSubject = playlistSubject;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getPlaylistType() {
		return playlistType;
	}
	public void setPlaylistType(int playlistType) {
		this.playlistType = playlistType;
	}
	
	@Override
	public String toString() {
		return "Playlist [playlistNo=" + playlistNo + ", playlistTh=" + playlistTh + ", playlistSubject="
				+ playlistSubject + ", userNo=" + userNo + ", playlistType=" + playlistType + "]";
	}
	

}
