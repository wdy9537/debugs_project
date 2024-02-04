package com.debugs.common.model.vo;

import java.util.Date;

public class Album {
	private int albumNo;
	private String albumTitle;
	private String albumPic;
	private String albumType;
	private Date albumDate;
	private int artistNo;
	
	private String artistName;
	private String albumGenre;
	private int count;
	
	public Album() {
		
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

	public Album(int albumNo, String albumTitle, String albumPic, String albumType, Date albumDate, int artistNo) {
		super();
		this.albumNo = albumNo;
		this.albumTitle = albumTitle;
		this.albumPic = albumPic;
		this.albumType = albumType;
		this.albumDate = albumDate;
		this.artistNo = artistNo;
	}

	@Override
	public String toString() {
		return "Album [albumNo=" + albumNo + ", albumTitle=" + albumTitle + ", albumPic=" + albumPic + ", albumType="
				+ albumType + ", albumDate=" + albumDate + ", artistNo=" + artistNo + "]";
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getAlbumGenre() {
		return albumGenre;
	}

	public void setAlbumGenre(String albumGenre) {
		this.albumGenre = albumGenre;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}	
}
