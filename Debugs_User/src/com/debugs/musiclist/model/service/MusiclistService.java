package com.debugs.musiclist.model.service;

import static com.debugs.common.JDBCTemplate.close;
import static com.debugs.common.JDBCTemplate.commit;
import static com.debugs.common.JDBCTemplate.getConnection;
import static com.debugs.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.debugs.musiclist.model.dao.MusiclistDao;
import com.debugs.musiclist.model.vo.Like;
import com.debugs.playlist.model.vo.Playlist;

public class MusiclistService {
	// 체크박스에 클릭한 음원을 현재 플레이리스트에 삽입 (음원 번호 확인)
	public int listenPlaylist(int userNo, int musicNo) {
		Connection conn = getConnection();
		int result = new MusiclistDao().listenPlaylist(conn, userNo, musicNo);
		
		if ( result > 0 ) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	// 현재 회원이 가지고 있는 플레이리스트 가져오기 (회원 번호 확인)
	public ArrayList<Playlist> showPlayList(int userNo) {
		Connection conn = getConnection();
		ArrayList<Playlist> list = new MusiclistDao().showPlayList(conn, userNo);
		close (conn);
		return list;
	}
	
	// 현재 회원의 새 플레이리스트 추가하기 (회원 번호, 플레이리스트 제목 확인)
	public int addPlaylist(int userNo, String plSubject) {
		Connection conn = getConnection();
		
		int result = new MusiclistDao().addPlaylist(conn, userNo, plSubject);
		
		if ( result > 0 ) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	};
	
	// 현재 체크된 곡들을 선택한 플레이리스트에 추가하기 (회원번호, 음원번호, 플리번호 필요)
	public int insertMyPlaylist(int musicNo, int plNo) {
		Connection conn = getConnection();
		
		int result = new MusiclistDao().insertMyPlaylist(conn, musicNo, plNo);
		
		if ( result > 0 ) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	// 선택된 음악을 해당 플레이리스트에서 삭제하기 (음원번호, 플리번호 필요)
	public int deletePlaylist(int musicNo, int plNo) {
		Connection conn = getConnection();
		
		int result = new MusiclistDao().deletePlaylist(conn, musicNo, plNo);
		
		if ( result > 0 ) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	// 좋아요 여부 확인 후 추가 or 삭제 (음원번호, 회원번호 필요)
	public int musicLike(int musicNo, int userNo) {
		Connection conn = getConnection();
		
		int result = new MusiclistDao().musicLike(conn, musicNo, userNo);
		
		if ( result > 0 ) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	// 현재 로그인한 회원의 음악 좋아요 여부 확인하기 (회원번호 필요)
	public ArrayList<Like> checkMusicLikeList(int userNo){
		Connection conn = getConnection();
		ArrayList<Like> like = new MusiclistDao().checkMusicLikeList(conn, userNo);
		close(conn);
		return like;	
	}
	
	
	
	
	
	
}
