<%@ page import="java.util.ArrayList, com.debugs.adminPage.model.vo.MusicList, com.debugs.common.model.vo.PageInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<MusicList> list = (ArrayList<MusicList>)request.getAttribute("list");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>  	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음원관리</title>

</head>
<body>
	<%@ include file="/views/adminPage/adminMenubar.jsp" %>
	<!-- 메인시작 -->
	<main id="main-container">
		<div class="side-section"></div>
		<div class="main-section">
			<div class="main-title">
				<h1>음원 관리</h1>
			</div>
			<div class="main-btn">
				<form action="<%= contextPath %>/searchMusic.ad" method="post">
					<span class="searchMusic">
						<input type="text" id="searchMusicName" name="searchMusicName" placeholder="음원제목을 입력하세요.">
					</span>
					<button type="submit" id="searchMusicBtn">검색</button>
				</form>
				<button id="selectedUpdate" type="button" data-toggle="modal">
					<div>선택 수정</div>
				</button>
				<button id="selectedRemove" type="button" data-toggle="modal">
					<div>선택 삭제</div>
				</button>
			</div>
			<div class="main-content">
				<table>
					<thead>
						<th width="50px" height="50px"><input type="checkbox" id="selectAll"></input></th>
						<th width="120px">음원번호</th>
						<th width="310px">앨범제목</th>
						<th width="310px">음원제목</th>
						<th width="270px">아티스트</th>
						<th width="170px">장르</th>
						<th width="270px">키워드</th>
					</thead>
					<tbody>
						<% if(list.isEmpty()) { %>
							<tr>
								<td colspan="7">음원이 없습니다.</td>
							</tr>
						<% } else { %>
						<% for(MusicList ml : list){ %>
								<tr>
									<td><input type="checkbox" name="check-btn" value="<%= ml.getMusicNo() %>"></td>
									<td><%= ml.getMusicNo() %></td>
									<td><%= ml.getAlbumTitle() %></td>
									<td><%= ml.getMusicTitle() %></td>
									<td><%= ml.getArtistName() %></td>
									<td><%= ml.getMusicGenre() %></td>
									<td><%= ml.getKeywordName() %></td>
								</tr>
							<% } %>
						<% } %>
					</tbody>
				</table>
				<br>
				<br>
				<!-- 페이징 바 시작 -->
				<div class="main-pagingbar">
					<% if(currentPage != 1){ %>
						<button onclick="location.href='<%= contextPath %>/manageMusic.ad?currentPage=<%= currentPage -1 %>'">&lt;</button>
					<% } %>
			
					<% for(int p = startPage; p <= endPage; p++){ %>
						<% if(p != currentPage){ %>
							<button onclick="location.href='<%= contextPath %>/manageMusic.ad?currentPage=<%= p %>'"><%= p %></button>
						<% } else { %>
							<!-- 현재 내가 보고있는 페이지일 경우 클릭이 안되게끔 -->
							<button disabled><%= p %></button>
						<% } %>
					<% } %>
			
					<% if(currentPage != maxPage){ %>
						<button onclick="location.href='<%= contextPath %>/manageMusic.ad?currentPage=<%= currentPage+1 %>'">&gt;</button>
					<% } %>
				</div>
				<!-- 페이징 바 끝 -->

			</div>
		</div>
	</main>
	<!-- 메인 끝 -->


	<!-- The Modal -->
	<div class="modal" id="updateMusic">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<div></div>
					<h4 class="modal-title">음원수정</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">

					<form action="<%= contextPath %>/updateMusic.ad" method="post" enctype="multipart/form-data">
							<input type="hidden" id="loadAlbumNo" name="albumNo">
							<input type="hidden" id="loadMusicNo" name="musicNo">
							<input type="hidden" id="loadKeywordNo" name="KeywordNo">
						<table class="main-content-insertTable">
							<tr>
								<th>앨범 제목</th>
								<td><input type="text" id="loadAlbumTitle" name="albumTitle"></td>
								<td rowspan="6" style="width: 50px;"></td>
								<th>발매일</th>
								<td><input type="date" id="loadAlbumDate" name="albumDate"></td>
							</tr>
							<tr>
								<th>음원 제목</th>
								<td><input type="text" id="loadMusicTitle" name="musicTitle"></td>
								<th>장르</th>
								<td><input type="text" id="loadMusicGenre" name="musicGenre"></td>
							</tr>
							<tr>
								<th>아티스트</th>
								<td><input type="text" id="loadArtistName" name="artistName"></td>
								<th>음원 시간</th>
								<td><input type="text" style="display:none;" id="loadMusicTime" oninput="loadData(this);">
									<input type="text" placeholder="00분" style="width: 197px;" name="musicTimeM"> : <input type="text" placeholder="00초" style="width: 197px;" name="musicTimeS">
								</td>
							</tr>
							<tr>
								<th>앨범 유형</th>
								<td><input type="text" id="loadAlbumType" name="albumType"></td>
								<th>앨범 사진</th>
								<td>
									<input type="text" readonly id="loadAlbumPic" onclick="document.querySelector('#loadAlbumPic2').click()" name="albumPic">
									<input type="file" id="loadAlbumPic2" style="display:none;" onchange="document.querySelector('#loadAlbumPic').value = this.value"  name="upAlbumPic">
									<input type="hidden" id="loadAlbumChangeName" name="albumChanegeName">
								</td>
							</tr>
							<tr>
								<th>새 키워드 추가</th>
								<td><input type="text" name="keywordName" placeholder="※하나의 키워드만 추가 가능합니다.※"></td>
								<th>음원 파일</th>
								<td>
									<input type="text" readonly id="loadMusicFile" onclick="document.querySelector('#loadMusicFile2').click()" name="musicFile">
									<input type="file" id="loadMusicFile2" style="display:none;" onchange="document.querySelector('#loadMusicFile').value = this.value" name="upMusicFile">
									<input type="hidden" id="loadMusicChangeName" name="musicChangeName">
								</td>
							</tr>
							<tr>
								<th>음원 상세정보</th>
								<td><textarea placeholder="내용을 입력하세요." id="loadMusicDetail" name="musicDetail"></textarea></td>
								<th>가사</th>
								<td><textarea placeholder="내용을 입력하세요." id="loadMusicLyrics" name="musicLyrics"></textarea></td>
							</tr>
						</table>
						<br>
						<button type="submit">음원 수정</button>
					</form>

				</div>

			</div>
		</div>
	</div>


	<!-- The Modal -->
	<div class="modal" id="delete">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<div></div>
					<h5 class="modal-title">정말 삭제하시겠습니까?</h5>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form id="seledtedDeleteForm" action="deleteMusic.ad" method="post">
						<input type="hidden" name="musicNo">
						<button id="selectedDelete" type="button">삭제</button>
					</form>

				</div>

			</div>
		</div>
	</div>


	<script>
