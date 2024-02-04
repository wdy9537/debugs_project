package com.debugs.adminPage.model.vo;

public class Notice {

	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private int noticeCategory;
	
	private String categoryName;

	public Notice() {

	}

	public Notice(int noticeNo, String noticeTitle, String noticeContent, int noticeCategory, String categoryName) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeCategory = noticeCategory;
		this.categoryName = categoryName;
	}

	public Notice(int noticeNo, String noticeTitle, String noticeContent, String categoryName) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.categoryName = categoryName;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public int getNoticeCategory() {
		return noticeCategory;
	}

	public void setNoticeCategory(int noticeCategory) {
		this.noticeCategory = noticeCategory;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeCategory=" + noticeCategory + "]";
	}

}
