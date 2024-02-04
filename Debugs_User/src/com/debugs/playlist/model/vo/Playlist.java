package com.debugs.playlist.model.vo;

public class Playlist {
	private int playlistNo;
	private int userNo;
	private String playlistTh;
	private String playlistSubject;
	
	private String userId;
	private int count;
	
	private String th1;
	private String th2;
	private String th3;
	private String th4;
	
	public Playlist() {
		
	}
	
	public int getPlaylistNo() {
		return playlistNo;
	}
	public void setPlaylistNo(int playlistNo) {
		this.playlistNo = playlistNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getTh1() {
		return th1;
	}

	public void setTh1(String th1) {
		this.th1 = th1;
	}

	public String getTh2() {
		return th2;
	}

	public void setTh2(String th2) {
		this.th2 = th2;
	}

	public String getTh3() {
		return th3;
	}

	public void setTh3(String th3) {
		this.th3 = th3;
	}

	public String getTh4() {
		return th4;
	}

	public void setTh4(String th4) {
		this.th4 = th4;
	}

	public Playlist(int playlistNo, int userNo, String playlistTh, String playlistSubject) {
		super();
		this.playlistNo = playlistNo;
		this.userNo = userNo;
		this.playlistTh = playlistTh;
		this.playlistSubject = playlistSubject;
	}
	@Override
	public String toString() {
		return "Playlist [playlistNo=" + playlistNo + ", userNo=" + userNo + ", playlistTh=" + playlistTh
				+ ", playlistSubject=" + playlistSubject + "]";
	}

	// PlaylistDetailVeiw를 조회하기 위해 필요한 생성자
	public Playlist(int playlistNo, String playlistTh, String playlistSubject, String userId, String th1, String th2, String th3, String th4) {
		super();
		this.playlistNo = playlistNo;
		this.playlistTh = playlistTh;
		this.playlistSubject = playlistSubject;
		this.userId = userId;
		this.th1 = th1;
		this.th2 = th2;
		this.th3 = th3;
		this.th4 = th4;
	}
	
	// 추천 플레이리스트를 조회하기 위해 필요한 생성자
	public Playlist(int playlistNo, String playlistTh, String playlistSubject, String userId, int count, String th1, String th2, String th3, String th4) {
		super();
		this.playlistNo = playlistNo;
		this.playlistTh = playlistTh;
		this.playlistSubject = playlistSubject;
		this.userId = userId;
		this.count = count;
		this.th1 = th1;
		this.th2 = th2;
		this.th3 = th3;
		this.th4 = th4;
	}

	// 플레이리스트 추가 팝업을 조회하기 위해 필요한 생성자
	public Playlist(int playlistNo, int userNo, String playlistTh, String playlistSubject, int count) {
		super();
		this.playlistNo = playlistNo;
		this.userNo = userNo;
		this.playlistTh = playlistTh;
		this.playlistSubject = playlistSubject;
		this.count = count;
	}
	
	public Playlist(int playlistNo, int userNo, String playlistTh, String playlistSubject, int count, String th1) {
		super();
		this.playlistNo = playlistNo;
		this.userNo = userNo;
		this.playlistTh = playlistTh;
		this.playlistSubject = playlistSubject;
		this.count = count;
		this.th1 = th1;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	
	
	
}