//		알람 시작	
   	function noSelectMusic(){
   		alert("선택하신 음원이 없습니다.")
   	};
   	
   	function overSelectMusic(){
   		alert("한개의 음원만 수정 가능합니다.")
   	};
   	
/* -----------------------------------------전체선택 시작------------------------------------------------  */
    const selectAllBtn = document.querySelector("#selectAll");
    const categorys = document.getElementsByName("check-btn");
	selectAllBtn.addEventListener("click", selectAll);
	
	function selectAll() {
      const checked = document.getElementById("selectAll").checked; // true : 체크, false : 미선택

      categorys.forEach(function (item) {
          item.checked = checked;
 	      checkCount();
      });
    }
 /* -----------------------------------------전체선택 끝------------------------------------------------  */
 
 /* -------------------------------------전체선택 해제 시작------------------------------------------------ */
 // 전체선택버튼과 각각의 체크박스들 연동

    categorys.forEach(function(item){
        item.addEventListener("click",onOff);
    });

    function onOff(){   
        // 전체선택이 체크되었을때는 '모든' 카테고리 체크박스가 체크된 상태일때만 가능하다.
        // 선택된 체크박스의 길이 == 전체 체크박스의 길이 ==> true일시 전체선택버튼에 불이 들어오게 작업
        const checkedLength = document.querySelectorAll("input[name=check-btn]:checked").length;
        if(checkedLength == categorys.length){
            selectAllBtn.checked = true;
        } else{
            selectAllBtn.checked = false;
        }
      }
    /* -------------------------------------전체선택 해제 끝------------------------------------------------ */
    
    const selectedDelete = document.getElementById("selectedDelete");
    selectedDelete.addEventListener("click",insertCheckValue);
          
    function insertCheckValue(){
    	const checkedListNo = document.querySelectorAll("input[name=check-btn]:checked");
		// 3,2,1
    	const checkNo = [].map.call(checkedListNo, (e,i) => {
		return e.value
		}).join(",");

        document.querySelector("#seledtedDeleteForm>input[name=musicNo]").value=checkNo;
            
        document.getElementById("seledtedDeleteForm").submit();

    }
    
    
    
    // ----------------답변 : 한개만 선택시 모달 시작 / 삭제 : 선택 삭제 체크 없을시 알람, 체크 있을시 모달 오픈 시작-------------------------------------
   	const selectedUpdate = document.querySelector("#selectedUpdate");
   	const selectedRemove = document.querySelector("#selectedRemove");
    
   	selectedUpdate.addEventListener("click",noSelectMusic);
   	selectedRemove.addEventListener("click",noSelectMusic);
   	
    categorys.forEach(function(item){
        item.addEventListener('input', checkCount);
    });
   
    let bool = false;
    
    function checkCount(){
    	const checkedLength = document.querySelectorAll("input[name=check-btn]:checked").length;
    	
    	if(checkedLength == 1){
    		selectedUpdate.removeEventListener("click",noSelectMusic);
    		selectedUpdate.removeEventListener("click",overSelectMusic);
    		selectedUpdate.setAttribute("data-target","#updateMusic");
    		selectedRemove.setAttribute("data-target","#delete");
    		bool = true;
    			
    		selectedRemove.removeEventListener("click",noSelectMusic);
    		selectedRemove.setAttribute("data-target","#delete");
    		
    	} else if (checkedLength == 0){
    		selectedUpdate.addEventListener("click",noSelectMusic);
    		selectedUpdate.removeAttribute("data-target","#updateMusic");
    		
    		selectedRemove.addEventListener("click",noSelectMusic);
    		selectedRemove.removeAttribute("data-target","#updateMusic");
    		
    	} else {
    		selectedUpdate.addEventListener("click",overSelectMusic);
    		selectedUpdate.removeAttribute("data-target","#updateMusic");
    		
    		selectedRemove.removeEventListener("click",noSelectMusic);
    		selectedRemove.setAttribute("data-target","#delete");
    	}
    };
    
 	selectedUpdate.addEventListener("click", function (){
 		if(!bool){
 			return;
 		}
    	$.ajax({
    		url : "/debugsadmin/loadMusicInfo.ad",
    		data : {musicNo : document.querySelector("input[name=check-btn]:checked").value},
    		success : function(result){
    			console.log(result);
    			for(let key in result){				
    				for(let innerKey in result[key]){
    					let parsedKey = innerKey.substring(0,1).toUpperCase()+innerKey.substring(1);
    					$("#load"+parsedKey)?.val(result[key][innerKey]);
    				}
    			}
    			
    		},
    		complete : function(){
    			loadTime(document.querySelector("#loadMusicTime"));
    		}
    	})
    });
 	function loadTime(input){
 		console.log(input)
 		let minute = input.value.split(":")[0];
 		let sec = input.value.split(":")[1];
 		
 		$(input).next().val(minute);
 		$(input).next().next().val(sec);
 	}
 	
 	 
 // --------------------------------------- 한개만 선택시 모달 오픈 끝-------------------------------------

 
  </script>

</body>
</html>
