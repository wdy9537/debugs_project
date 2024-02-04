<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.ArrayList, com.debugs.song.model.vo.*, com.debugs.album.model.vo.Album, com.debugs.song.model.vo.*,
    com.debugs.song.model.vo.Keyword, com.debugs.song.model.vo.Music"
%>
<%
	Music m = (Music) request.getAttribute("m");
	ArrayList<Keyword> list = (ArrayList<Keyword>)request.getAttribute("list");
	Artist ar = (Artist) request.getAttribute("ar");
	Album a = (Album) request.getAttribute("a");
	LikeMusic maa = (LikeMusic) request.getAttribute("maa");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEBUGS</title>
<link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="resources/css/songPageCss.css">
</head>

<body>
<%@ include file="/views/common/headerView.jsp" %>
<div class="outbox">
    <div id="wholesong">
        <div>
            <div class="wholeinfo">
                <div class="albuminfo1">
                    <img src="<%= contextPath %>/resources/img/album_pic/<%= a.getAlbumChangeName() %>" id="albumcover">
                </div>
                <div class="albuminfo2">
                    <div id="albumname">
                       	<b><%=m.getMusicTitle() %></b>
                    </div>
                    <div>
                        <h3 id="artistname"> <%=ar.getArtistName() %> </h3>
                    </div>
                    <hr color="">
                    <table id="albuminfotable">
                        <tr>
                            <td width="120px">앨범</td>
                            <td width="170px"><%=a.getAlbumTitle()%></td>
                        </tr>
                        <tr>
                            <td>재생시간</td>
                            <td>
                            <%
	                            String[] timeParts = m.getMusicTime().split(":");
	                            String minutes = timeParts[0];
	                            String seconds = timeParts[1];
	                            out.print(minutes + "분 " + seconds + "초");
                            %>
                            </td>
                        </tr>
                        <tr>
                            <td>장르</td>
                            <td><%=m.getMusicGenre()%></td>
                        </tr>
                        <tr>
                            <td id="keyword">키워드</td>
                            <td id="keywordstyle">
                            
                           <% for( Keyword k  :   list   ) { %>
                            	<%= k.getKeywordName() %> 
                            <% } %>
                            </td>
                        </tr>
                        
                    </table>
                    <br>
                    <hr color="">
                </div>

                <div class="albuminfo3">
                    <img src="resources/img/playbtn.png" class="playbtn">
                    <br>
                    
                    <img src="resources/img/lovebtn.png" class="lovebtn">
                    <input type="hidden" value="<%= m.getMusicNo()%>" class="musicNo">
                </div>

            </div>
            <br clear="both">

        </div>
        
<script>
$(function(){
	
	$(".lovebtn").click( function(){
		
		 const mno = $(this).find(".musicNo").val();
		 
		location.href ="<%= contextPath%>/LikeYn.li?mno="+mno;
	})
	
})


  var img = document.querySelector(".lovebtn");
  var originalSrc = img.src;
  var altSrc = "resources/img/redlovebtn.png";
  
   <%-- var musicLike = <%=maa.getMusicLike()%>; --%>

  img.addEventListener("click", function() {
    if (musicLike == 1) {
      img.src = originalSrc;
      musicLike = 0;
    } else {
      img.src = altSrc;
      musicLike = 1;
    }
  });
</script>

        <div class="container">
            <div class="biggertxt" onclick="openModal()">이미지 확대</div>
            <img src="resources/img/biggerbtn.png" id="biggerbtn" onclick="openModal()">

        </div>

        <div id="myModal" class="modal">
            <span class="close" onclick="closeModal()">&times;</span>
            <img src="" id="modalImage" class="modal-content">
        </div>


        <br clear="both">

        <script>
            var originalWidth;
            var originalHeight;

            function openModal() {
                var modal = document.getElementById("myModal");
                var modalImage = document.getElementById("modalImage");
                var albumcover = document.getElementById("albumcover");

                if (modal.style.display === "block") {
                    closeModal();
                } else {
                    originalWidth = albumcover.clientWidth;
                    originalHeight = albumcover.clientHeight;

                    modalImage.src = albumcover.src;
                    modal.style.display = "block";
                }
            }

            function closeModal() {
                var modal = document.getElementById("myModal");
                modal.style.display = "none";
            }
        </script>


        <div class="album-intro-container open">
            <h3 id="albumintro">가사 <span style="font-size: 30px;"> &raquo;</span></h4>
            <pre class="album-intro-text"> <%= m.getMusicLyrics()%> </pre>
        </div>

        <script>
            const albumIntro = document.getElementById('albumintro');
            const albumIntroContainer = document.querySelector('.album-intro-container');

            albumIntro.addEventListener('click', function () {
                albumIntroContainer.classList.toggle('open'); // 클래스 토글
            });
        </script>
 
    </div>

    <img src="resources/img/vinyl.png" id="vinyl">
 
  </div>
 <br><br><br>
<%@ include file="/views/common/footerView.jsp" %>
<%@ include file="/views/musicPlayer/playerView.jsp" %>
 
</body>
</html>