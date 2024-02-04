package com.debugs.adminPage.model.vo;

public class Reply {

	private int replyNo;
	private String replyContent;
	private int albumNo;
	private int userNo;

	public Reply() {

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

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", albumNo=" + albumNo + ", userNo="
				+ userNo + "]";
	}

}
