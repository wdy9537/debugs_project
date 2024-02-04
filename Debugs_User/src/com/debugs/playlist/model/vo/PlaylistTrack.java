package com.debugs.playlist.model.vo;

public class PlaylistTrack {
	private int trackNo;
	private int playlistNo;
	private int musicNo;
	
	private String albumPic;
	private String musicTitle;
	private String albumTitle;
	private String artistName;
	
	public PlaylistTrack(int trackNo, int playlistNo, int musicNo) {
		super();
		this.trackNo = trackNo;
		this.playlistNo = playlistNo;
		this.musicNo = musicNo;
	}
	
	public PlaylistTrack() {
		
	}
	
	public int getTrackNo() {
		return trackNo;
	}
	public void setTrackNo(int trackNo) {
		this.trackNo = trackNo;
	}
	public int getPlaylistNo() {
		return playlistNo;
	}
	public void setPlaylistNo(int playlistNo) {
		this.playlistNo = playlistNo;
	}
	public int getMusicNo() {
		return musicNo;
	}
	public void setMusicNo(int musicNo) {
		this.musicNo = musicNo;
	}
	@Override
	public String toString() {
		return "PlaylistTrack [trackNo=" + trackNo + ", playlistNo=" + playlistNo + ", musicNo=" + musicNo + "]";
	}

	public String getAlbumPic() {
		return albumPic;
	}

	public void setAlbumPic(String albumPic) {
		this.albumPic = albumPic;
	}

	public String getMusicTitle() {
		return musicTitle;
	}

	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
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

	// PlaylistDetailView의 트랙리스트에 필요한 생성자
	public PlaylistTrack(int trackNo, String albumPic, String musicTitle, String albumTitle, String artistName, int musicNo) {
		super();
		this.trackNo = trackNo;
		this.albumPic = albumPic;
		this.musicTitle = musicTitle;
		this.albumTitle = albumTitle;
		this.artistName = artistName;
		this.musicNo = musicNo;
	}
	
	
	
}
