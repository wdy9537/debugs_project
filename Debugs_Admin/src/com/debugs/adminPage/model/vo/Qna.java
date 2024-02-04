package com.debugs.adminPage.model.vo;

public class Qna {

	private int qnaNo;
	private String qnaUserNo;
	private String qnaContent;
	private String qnaAnswer;
	private String qnaResult;
	private String qnaImage;
	private String qnaCategory;

	public Qna() {

	}

	public Qna(int qnaNo, String qnaUserNo, String qnaContent, String qnaAnswer, String qnaResult, String qnaImage,
			String qnaCategory) {
		super();
		this.qnaNo = qnaNo;
		this.qnaUserNo = qnaUserNo;
		this.qnaContent = qnaContent;
		this.qnaAnswer = qnaAnswer;
		this.qnaResult = qnaResult;
		this.qnaImage = qnaImage;
		this.qnaCategory = qnaCategory;
	}

	public Qna(int qnaNo, String qnaUserNo, String qnaContent, String qnaCategory) {
		super();
		this.qnaNo = qnaNo;
		this.qnaUserNo = qnaUserNo;
		this.qnaContent = qnaContent;
		this.qnaCategory = qnaCategory;
	}

	public Qna(int qnaNo, String qnaUserNo, String qnaContent, String qnaCategory, String qnaResult) {
		super();
		this.qnaNo = qnaNo;
		this.qnaUserNo = qnaUserNo;
		this.qnaContent = qnaContent;
		this.qnaCategory = qnaCategory;
		this.qnaResult = qnaResult;
	}

	public Qna(int qnaNo, String qnaContent, String qnaCategory) {
		super();
		this.qnaNo = qnaNo;
		this.qnaContent = qnaContent;
		this.qnaCategory = qnaCategory;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getQnaUserNo() {
		return qnaUserNo;
	}

	public void setQnaUserNo(String qnaUserNo) {
		this.qnaUserNo = qnaUserNo;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public String getQnaAnswer() {
		return qnaAnswer;
	}

	public void setQnaAnswer(String qnaAnswer) {
		this.qnaAnswer = qnaAnswer;
	}

	public String getQnaResult() {
		return qnaResult;
	}

	public void setQnaResult(String qnaResult) {
		this.qnaResult = qnaResult;
	}

	public String getQnaImage() {
		return qnaImage;
	}

	public void setQnaImage(String qnaImage) {
		this.qnaImage = qnaImage;
	}

	public String getQnaCategory() {
		return qnaCategory;
	}

	public void setQnaCategory(String qnaCategory) {
		this.qnaCategory = qnaCategory;
	}

	@Override
	public String toString() {
		return "Qna [qnaNo=" + qnaNo + ", qnaUserNo=" + qnaUserNo + ", qnaContent=" + qnaContent + ", qnaAnswer="
				+ qnaAnswer + ", qnaResult=" + qnaResult + ", qnaImage=" + qnaImage + ", qnaCategory=" + qnaCategory
				+ "]";
	}

}
