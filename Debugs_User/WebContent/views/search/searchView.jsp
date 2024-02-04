<%@ page import = "java.util.ArrayList, 
			com.debugs.common.model.vo.*,
			com.debugs.common.model.vo.Artist,  
			com.debugs.playlist.model.vo.*,
			com.debugs.musiclist.model.vo.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Artist> artist = (ArrayList<Artist>)request.getAttribute("artist");
	ArrayList<Album> album = (ArrayList<Album>)request.getAttribute("album");
	ArrayList<Music> music = (ArrayList<Music>)request.getAttribute("music");
	ArrayList<Like> like = (ArrayList<Like>)request.getAttribute("like");
	ArrayList<Playlist> plList = (ArrayList<Playlist>)request.getAttribute("pl");
	String keyword = (String)request.getAttribute("keyword");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색결과화면</title>
<link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
</head>
<body>
<%@ include file="/views/common/headerView.jsp" %>

<div class="title_name outer">'<%= keyword %>' 검색결과</div>

	<!-- 추천 플레이리스트 -->
    <div class="playlist_list_outer outer" style="margin-top:-40px;">
    	<%  for ( int i = 0 ; i < 2 ; i ++ ) {  %>
    		<div class="playlist_list">
    			<input type="hidden" type="hidden" id="playlist_no" value="<%= plList.get(i).getPlaylistNo() %>">
	            <div class="playlist_list_img">
	            <%	
		            int height1 = 0; int height2 = 0; int height3 = 0; int height4 = 0; 
		        	int width1 = 0; int width2 = 0; int width3 = 0; int width4 = 0;
		        	String th1 = "";
	
	            	if ( plList.get(i).getTh4() != null ) { height1=50; height2=50; height3=50; height4=50; width1=50; width2=50; width3=50; width4=50; } 
	            	else if ( plList.get(i).getTh3() != null ) { height1=50; height2=50; height3=50; height4=0; width1=50; width2=50; width3=100; width4=0; }
	            	else if ( plList.get(i).getTh2() != null ) { height1=100; height2=100; height3=0; height4=0; width1=50; width2=50; width3=0; width4=0; }
	            	else { height1=100; height2=0; height3=0; height4=0; width1=100; width2=0; width3=0; width4=0; }
	            %>
	            
	              <% if ( plList.get(i).getTh1() == null ) { th1 = "playlist_pic/"+plList.get(i).getPlaylistTh(); } else { th1 = "album_pic/"+plList.get(i).getTh1(); } %>
            
            	<div style="background-image: url(resources/img/<%= th1 %>);height: <%= height1 %>%;width: <%= width1 %>%;"></div>
            	<div style="background-image: url(resources/img/album_pic/<%= plList.get(i).getTh2() %>);height: <%= height2 %>%;width: <%= width2 %>%;"></div>
            	<div style="background-image: url(resources/img/album_pic/<%= plList.get(i).getTh3() %>);height: <%= height3 %>%;width: <%= width3 %>%;"></div>
            	<div style="background-image: url(resources/img/album_pic/<%= plList.get(i).getTh4() %>);height: <%= height4 %>%;width: <%= width4 %>%;"></div>
            	
	            	<%-- <img src="<%= contextPath %>/resources/img/playlist_pic/<%= plList.get(i).getPlaylistTh() %>.jpg"> --%>
            	</div>
	            <div class="playlist_list_comment">
	                <span class="middle_title_name"><%= plList.get(i).getPlaylistSubject() %></span> <br><br>
	                <span><%= plList.get(i).getUserId() %></span> | <span>총 <%= plList.get(i).getCount() %> 곡</span> <br><br>
	                <div>
	                    <button onclick="insertMyPlaylist(<%= plList.get(i).getPlaylistNo() %>);">내 플리 추가</button>
	                    
	                </div>
	            </div>
	        </div>
    	<% } %>
    </div>
    
    <!-- 노래 검색 결과 -->
    <div class="music_list outer">
        <div class="title_name">노래 ></div>
        <table>
            <thead>
                <tr>
                    <th width="10"><input type="checkbox" name="music_list" id="all_check"></th>
                    <th width="80" class="rank">번호</th>
                    <th colspan="2" class="table_left">곡 앨범</th>
                    <th width="180" class="table_left">아티스트</th>
                    <th width="60">재생</th>
                    <th width="60">담기</th>
                    <th width="60">좋아요</th>
                </tr>
            </thead>
            	<% if ( !music.isEmpty() ) { %>
	            	<% for ( int i = 0 ; i < music.size(); i ++ ) { %>
    	       		<tr>
	                <td><input type="checkbox" name="music_list" id="music_list" value="<%= music.get(i).getMusicNo() %>"></td>
	                <td><%= i+1 %></td>
                	<td width="60">
	                	<img src="<%= contextPath %>/resources/img/album_pic/<%= music.get(i).getAlbumChangename() %>" width="60" height="60" style="border-radius: 10px;">
                	</td>
	                
	                <td class="table_left">
	                	<span class="music_title"><%= music.get(i).getMusicTitle() %></span><br>
	                	<span class="album_title"><%= music.get(i).getAlbumTitle() %></span>
                	</td>
	                <td class="table_left"><span class="artist_name"><%= music.get(i).getArtistName() %></span></td>
	                <td class="music_list_icon"><img src="resources/img/musiclist/play_button.svg" onclick="addCurrentPlayList(<%= music.get(i).getMusicNo() %>);"></td>
	                <td class="music_list_icon my_list"><img src="resources/img/musiclist/folder_button.png" onclick="myListAdd(<%= music.get(i).getMusicNo() %>);"></td>
	                
             		<% if ( like.toString().contains("musicNo="+music.get(i).getMusicNo() ) ) { %>
	              		<td class="music_list_icon music_like"><img src="resources/img/musiclist/like_button_on.png"></td> 
               		<% } else { %>
	               		<td class="music_list_icon music_like"><img src="resources/img/musiclist/like_button.svg"></td>
               		<% } %> 
	            </tr>
            	<% } %>
            <% } %>
        </table>
      </div>
      
      <!-- 앨범 검색 결과 -->
      <% if ( !album.isEmpty() ) { %>
			<div class="album_list_outer outer">
		        <div class="title_name">앨범 ></div>
		        <div class="album_list">
		        <% for ( int i = 0 ; i < album.size() ; i ++ ) { %>
			        <% if ( i > 2 ) { break; } else { %>
		        	<div>
		                <div class="album_cover">
			                <a href="goAlbum.me?ano=<%= album.get(i).getAlbumNo() %>">
			                    <img src="<%= contextPath %>/resources/img/album_pic/<%= album.get(i).getAlbumPic() %>">
		                    </a>
		                </div>
		                <div class="album_content">
		                    <span class="middle_title_name"><%= album.get(i).getAlbumTitle() %></span> <br>
		                    <span><%= album.get(i).getArtistName() %></span> | <span>총 <%= album.get(i).getCount() %> 곡</span> <br>
		                    <span><%= album.get(i).getAlbumDate() %> | <%= album.get(i).getAlbumGenre() %></span> <br><br>
		
		                    <div>
		                        <div class="music_list_icon"><img src="resources/img/musiclist/play_button.svg" title="재생목록추가"></div>
		                        <div class="music_list_icon" id="my_list"><img src="resources/img/musiclist/folder_button.png" title="플리추가"></div>
		                    </div>
		                </div>
		            </div>
			        <% } %>
		        <% } %>
		        </div>
		    </div>
		<% } %>
		
		<!-- 가수 검색 결과 -->
		<% if ( !artist.isEmpty() ) { %>
			<div class="artist_list_outer outer">
		        <div class="title_name">아티스트 ></div>
		        <div class="artist_list">
		        	<% for ( int i = 0 ; i < artist.size() ; i ++ ) { %>
			        	<% if ( i > 2 ) { break; } else { %>
		           		 <div>
			                <a href="search.li?keyword=<%= artist.get(i).getArtistName() %>">
				                <img src="<%= contextPath %>/resources/img/album_pic/<%= artist.get(i).getAlbumChangename() %>" class="artist_img">
				                <%= artist.get(i).getArtistName() %>
			                </a>
			                <div class="play" onclick="artistPlay(<%= artist.get(i).getArtistNo() %>)"></div>
		           		 </div>
		                <% } %>
		            <% } %>
		            <% if ( artist.size() == 2 ) { %>
		           	 <div></div>
		            <% } %>
		        </div>
		    </div>
	    <% } %>

<br><br>
	<%@ include file="/views/common/footerView.jsp" %>
    <%@ include file="/views/musicPlayer/playerView.jsp" %>
</body>
</html>