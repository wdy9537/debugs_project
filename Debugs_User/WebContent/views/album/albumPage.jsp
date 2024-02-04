<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.debugs.album.model.vo.Album, java.util.ArrayList, 
			com.debugs.member.model.vo.Artist, com.debugs.song.model.vo.Music, com.debugs.member.model.vo.User,
			com.debugs.album.model.vo.Reply"%>
<%
	Album a = (Album) request.getAttribute("a");
	Artist ar = (Artist) request.getAttribute("ar");
    ArrayList<Music> list = (ArrayList<Music>)request.getAttribute("list");
    ArrayList<Reply> list2 = (ArrayList<Reply>)request.getAttribute("list2");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEBUGS</title>
<link rel="stylesheet" type="text/css" href="resources/css/albumPageCss.css">
<link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
</head>

<body>
<%@ include file="/views/common/headerView.jsp" %>

	<script>
		const msg = "<%= (String)session.getAttribute("alertMsg") %>";
		
		if(msg != "null"){
			alert(msg);
			// 알림창을 띄워준 후 session에 담긴 해당 메세지는 지워줘야한다.
			// 안그럼, menubar.jsp가 로딩될때마다 항상 메세지가 뜰것..
			<% session.removeAttribute("alertMsg"); %>
		}
	</script>
<div class="outbox">	
	<div id="wholealbum">
		<div>
			<div class="wholeinfo">
				<div class="albuminfo1">
					<img src="<%= contextPath %>/resources/img/album_pic/<%=a.getAlbumChangeName() %>" id="albumcover">
				</div>
				<div class="albuminfo2">
					<div id="albumname">
						
                        	<b><%=a.getAlbumTitle() %></b>
					</div>
					<div>
						<h3 id="artistname"><%= ar.getArtistName() %></h3>
					</div>
					<hr color="">
					<table id="albuminfotable">
						<tr>
							<td width="120px">발매일</td>
							<td width="170px"><%=a.getAlbumDate() %></td>
						</tr>
						<tr>
							<td>유형</td>
							<td><%=a.getAlbumType() %></td>
						</tr>

						
					</table>
					<br>
					<hr color="">
				</div>

				<div class="albuminfo3">
					<img src="resources/img/playbtn.png" id="playbtn"> <br>

					<img src="resources/img/lovebtn.png" id="lovebtn"> <br>
					<img src="resources/img/commentbtn.png" id="commentbtn">
				</div>

			</div>
			<br clear="both">

		</div>
		
		
		
		<script>
  document.getElementById("playbtn").addEventListener("click", function() {
    window.location.href = "<%= contextPath %>/insertNo.al";
  });
  
  document.getElementById("inputcart").addEventListener("click", function() {
	    window.location.href = "<%= contextPath %>/insertPl.al";
	  });
</script>

		<script>
  var img = document.getElementById("lovebtn");
  var originalSrc = img.src;
  var altSrc = "resources/img/redlovebtn.png";
  var isAlt = false;

  img.addEventListener("click", function() {
    if (isAlt) {
      img.src = originalSrc;
      isAlt = false;
    } else {
      img.src = altSrc;
      isAlt = true;
    }
  });
</script>




		<div class="container">
			<div class="biggertxt" onclick="openModal()">이미지 확대</div>
			<img src="resources/img/biggerbtn.png" id="biggerbtn"
				onclick="openModal()">
			<div id="albumlength">
				<span id="albumlCount"></span> &nbsp;
				<button id="albumallplay">전체듣기</button>
			</div>
			<img src="resources/img/allplaybtn.png" id="allplaybtn">
		</div>

		<div id="myModal" class="modal">
			<span class="close" onclick="closeModal()">&times;</span> <img src=""
				id="modalImage" class="modal-content">
		</div>



		<br clear="both">
		<script>
  document.getElementById("albumallplay").addEventListener("click", function() {
    window.location.href = "<%= contextPath %>/insertNo.al";
  });
  
  $.ajax({
	 url : "<%= contextPath %>/selectmusiccount.mu",
	 data : {ano : (넘겨줄값)},
	 success : function(result) {
		 let count  = 0;
		 
		 for (let i = 0; i < result.length; i++) {
			 count++;
		 }
		 $("#albumlCount").html(count);
	 }
  });
