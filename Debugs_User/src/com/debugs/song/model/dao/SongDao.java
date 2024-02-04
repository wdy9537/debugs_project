package com.debugs.song.model.dao;

import static com.debugs.common.JDBCTemplate.*;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.debugs.album.model.vo.Album;
import com.debugs.cs.model.vo.Notice;
import com.debugs.member.model.vo.Artist;
import com.debugs.song.model.vo.Keyword;
import com.debugs.song.model.vo.Music;

public class SongDao {
	private Properties prop = new Properties();
	
	public SongDao() {
		String fileName = SongDao.class.getResource("/sql/song/song-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Music selectMusicList(Connection conn, int musicNo){
		Music m = null;
	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMusicList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, musicNo);
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				 m = new Music(rset.getInt("MUSIC_NO"),
						 	  rset.getString("MUSIC_TITLE"),
	                          rset.getString("MUSIC_TIME"),
	                          rset.getString("MUSIC_GENRE"),
	                          rset.getString("MUSIC_LYRICS"));
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
		
	}
	
public Album selectAlbumList(Connection conn, int musicNo){
	Album a = null;
		// SELECT문 => 여러행 => ResultSet => ArrayList
	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAlbumList");
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, musicNo);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
			a = new Album();
			
			a.setAlbumTitle(rset.getString("ALBUM_TITLE"));
			a.setAlbumChangeName(rset.getString("ALBUM_CHANGENAME"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return a;
		
	}

public ArrayList<Keyword> selectKeywordList(Connection conn, int musicNo){
	
	// SELECT문 => 여러행 => ResultSet => ArrayList
	ArrayList<Keyword> list = new ArrayList();
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	String sql = prop.getProperty("selectKeywordList");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, musicNo);
		
		rset = pstmt.executeQuery();
		
		while(rset.next()) {
		 Keyword k = new Keyword(rset.getString("KEYWORD_NAME"));
		 list.add(k);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	
	return list;
	
}

public Artist selectArtistList(Connection conn,int musicNo){
	
	// SELECT문 => 여러행 => ResultSet => ArrayList
	Artist ar = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	String sql = prop.getProperty("selectArtistList");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, musicNo);
		
		rset = pstmt.executeQuery();
		
		if (rset.next()) {
		ar = new Artist(rset.getString("ARTIST_NAME"));
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	return ar;
}

public String changeMusicLike(Connection conn, String mno, int userNo) {
    String result = "error";
    PreparedStatement pstmt = null;
    String sql = prop.getProperty("insertMusicLike");
    int result2 = 0;
    
    try {
       pstmt = conn.prepareStatement(sql);
       pstmt.setInt(1, userNo);
       pstmt.setString(2, mno);
       result = "like";
       result2 = pstmt.executeUpdate();
       
    } catch (SQLException e) {
       System.out.println("에러발생");
       try {
          close(pstmt);
          pstmt = conn.prepareStatement(prop.getProperty("deleteMusicLike"));
          pstmt.setInt(1, userNo);
          pstmt.setString(2, mno);
          result= "cancel";
          result2 = pstmt.executeUpdate();
          
       } catch (SQLException e1) {
          e1.printStackTrace();
       } finally {
          close(pstmt);
       }
       
    } finally {
       close(pstmt);
    }
    
    return result2 == 0? "error" : result;
 }
}

