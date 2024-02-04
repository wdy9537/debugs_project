<%@ page import = "java.util.ArrayList, 
					com.debugs.playlist.model.vo.PlaylistTrack, 
					com.debugs.playlist.model.vo.Playlist,
					com.debugs.musiclist.model.vo.*" %>
<%
	Playlist pl = (Playlist)request.getAttribute("pl");
	ArrayList<PlaylistTrack> trackList = (ArrayList<PlaylistTrack>)request.getAttribute("trackList");
	ArrayList<Like> like = (ArrayList<Like>)request.getAttribute("like");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>플레이리스트 상세화면</title>
<link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
</head>
<body>

<%@ include file="/views/common/headerView.jsp" %>
	<div class="outer"></div>
	<!-- 플레이리스트 기본정보 -->
	<div class="outer">
        <div class="playlist_list_detail">
        	<input type="hidden" id="playlist_no" value="<%= pl.getPlaylistNo() %>">
            <div class="playlist_list_img">
            <%	
	            int height1 = 0; int height2 = 0; int height3 = 0; int height4 = 0; 
	        	int width1 = 0; int width2 = 0; int width3 = 0; int width4 = 0;
	        	String th1 = "";

            	if ( pl.getTh4() != null ) { height1=50; height2=50; height3=50; height4=50; width1=50; width2=50; width3=50; width4=50; } 
            	else if ( pl.getTh3() != null ) { height1=50; height2=50; height3=50; height4=0; width1=50; width2=50; width3=100; width4=0; }
            	else if ( pl.getTh2() != null ) { height1=100; height2=100; height3=0; height4=0; width1=50; width2=50; width3=0; width4=0; }
            	else { height1=100; height2=0; height3=0; height4=0; width1=100; width2=0; width3=0; width4=0; }
            %>
            
              <% if ( pl.getTh1() == null ) { th1 = "playlist_pic/"+pl.getPlaylistTh(); } else { th1 = "album_pic/"+pl.getTh1(); } %>
            
            	<div style="background-image: url(resources/img/<%= th1 %>);height: <%= height1 %>%;width: <%= width1 %>%;"></div>
            	<div style="background-image: url(resources/img/album_pic/<%= pl.getTh2() %>);height: <%= height2 %>%;width: <%= width2 %>%;"></div>
            	<div style="background-image: url(resources/img/album_pic/<%= pl.getTh3() %>);height: <%= height3 %>%;width: <%= width3 %>%;"></div>
            	<div style="background-image: url(resources/img/album_pic/<%= pl.getTh4() %>);height: <%= height4 %>%;width: <%= width4 %>%;"></div>
            	
                <%-- <img src="<%= contextPath %>/resources/img/playlist_pic/<%= pl.getPlaylistTh() %>.jpg"> --%>
            </div>
            <div class="playlist_list_comment">
                <span class="title_name"><%= pl.getPlaylistSubject() %></span> <br><br>
                <span><%= pl.getUserId() %></span> | <span>총 <%= trackList.size() %> 곡</span> <br><br>
                <div>
                	<!-- 클릭시 현재 플레이리스트의 모든 곡이 현재 재생 목록에 그대로 or 랜덤으로 추가됨 -->
                    <button onclick="playRecommend();">전체재생</button>
                    <button onclick="playShuffle();">셔플재생</button>
                </div>
            </div>
        </div>
    </div>
    
    <!-- 트랙리스트 -->
    <div class="outer music_list">
        <div class="title_name">노래 ></div>
        <table>
            <thead>
                <tr>
                    <th width="10"><input type="checkbox" name="music_list" id="all_check"></th>
                    <th width="80">번호</th>
                    <th colspan="2" class="table_left">곡 앨범</th>
                    <th width="180" class="table_left">아티스트</th>
                    <th width="60">재생</th>
                    <th width="60">삭제</th>
                    <th width="60">좋아요</th>
                </tr>
            </thead>
            <% if ( !trackList.isEmpty() ) { %>
            	<% for ( int i=0; i<trackList.size() ; i++ ) { %>
		            <tr>
		                <td><input type="checkbox" name="music_list" id="music_list" class="hidden-music-no" value="<%= trackList.get(i).getMusicNo() %>"></td>
		                <td><%= i+1 %></td>
		                <td width="60">
	                		<img src="<%= contextPath %>/resources/img/album_pic/<%= trackList.get(i).getAlbumPic() %>" width="60" height="60" style="border-radius: 10px;">
	                	</td>
		                <td class="table_left">
		                <span class="music_title"><%= trackList.get(i).getMusicTitle() %></span><br>
		                <span class="album_title"><%= trackList.get(i).getAlbumTitle() %></span></td>
		                <td class="table_left"><span class="artist_name"><%= trackList.get(i).getArtistName() %></span></td>
		                <td class="music_list_icon"><img src="resources/img/musiclist/play_button.svg" onclick="addCurrentPlayList(<%= trackList.get(i).getMusicNo() %>);"></td>
		                 
		                <td class="music_list_icon delete_music"><img src="resources/img/musiclist/delete_button.png"></td>
		                
		                <% if ( like.toString().contains("musicNo="+trackList.get(i).getMusicNo() ) ) { %>
		              		<td class="music_list_icon music_like"><img src="resources/img/musiclist/like_button_on.png"></td> 
	               		<% } else { %>
		               		<td class="music_list_icon music_like"><img src="resources/img/musiclist/like_button.svg"></td>
	               		<% } %> 
			                
		            </tr>
	            <% } %>
            <% } else { %>
            <tr>
            	<td colspan=8>등록된 곡 정보가 없습니다</td>
            </tr>
            <% } %>
        </table>
    </div>
    
    
    
    <%@ include file="/views/common/footerView.jsp" %>
    <%@ include file="/views/musicPlayer/playerView.jsp" %>
    
</body>
</html>

