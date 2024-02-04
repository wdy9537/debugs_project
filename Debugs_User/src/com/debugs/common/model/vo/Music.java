package com.debugs.common.model.vo;

public class Music {
	private int musicNo;
	private int albumNo;
	private String musicDetail;
	private String musicGenre;
	private String musicTime;
	private String musicLyrics;
	private String musicFile;
	private String musicTitle;
	
	private String albumPic;
	private String albumTitle;
	private String albumChangename;
	private String artistName; 
	
	private int rank;

	public Music() {
		
	}

	public Music(int musicNo, int albumNo, String musicDetail, String musicGenre, String musicTime, String musicLyrics,
			String musicFile, String musicTitle) {
		super();
		this.musicNo = musicNo;
		this.albumNo = albumNo;
		this.musicDetail = musicDetail;
		this.musicGenre = musicGenre;
		this.musicTime = musicTime;
		this.musicLyrics = musicLyrics;
		this.musicFile = musicFile;
		this.musicTitle = musicTitle;
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

	@Override
	public String toString() {
		return "Music [musicNo=" + musicNo + ", albumNo=" + albumNo + ", musicDetail=" + musicDetail + ", musicGenre="
				+ musicGenre + ", musicTime=" + musicTime + ", musicLyrics=" + musicLyrics + ", musicFile=" + musicFile
				+ ", musicTitle=" + musicTitle + "]";
	}

	public String getAlbumPic() {
		return albumPic;
	}

	public void setAlbumPic(String albumPic) {
		this.albumPic = albumPic;
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

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getAlbumChangename() {
		return albumChangename;
	}

	public void setAlbumChangename(String albumChangename) {
		this.albumChangename = albumChangename;
	}

	public Music(int musicNo, String albumTitle, String musicTime, String musicGenre, String musicLyrics) {
		super();
		this.musicNo = musicNo;
		this.musicGenre = musicGenre;
		this.musicTime = musicTime;
		this.musicLyrics = musicLyrics;
		this.albumTitle = albumTitle;
	}
}
