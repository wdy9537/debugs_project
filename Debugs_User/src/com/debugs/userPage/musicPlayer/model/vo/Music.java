package com.debugs.userPage.musicPlayer.model.vo;

public class Music {

	private int musicNo;
	private int albumNo;
	private String musicDetail;
	private String musicGenre;
	private String musicTime;
	private String musicLyrics;
	private String musicFile;
	private String musicTitle;
	private String musicChangeName;
	private String musicPath;

	public Music() {

	}

	public Music(int musicNo, int albumNo, String musicDetail, String musicGenre, String musicTime, String musicLyrics,
			String musicFile, String musicTitle, String musicChangeName, String musicPath) {
		super();
		this.musicNo = musicNo;
		this.albumNo = albumNo;
		this.musicDetail = musicDetail;
		this.musicGenre = musicGenre;
		this.musicTime = musicTime;
		this.musicLyrics = musicLyrics;
		this.musicFile = musicFile;
		this.musicTitle = musicTitle;
		this.musicChangeName = musicChangeName;
		this.musicPath = musicPath;
	}

	public int getMusicNo() {
		return musicNo;
	}

	public void setMusicNo(int musicNo) {
		this.musicNo = musicNo;
	}

	public int getAlbumNo() {
		return albumNo;
	}

	public void setAlbumNo(int albumNo) {
		this.albumNo = albumNo;
	}

	public String getMusicDetail() {
		return musicDetail;
	}

	public void setMusicDetail(String musicDetail) {
		this.musicDetail = musicDetail;
	}

	public String getMusicGenre() {
		return musicGenre;
	}

	public void setMusicGenre(String musicGenre) {
		this.musicGenre = musicGenre;
	}

	public String getMusicTime() {
		return musicTime;
	}

	public void setMusicTime(String musicTime) {
		this.musicTime = musicTime;
	}

	public String getMusicLyrics() {
		return musicLyrics;
	}

	public void setMusicLyrics(String musicLyrics) {
		this.musicLyrics = musicLyrics;
	}

	public String getMusicFile() {
		return musicFile;
	}

	public void setMusicFile(String musicFile) {
		this.musicFile = musicFile;
	}

	public String getMusicTitle() {
		return musicTitle;
	}

	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}

	public String getMusicChangeName() {
		return musicChangeName;
	}

	public void setMusicChangeName(String musicChangeName) {
		this.musicChangeName = musicChangeName;
	}

	public String getMusicPath() {
		return musicPath;
	}

	public void setMusicPath(String musicPath) {
		this.musicPath = musicPath;
	}

	@Override
	public String toString() {
		return "Music [musicNo=" + musicNo + ", albumNo=" + albumNo + ", musicDetail=" + musicDetail + ", musicGenre="
				+ musicGenre + ", musicTime=" + musicTime + ", musicLyrics=" + musicLyrics + ", musicFile=" + musicFile
				+ ", musicTitle=" + musicTitle + ", musicChangeName=" + musicChangeName + ", musicPath=" + musicPath
				+ "]";
	}

}
