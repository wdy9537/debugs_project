package com.debugs.adminPage.model.vo;

public class ReplyList {

	private int replyNo;
	private String albumTitle;
	private String artistName;
	private String replyContent;

	public ReplyList() {

	}

	public ReplyList(int replyNo, String albumTitle, String artistName, String replyContent) {
		super();
		this.replyNo = replyNo;
		this.albumTitle = albumTitle;
		this.artistName = artistName;
		this.replyContent = replyContent;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	@Override
	public String toString() {
		return "ReplyList [replyNo=" + replyNo + ", albumTitle=" + albumTitle + ", artistName=" + artistName
				+ ", replyContent=" + replyContent + "]";
	}

}
