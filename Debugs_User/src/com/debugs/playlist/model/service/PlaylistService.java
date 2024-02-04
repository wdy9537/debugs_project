package com.debugs.playlist.model.service;

import static com.debugs.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.debugs.musiclist.model.dao.MusiclistDao;
import com.debugs.playlist.model.dao.PlaylistDao;
import com.debugs.playlist.model.vo.Playlist;
import com.debugs.playlist.model.vo.PlaylistTrack;

public class PlaylistService {

	// 플레이리스트 상세화면 보기 (1개) (플레이리스트 넘버 확인)
	public Playlist playlistDetailPageView(int playlistNo) {
		Connection conn = getConnection();
		Playlist pl = new PlaylistDao().playlistDetailPageView(conn, playlistNo);
		close(conn);
		return pl;
		
	}
	
	// 플레이리스트 트랙 넘버 배열로 가져오기 (플레이리스트 넘버 확인)
	public ArrayList<PlaylistTrack> playlistTrackSelect(int playlistNo) {
		Connection conn = getConnection();
		ArrayList<PlaylistTrack> trackList = new PlaylistDao().playlistTrackSelect(conn, playlistNo);
		close(conn);
		return trackList;
	}
	
	// 전체 재생을 위해 해당 플레이리스트 전곡을 현재 재생에 삽입 (플레이리스트 트랙 넘버 확인)
	public int insertAllPlaylist(int userNo, int playlistNo, String type) {
		Connection conn = getConnection();
		int result = new PlaylistDao().insertAllPlaylist(conn, userNo, playlistNo, type);
		
		if ( result > 0 ) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	// DB에서 플레이리스트 추천(랜덤)으로 뽑아서 배열에 담기
	public ArrayList<Playlist> selectRecommnedPlaylist() {
		Connection conn = getConnection();
		ArrayList<Playlist> list = new PlaylistDao().selectRecommnedPlaylist(conn);
		close (conn);
		return list;
	}
	
	// 현재 선택된 플레이리스트를 기존의 플레이리스트로 복사하기
	
	public int copyPlaylist(int plNo, int copyPlNo) {
		Connection conn = getConnection();
		
		int result = new PlaylistDao().copyPlaylist(conn, plNo, copyPlNo);
		
		if ( result > 0 ) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	
	
	
	
}
