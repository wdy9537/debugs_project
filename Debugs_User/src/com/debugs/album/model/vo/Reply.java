package com.debugs.album.model.vo;

public class Reply {

	private int replyNo;
	private String replyContent;
	private int albumNo;
	private int userNo;
	
	private String userName;

	public Reply() {

	}

	public Reply(String userName, int replyNo, String replyContent, int albumNo, int userNo) {
		super();
		this.userName = userName;
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.albumNo = albumNo;
		this.userNo = userNo;
	}

	public Reply(String userName, String replyContent) {
		super();
		this.replyContent = replyContent;
		this.userName = userName;
	}

	public Reply(String replyContent, int albumNo, int userNo) {
		super();
		this.replyContent = replyContent;
		this.albumNo = albumNo;
		this.userNo = userNo;
	}

	public Reply(int replyNo, String replyContent, int albumNo, int userNo) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.albumNo = albumNo;
		this.userNo = userNo;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public int getAlbumNo() {
		return albumNo;
	}

	public void setAlbumNo(int albumNo) {
		this.albumNo = albumNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", albumNo=" + albumNo + ", userNo="
				+ userNo + "]";
	}

}
