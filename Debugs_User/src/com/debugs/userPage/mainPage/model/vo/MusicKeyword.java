package com.debugs.userPage.mainPage.model.vo;

public class MusicKeyword {

	private int musicNo;
	private int keywordNo;

	public MusicKeyword() {

	}

	public MusicKeyword(int musicNo, int keywordNo) {
		super();
		this.musicNo = musicNo;
		this.keywordNo = keywordNo;
	}

	public int getMusicNo() {
		return musicNo;
	}

	public void setMusicNo(int musicNo) {
		this.musicNo = musicNo;
	}

	public int getKeywordNo() {
		return keywordNo;
	}

	public void setKeywordNo(int keywordNo) {
		this.keywordNo = keywordNo;
	}

	@Override
	public String toString() {
		return "MusicKeyword [musicNo=" + musicNo + ", keywordNo=" + keywordNo + "]";
	}

}
