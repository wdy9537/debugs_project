package com.debugs.song.model.service;

import static com.debugs.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.debugs.album.model.vo.Album;
import com.debugs.member.model.vo.Artist;
import com.debugs.song.model.dao.SongDao;
import com.debugs.song.model.vo.Keyword;
import com.debugs.song.model.vo.Music;

public class SongService {
	
	public Music selectMusicList(int musicNo){
		
		Connection conn = getConnection();
		
		Music m = new SongDao().selectMusicList(conn, musicNo);
		
		close(conn);
		
		return m;
	}
	public ArrayList<Keyword> selectKeywordList(int musicNo){
		
		Connection conn = getConnection();
		
		ArrayList<Keyword> list = new SongDao().selectKeywordList(conn, musicNo);
		
		close(conn);
		
		return list;
	}
	public Artist selectArtistList(int musicNo){
	
	Connection conn = getConnection();
	
	Artist ar = new SongDao().selectArtistList(conn, musicNo);
	
	close(conn);
	
	return ar;
}
	public Album selectAlbumList(int musicNo){
		
		Connection conn = getConnection();
		
		Album a = new SongDao().selectAlbumList(conn, musicNo);
		
		close(conn);
		
		return a;
	}
	
	
	  public String changeMusicLike(String mno, int userNo) {
	      Connection conn = getConnection();
	      String result = new SongDao().changeMusicLike(conn, mno, userNo);
	      close(conn);
	      return result;
	   }

}
