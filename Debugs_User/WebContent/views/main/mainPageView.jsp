<%@ page import="java.util.ArrayList, com.debugs.userPage.mainPage.model.vo.Playlist, com.debugs.userPage.mainPage.model.vo.MusicArtistAlbum, com.debugs.musiclist.model.vo.*, com.debugs.common.model.vo.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="true"%>

<%
	ArrayList<MusicArtistAlbum> list1 = (ArrayList<MusicArtistAlbum>)request.getAttribute("list");
	ArrayList<Playlist> pList = (ArrayList<Playlist>)request.getAttribute("pList");
	ArrayList<MusicArtistAlbum> rList = (ArrayList<MusicArtistAlbum>)request.getAttribute("rList");
	
	ArrayList<Music> music = (ArrayList<Music>)request.getAttribute("music");
	ArrayList<Like> like = (ArrayList<Like>)request.getAttribute("like");
	// String chart = (String)request.getAttribute("chart");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEBUGS</title>
<link rel="stylesheet" href="resources/css/media.css"/>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
    <script src="https://kit.fontawesome.com/df4edac511.js" crossorigin="anonymous"></script> <!-- 폰트어썸 -->
    <link rel='stylesheet' href='https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css'>
    <link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
</head>
<body>

	<%@include file="/views/common/headerView.jsp" %>

	<!-- 메인화면구현 -->
	
	
	
    <main class="main-wrap" style="height: fit-content;">

	<div class="main-contents">
            <div class="main-contents-wrap">
                <!-- 슬라이드 1번 페이지 최신음악 -->
                <div class="main1 content1">

                    <!-- 수정 : 내부 조금 올려서 정렬하고싶다-->
                    <div id="latestMusic">
                        <div class="content1Title">
                            <h2>최신음악</h2>
                        </div>
						<table class="latestMusic_table">
							<%if(list1 != null) { %>
							<!-- 보일 화면 -->
							
									<tr>
										
										<%for(int i = 0; i < 5; i++) {%>
										
										<td>
											<div>
											<div class="content1_img_inf img1_play_btn">
		
												<a href="#">
													<img src="<%= contextPath %><%= list1.get(i).getAlbumImg() %>">
													<button type="button" name="play_btn" class="play_btn"
                                                        style="background-color: transparent; border:none" onclick="addCurrentPlayList(<%= list1.get(i).getMusicNo() %>);">
                                                        <img src="<%= contextPath %>/resources/img/common/흰색동그라미플레이버튼.png" style="width:25px; height:25px;">
                                                    </button>
												
												</a>
												<div class="latestMusic_inf">
													<a href="goSong.me?mno=<%= list1.get(i).getMusicNo() %>"> <span class="latestMusic_inf_title"><%=list1.get(i).getMusicTitle() %></span></a><br>
                                     			  	<a href="search.li?keyword=<%= list1.get(i).getArtistName() %>"> <span class="latestMusic_artist"><%= list1.get(i).getArtistName() %></span></a>
												</div>
											</div>
											</div>
										</td>
										
										<%} %>
										
									</tr>
									<tr>
										<%for(int i = 5; i < list1.size(); i++) {%>
										<td>
											<div class="content1_img_inf img1_play_btn">
		
												<a href="#">
													<img src="<%= contextPath %><%= list1.get(i).getAlbumImg() %>">
													<button type="button" name="play_btn" class="play_btn"
                                                        style="background-color: transparent; border:none" onclick="addCurrentPlayList(<%= list1.get(i).getMusicNo() %>);">
                                                        <img src="<%= contextPath %>/resources/img/common/흰색동그라미플레이버튼.png" style="width:25px; height:25px;">
                                                    </button>
												</a>
												<div class="latestMusic_inf">
													<a href="goSong.me?mno=<%= list1.get(i).getMusicNo() %>"> <span class="latestMusic_inf_title"><%=list1.get(i).getMusicTitle() %></span></a><br>
                                     			  	<a href="search.li?keyword=<%= list1.get(i).getArtistName() %>"> <span class="latestMusic_artist"><%= list1.get(i).getArtistName() %></span></a>
												</div>
											</div>
										</td>
										<%} %>
									</tr>
									
							<%} %>
							

						</table>

					</div>

                </div>

		<!-- 두번째 배너 -->
                <div class="main1 content2">
                    <div class="content2-wrap">
                        <br>
                        <div class="content2_title_wrap">
                            <h2 class="content2_title">추천<br>플레이리스트</h2>
                        </div>
                        <div id="recommend_pl">

                            <table id="recommend_pl_content">
                                <tr>
                                <%for(int i = 0; i < 3; i++) {%>
                                    <td>
                                        <div>
                                            <div class="img_play_btn">
                                                <a href="detail.pl?plno=<%= pList.get(i).getPlaylistNo() %>">
                                                    <img src="<%= contextPath %>/resources/img/album_pic/<%= pList.get(i).getPlaylistTh()%>">
                                                </a>
                                                    <button type="button" name="play_btn" class="play_btn"
                                                        style="background-color: transparent; border:none" onclick="addCurrentPlayListAll(<%=pList.get(i).getPlaylistNo() %>)"><img
                                                            src="<%= contextPath %>/resources/img/common/흰색동그라미플레이버튼.png" style="width:30px; height:30px;"></button>
                                            </div>
                                            <!-- 수정!!! 긴 제목일 경우 줄바꿈 설정 추가 필욛-->
                                            <div class="recommend_pl_title">
                                               <a href="detail.pl?plno=<%= pList.get(i).getPlaylistNo() %>"><span><%=pList.get(i).getPlaylistSubject() %></span></a>
                                            </div>
                                        </div>
                                    </td>
                                    <% } %>
                                </tr>
                                <tr>
                                	<%for(int i = 3; i < pList.size(); i++) {%>
                                    <td>
                                        <div>
                                        
                                            <div class="img_play_btn">
                                                <a href="javascript:void(0);">
                                                    <img src="<%= contextPath %>/resources/img/album_pic/<%= pList.get(i).getPlaylistTh()%>">
                                                    <button type="button" name="play_btn" class="play_btn"
                                                        style="background-color: transparent; border:none" onclick="addCurrentPlayListAll(<%=pList.get(i).getPlaylistNo() %>)"><img
                                                            src="<%= contextPath %>/resources/img/common/흰색동그라미플레이버튼.png" style="width:30px; height:30px;"></button>
                                                </a>
                                            </div>
                                            <a href=""><span><%=pList.get(i).getPlaylistSubject() %></span></a><br>
                                        </div>
                                    </td>
                            
                                    <%} %>
                                </tr>


                            </table>

                        </div>


                    </div>

                </div>
                
                <div class="main1 content3">

                    <div class="recommend_music_wrap">
                        <div class="recommend_music_title">
                            <div class="recommend_music_title1">
                                <span class="content3_realtitle">
                                    추천음악
                                </span>
                            </div>
                            <div class="recommend_music_title2 play_all_recommend_music">
                                <button type="button" onclick="playRecommend();" style="background-color: transparent;">
                                    <img
                                          src="<%= contextPath %>/resources/img/common/흰색꽉찬재생버튼.png"
                                          style="width:35px; height:35px;">
                                   <!-- 이미지 바꿀꺼임 -->
                                </button>
                            </div>
                        </div>
                        <div class="recommend_music_wrap">

                            <div class="content3_music_list1">
                            
                            <% for ( MusicArtistAlbum r : rList ) {%>
                              <div class="content3_img_wrap">
   		                       	<input type="hidden" value="<%=r.getMusicNo() %>" class="hidden-music-no">
                                <div class="content3_img_inf">
                            
                                    <a href="javascript:void(0);">
                                        <img src="<%= contextPath %><%= r.getAlbumImg() %>">
                                         <button type="button" name="play_btn" class="play_btn"
                                                        style="background-color: transparent; border:none" onclick="addCurrentPlayList(<%= r.getMusicNo() %>);" ><img
                                                            src="<%= contextPath %>/resources/img/common/흰색동그라미플레이버튼.png" style="width:25px; height:25px;"></button>
                                    </a>

                                </div>
                                <div class="recommend_music1">
                                    <a href="goSong.me?mno=<%= r.getMusicNo() %>"><span class="recomentdMusic_inf_title"><%=r.getMusicTitle() %></span></a>
                                    <a href="search.li?keyword=<%= r.getArtistName() %>"><span class="recomentdMusic_artist"><%= r.getArtistName() %></span></a>
                                </div>
                            </div>

							<%} %>


	
                          
                            
                            
                            
                            

                                </div> 

                            </div>




                        </div>


                    </div>




                </div>
            </div>
        </div>

        <!-- 탑100 영역 -->

        <div class="main-contents2 main2">
            <div style="height:fit-content; width: 1000px; margin:0 auto; margin-top:6%;">
            <div class="music_list outer" style="padding-bottom:40px;">
				<table>
	           	 <thead>
	                <tr>
	                    <th width="10"><input type="checkbox" name="music_list" id="all_check"></th>
	                    <th width="80" class="rank">순위</th>
	                    <th colspan="2" class="table_left">곡 앨범</th>
	                    <th width="180" class="table_left">아티스트</th>
	                    <th width="60">재생</th>
	                    <th width="60">담기</th>
	                    <th width="60">좋아요</th>
	                </tr>
	            </thead>
	           	 	<% if ( !music.isEmpty() ) { %>
		            	<% for ( int i = 0 ; i < 5 ; i ++ ) { %>
		    	       		<tr>
				                <td>
				                	<input type="checkbox" name="music_list" id="music_list" value="<%= music.get(i).getMusicNo() %>">
				                </td>
				                <td class="rank"><%= i+1 %></td>
			                	<td width="60">
				                	<a href="goAlbum.me?ano=<%= music.get(i).getAlbumNo() %>">
					                	<img src="<%= contextPath %>/resources/img/album_pic/<%= music.get(i).getAlbumChangename() %>" width="60" height="60" style="border-radius: 10px;">
				                	</a>
			                	</td>
				                
				                <td class="table_left">
				                	<a href="goSong.me?mno=<%= music.get(i).getMusicNo() %>"><span class="music_title"><%= music.get(i).getMusicTitle() %></span><br></a>
				                	<a href="goAlbum.me?ano=<%= music.get(i).getAlbumNo() %>"><span class="album_title"><%= music.get(i).getAlbumTitle() %></span></a>
			                	</td>
				                <td class="table_left">
				                	<span class="artist_name"><%= music.get(i).getArtistName() %></span>
			                	</td>
				                <td class="music_list_icon">
				                	<img src="resources/img/musiclist/play_button.svg" onclick="addCurrentPlayList(<%= music.get(i).getMusicNo() %>)">
			                	</td>
				                <td class="music_list_icon">
				                	<img src="resources/img/musiclist/folder_button.png" onclick="myListAdd(<%= music.get(i).getMusicNo() %>);">
				                </td>
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


            <div class="move_to_top100" style="padding-bottom: 20px;">
                <button type="button"
                    style="background-color: transparent; border: none; height:32px; width: 100%; display: flex; justify-content: center;">
                    <a href="chart.page?chart=TOP 100 차트"">
                        <img src="resources/img/common/세로점3.svg" style="width:20px;">
                    </a>
                </button>
            </div>
            </div>

        </div>

<br><br><br>














        <script>
            $(document).ready(function () {
                $('.main-contents-wrap').slick({
                    dots: true, //스크롤바 아래 점으로 페이지네이션 여부
                    arrows: true, // 옆으로 이동하는 화살표 표시 여부
                    autoplay: false, // 자동스크롤 ///// true로 하면 자동자동 ****변경 예정****
                    autoplaySpeed: 2000, // 자동스크롤 시간
                    pauseOnHover: true, // 마우스호버시 자동스크롤 멈춤
                    prevArrow: "<button type='button' class='slick-arrow slick-prev'> </button>",
                    nextArrow: "<button type='button' class='slick-arrow slick-next'> </button>",
                    draggable: true, // 드래그 가능 여부

                });
            });
        </script>








    </main>
    
    
    <%@include file="/views/common/footerView.jsp" %>
    <%@include file="/views/musicPlayer/playerView.jsp" %>

	<script type="text/javascript">
      $.noConflict();
	</script>


</body>
</html>