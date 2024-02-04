package com.debugs.adminPage.model.vo;

public class Album {

	private int albumNo;
	private String albumTitle;
	private String albumPic;
	private String albumType;
	private String albumDate;
	private int artistNo;
	private String albumChangeName;
	private String albumPicPath;
	private String artistName;

	public Album() {

	}

	public Album(int albumNo, String albumTitle) {
		super();
		this.albumNo = albumNo;
		this.albumTitle = albumTitle;
	}

	public Album(int albumNo, String albumTitle, String albumPic, String albumType, String albumDate, int artistNo,
			String albumChangeName, String albumPicPath, String artistName) {
		super();
		this.albumNo = albumNo;
		this.albumTitle = albumTitle;
		this.albumPic = albumPic;
		this.albumType = albumType;
		this.albumDate = albumDate;
		this.artistNo = artistNo;
		this.albumChangeName = albumChangeName;
		this.albumPicPath = albumPicPath;
		this.artistName = artistName;
	}

	public Album(int albumNo, String albumTitle, String albumPic, String albumType, String albumDate, int artistNo,
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

	public String getAlbumDate() {
		return albumDate;
	}

	public void setAlbumDate(String albumDate) {
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

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	@Override
	public String toString() {
		return "Album [albumNo=" + albumNo + ", albumTitle=" + albumTitle + ", albumPic=" + albumPic + ", albumType="
				+ albumType + ", albumDate=" + albumDate + ", albumChangeName=" + albumChangeName + ", albumPicPath="
				+ albumPicPath + ", artistName=" + artistName + "]";
	}

}
