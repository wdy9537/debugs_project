package com.debugs.adminPage.model.vo;

public class MusicList {

	private int musicNo;
	private String albumTitle;
	private String musicTitle;
	private String artistName;
	private String musicGenre;
	private String keywordName;

	public MusicList() {

	}

	public MusicList(int musicNo, String albumTitle, String musicTitle, String artistName, String musicGenre,
			String keywordName) {
		super();
		this.musicNo = musicNo;
		this.albumTitle = albumTitle;
		this.musicTitle = musicTitle;
		this.artistName = artistName;
		this.musicGenre = musicGenre;
		this.keywordName = keywordName;
	}

	public int getMusicNo() {
		return musicNo;
	}

	public void setMusicNo(int musicNo) {
		this.musicNo = musicNo;
	}

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	public String getMusicTitle() {
		return musicTitle;
	}

	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getMusicGenre() {
		return musicGenre;
	}

	public void setMusicGenre(String musicGenre) {
		this.musicGenre = musicGenre;
	}

	public String getKeywordName() {
		return keywordName;
	}

	public void setKeywordName(String keywordName) {
		this.keywordName = keywordName;
	}

	@Override
	public String toString() {
		return "MusicList [musicNo=" + musicNo + ", albumTitle=" + albumTitle + ", musicTitle=" + musicTitle
				+ ", artistName=" + artistName + ", musicGenre=" + musicGenre + ", keywordName=" + keywordName + "]";
	}

}
