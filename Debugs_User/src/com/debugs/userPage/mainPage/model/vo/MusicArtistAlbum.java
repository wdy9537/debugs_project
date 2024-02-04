package com.debugs.userPage.mainPage.model.vo;

import java.util.Date;

public class MusicArtistAlbum {

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

	private int artistNo;
	private String artistName;

	private String albumTitle;
	private String albumPic;
	private String albumType;
	private Date albumDate;
	private String albumChangeName;
	private String albumPicPath;
	private int musicLike;

	public int getMusicLike() {
		return musicLike;
	}

	public void setMusicLike(int musicLike) {
		this.musicLike = musicLike;
	}

	public MusicArtistAlbum() {

	}

	private String albumImg;

	public String getAlbumImg() {
		return albumImg;
	}

	public void setAlbumImg(String albumImg) {
		this.albumImg = albumImg;
	}

	public MusicArtistAlbum(int musicNo, int albumNo, String musicDetail, String musicGenre, String musicTime,
			String musicLyrics, String musicFile, String musicTitle, String musicChangeName, String musicPath,
			int artistNo, String artistName, String albumTitle, String albumPic, String albumType, Date albumDate,
			String albumChangeName, String albumPicPath) {
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
		this.artistNo = artistNo;
		this.artistName = artistName;
		this.albumTitle = albumTitle;
		this.albumPic = albumPic;
		this.albumType = albumType;
		this.albumDate = albumDate;
		this.albumChangeName = albumChangeName;
		this.albumPicPath = albumPicPath;
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

	public int getArtistNo() {
		return artistNo;
	}

	public void setArtistNo(int artistNo) {
		this.artistNo = artistNo;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	public String getAlbumPic() {
		return albumPic;
	}

	public void setAlbumPic(String albumPic) {
		this.albumPic = albumPic;
	}

	public String getAlbumType() {
		return albumType;
	}

	public void setAlbumType(String albumType) {
		this.albumType = albumType;
	}

	public Date getAlbumDate() {
		return albumDate;
	}

	public void setAlbumDate(Date albumDate) {
		this.albumDate = albumDate;
	}

	public String getAlbumChangeName() {
		return albumChangeName;
	}

	public void setAlbumChangeName(String albumChangeName) {
		this.albumChangeName = albumChangeName;
	}

	public String getAlbumPicPath() {
		return albumPicPath;
	}

	public void setAlbumPicPath(String albumPicPath) {
		this.albumPicPath = albumPicPath;
	}

	@Override
	public String toString() {
		return "MusicArtistAlbum [musicNo=" + musicNo + ", albumNo=" + albumNo + ", musicDetail=" + musicDetail
				+ ", musicGenre=" + musicGenre + ", musicTime=" + musicTime + ", musicLyrics=" + musicLyrics
				+ ", musicFile=" + musicFile + ", musicTitle=" + musicTitle + ", musicChangeName=" + musicChangeName
				+ ", musicPath=" + musicPath + ", artistNo=" + artistNo + ", artistName=" + artistName + ", albumTitle="
				+ albumTitle + ", albumPic=" + albumPic + ", albumType=" + albumType + ", albumDate=" + albumDate
				+ ", albumChangeName=" + albumChangeName + ", albumPicPath=" + albumPicPath + "]";
	}

}
