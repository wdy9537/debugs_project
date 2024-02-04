package com.debugs.album.model.vo;

public class Keyword {

	private int keywordNo;
	private String keywordName;

	public Keyword() {

	}

	public Keyword(int keywordNo, String keywordName) {
		super();
		this.keywordNo = keywordNo;
		this.keywordName = keywordName;
	}

	public int getKeywordNo() {
		return keywordNo;
	}

	public void setKeywordNo(int keywordNo) {
		this.keywordNo = keywordNo;
	}

	public String getKeywordName() {
		return keywordName;
	}

	public void setKeywordName(String keywordName) {
		this.keywordName = keywordName;
	}

	@Override
	public String toString() {
		return "Keyword [keywordNo=" + keywordNo + ", keywordName=" + keywordName + "]";
	}

}
