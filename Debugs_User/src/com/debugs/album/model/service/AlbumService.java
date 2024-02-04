package com.debugs.album.model.service;

import static com.debugs.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.debugs.album.model.dao.AlbumDao;
import com.debugs.album.model.vo.Album;
import com.debugs.album.model.vo.Reply;
import com.debugs.member.model.vo.Artist;
import com.debugs.song.model.vo.Music;

public class AlbumService {

	public int insertComment(Reply r, int albumNo) {
		
		Connection conn = getConnection();
		
		int result = new AlbumDao().insertComment(conn, r, albumNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	public Album selectAlbumList (int albumNo) {
		Connection conn = getConnection();
		
		Album a  = new AlbumDao().selectAlbumList(conn, albumNo);
		
		close(conn);
		
		return a;
	}
	public Artist selectArtistList (int albumNo) {
		Connection conn = getConnection();
		
		Artist ar  = new AlbumDao().selectArtistList(conn, albumNo);
		
		close(conn);
		
		return ar;
	}
	
	public ArrayList<Music> selectMusicList (int albumNo) {
		Connection conn = getConnection();
		
		ArrayList<Music> list  = new AlbumDao().selectMusicList(conn, albumNo);
		
		close(conn);
		
		return list;
	}
	public ArrayList<Reply> selectReplyList (int albumNo) {
		Connection conn = getConnection();
		
		ArrayList<Reply> list2  = new AlbumDao().selectReplyList(conn, albumNo);
		
		close(conn);
		
		return list2;
	}
	
	public ArrayList<Music> selectMusicCount(int albumNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Music> mlist = new AlbumDao().selectMusicCount(conn, albumNo);
		
		close(conn);
		
		return mlist;
		
	
	}
	
	
	public ArrayList<Reply> selectCommentList(int albumNo) {
		Connection conn = getConnection();
		
		ArrayList<Reply> list = new AlbumDao().selectCommentList(conn, albumNo);
		
		close(conn); 
		
		return list;
	}
	
	
	
}
