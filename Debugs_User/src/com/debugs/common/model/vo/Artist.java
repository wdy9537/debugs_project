package com.debugs.common.model.vo;

public class Artist {
	private int artistNo;
	private String artistName;
	
	private String albumChangename;
	
	public Artist() {
		
	}
	
	public Artist(int artistNo, String artistName) {
		super();
		this.artistNo = artistNo;
		this.artistName = artistName;
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
	@Override
	public String toString() {
		return "Artist [artistNo=" + artistNo + ", artistName=" + artistName + "]";
	}

	public String getAlbumChangename() {
		return albumChangename;
	}

	public void setAlbumChangename(String albumChangename) {
		this.albumChangename = albumChangename;
	}
	
}