</script>

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








		<table id="albumtable">
			<thead>
				<tr>

					<th width="70">번호</th>
					<th width="500">곡명</th>
					<th width="310">아티스트</th>

					<th width="120" colspan="1">곡 재생</th>

				</tr>
			</thead>
			<tbody>
				<% if(list.isEmpty()) { %>
				<tr>
					<td colspan="5">존재하는 곡이 없습니다</td>
				</tr>
				<% } else { %>
				<% int num = 0; %>
				<% for( Music m  :   list   ) { %>
				<tr class="movingmusic">

					<input type="hidden" value="<%= m.getMusicNo()%>" class="musicNo">
					<td><%= ++num %></td>

					<td><%=m.getMusicTitle()%></td>
					<td><%=ar.getArtistName()%></td>

					<td class="addmusicplaylist"><img src="resources/img/songplaybtn.png" ></td>

				</tr>
				<% } %>
				<% } %>
			</tbody>
		</table>
		<script>
		$(function(){
			
			$(".movingmusic").click( function(){
				// console.log("클릭됨");
				// 클릭했을때 해당 공지사항의 공지사항번호(기본키값)도 함께 넘겨줘야한다.
				// 해당 tr요소의 자손중에서도 첫번째 td태그 내부의 내용이 필요하다 ==> 공지사항번호
				// console.log($(this).children().eq(0).text());
				 const mno = $(this).find(".musicNo").val();
				 
				// 요청할url(/detail.no)?키=밸류&키=밸류...
				// ?뒤의 내용들을 쿼리스트링이라고 부름 => 직접만들어서 넘겨줘야함.
				
				//  /jsp2/detail.no?nno=글번호
				location.href ="<%= contextPath%>/goSong.me?mno="+mno;
			})
			
		})
		
		</script>

		<br>
		<%-- <script>
		$(function() {
			  $("#albumtable>tbody>tr td:nth-child(-n+3)").click(function() {
			    const nno = $(this).parent().children().eq(0).text();
			    location.href = "<%= contextPath%>/detail.no?mno=" + mno;
			  });
			});

		</script> --%>

		<div class="album-info-container open">
			<h3 id="albumdetail">
				상세 정보 <span style="font-size: 30px;"> &raquo;</span>
			</h3>
			<table id="albuminfotable2">
				<tr>
					<td width="110px"><b>앨범명</b></td>
					<td width="170px"><%=a.getAlbumTitle()%></td>
				</tr>
				<tr>
					<td><b>아티스트</b></td>
					<td><%=ar.getArtistName()%></td>
				</tr>

			</table>
		</div>

		<script>
            const albumDetail = document.getElementById('albumdetail');
            const albumContainer = document.querySelector('.album-info-container');

            albumDetail.addEventListener('click', function () {
                albumContainer.classList.toggle('open'); // 클래스 토글
            });
        </script>

		<div class="album-intro-container open">
			<h3 id="albumintro">
				앨범 소개 <span style="font-size: 30px;"> &raquo;</span>
				</h4>
				<% for( Music m  :   list   ) { %>
				<% String musicDetail=  m.getMusicDetail();%>
				<%if(musicDetail!=null) {%>
				<pre class="album-intro-text"><%= m.getMusicDetail() %></pre>
				<% } %>
				<% } %>
			
		</div>

		<script>
            const albumIntro = document.getElementById('albumintro');
            const albumIntroContainer = document.querySelector('.album-intro-container');

            albumIntro.addEventListener('click', function () {
                albumIntroContainer.classList.toggle('open'); // 클래스 토글
            });
        </script>







			<div class="album-comment-container open">
			
				<h3 id="albumcomment">
					댓글 <span style="font-size: 30px;"> &raquo;</span>
				</h3>
				
				<textarea class="album-comment-text" name="replyContent"
					placeholder="댓글 작성은 최대 150자까지 가능합니다."></textarea>
			</div>
			
			<button id="commentsend" onclick="albumReplyInsert(<%= a.getAlbumNo() %>);">등록</button>
			
			<hr id="commenthr">
			
			<script>
				function albumReplyInsert(albumNum) {
					$.ajax({
						url : "insertcomment.al",
						type : "post",
						data : { ano : albumNum,
							replyContent : $("textarea[name=replyContent]").val()
								},
						success : function(result){
							$(".album-comment-text").val("");
							selectReplyList();
							
							alert("댓글 등록에 성공하셨습니다.");
						}
					});				
					
				}
				
				function selectReplyList(){
					$.ajax({
						url : "commentlist.al",
						data : {
							ano : <%= a.getAlbumNo() %>
						},
						success : function(list){
							let result = "";
							for ( let reply of list ) {
								result += "<tr>"
										+ "<td>" + reply.userName + "</td>"
										+ "<td class='categorybold'>" + reply.replyContent + "</td>"
										+ "</tr>"
							}
							$("#commenttable tbody").html(result);
						}
					})
				}
				
			</script>
		<br clear="both">

		<table id="commenttable">
			<thead>
				<tr>
					<th width="200">작성자</th>
					<th width="800">내용</th>
				</tr>
			</thead>
			<tbody>
				<% if(list.isEmpty()) { %>
				<!-- 리스트가 비어있을 경우 -->
				<tr>
					<td colspan="5">존재하는 댓글이 없습니다</td>
				</tr>
				<% } else { %>
					<% for( Reply r  :   list2   ) { %>
					<tr class="comment-row">
						<td><%= r.getUserName() %></td>
						<td class="categorybold"><%= r.getReplyContent() %></td>
					</tr>
					<% } %>
				<% } %>
			</tbody>
		</table>
		<script>
            const comments = document.querySelectorAll('.comment-row');

            comments.forEach((row) => {
                row.addEventListener('click', () => {
                    row.classList.toggle('clicked');
                });
            });
        </script>


		<script>
            const albumcomment = document.getElementById('albumcomment');
            const albumCommentContainer = document.querySelector('.album-comment-container');
            const commentsendButton = document.getElementById('commentsend');
            const commenttable = document.getElementById('commenttable');
            const commenthr = document.getElementById('commenthr');

            albumcomment.addEventListener('click', function () {
                albumCommentContainer.classList.toggle('open'); // 클래스 토글
                commentsendButton.classList.toggle('open'); // 클래스 토글
                commenttable.classList.toggle('open'); // 클래스 토글
                commenthr.classList.toggle('open'); // 클래스 토글
            });
        </script>

	</div>
</div>

	<!-- <img src="resources/img/vinyl.png" id="vinyl"> -->

	<script>
    const commentbtn = document.getElementById('commentbtn');
    const commenttable2 = document.getElementById('commenttable');
    
    commentbtn.addEventListener('click', function () {
      commenttable2.scrollIntoView({ behavior: 'smooth' });
    });
	</script>

	
	
<%@ include file="/views/common/footerView.jsp" %>
<%@ include file="/views/musicPlayer/playerView.jsp" %>
 

</body>
</html>