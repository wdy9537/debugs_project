package com.debugs.userPage.mainPage.model.vo;

import java.util.Date;

public class Album {

	private int albumNo;
	private String albumTitle;
	private String albumPic;
	private String albumType;
	private Date albumDate;
	private int artistNo; // String으로 해야할까?
	private String albumChangeName;
	private String albumPicPath;

	public Album() {

	}

	public Album(int albumNo, String albumTitle, String albumPic, String albumType, Date albumDate, int artistNo,
			String albumChangeName, String albumPicPath) {
		super();
		this.albumNo = albumNo;
		this.albumTitle = albumTitle;
		this.albumPic = albumPic;
		this.albumType = albumType;
		this.albumDate = albumDate;
		this.artistNo = artistNo;
		this.albumChangeName = albumChangeName;
		this.albumPicPath = albumPicPath;
	}

	public int getAlbumNo() {
		return albumNo;
	}

	public void setAlbumNo(int albumNo) {
		this.albumNo = albumNo;
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

	public int getArtistNo() {
		return artistNo;
	}

	public void setArtistNo(int artistNo) {
		this.artistNo = artistNo;
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
		return "Album [albumNo=" + albumNo + ", albumTitle=" + albumTitle + ", albumPic=" + albumPic + ", albumType="
				+ albumType + ", albumDate=" + albumDate + ", artistNo=" + artistNo + ", albumChangeName="
				+ albumChangeName + ", albumPicPath=" + albumPicPath + "]";
	}

}
