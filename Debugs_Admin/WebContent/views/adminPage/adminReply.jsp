<%@ page import="java.util.ArrayList, com.debugs.adminPage.model.vo.ReplyList, com.debugs.common.model.vo.PageInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<ReplyList> list = (ArrayList<ReplyList>)request.getAttribute("list");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>   	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글관리</title>
</head>
<body>
	<%@ include file="/views/adminPage/adminMenubar.jsp" %>
	<!-- 메인시작 -->
	<main id="main-container">
		<div class="side-section"></div>
		<div class="main-section">
			<div class="main-title">
				<h1>댓글 관리</h1>
			</div>
			<div class="main-btn">
				<button type="button" id="selectedRemove" data-toggle="modal">
					<div>선택 삭제</div>
				</button>
			</div>
			<div class="main-content">
				<table>
					<thead>
						<th width="50px" height="50px"><input type="checkbox" id="selectAll"></input></th>
						<th width="120px">댓글번호</th>
						<th width="300px">앨범제목</th>
						<th width="300px">아티스트</th>
						<th width="700px">댓글내용</th>
					</thead>
					<tbody>
						<% if(list.isEmpty()) { %>
							<tr>
								<td colspan="5">댓글이 없습니다.</td>
							</tr>
						<% } else { %>
						<% for(ReplyList r : list){ %>
								<tr>
									<td><input type="checkbox" name="check-btn" value="<%= r.getReplyNo() %>"></td>
									<td><%= r.getReplyNo() %></td>
									<td><%= r.getAlbumTitle()  %></td>
									<td><%= r.getArtistName() %></td>
									<% if(r.getReplyContent().length() >= 33) { %>
									<td><%= r.getReplyContent() %>...</td>
									<% } else { %>
									<td><%= r.getReplyContent() %></td>
									<% } %>
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
						<button onclick="location.href='<%= contextPath %>/reply.ad?currentPage=<%= currentPage -1 %>'">&lt;</button>
					<% } %>
			
					<% for(int p = startPage; p <= endPage; p++){ %>
						<% if(p != currentPage){ %>
							<button onclick="location.href='<%= contextPath %>/reply.ad?currentPage=<%= p %>'"><%= p %></button>
						<% } else { %>
							<!-- 현재 내가 보고있는 페이지일 경우 클릭이 안되게끔 -->
							<button disabled><%= p %></button>
						<% } %>
					<% } %>
			
					<% if(currentPage != maxPage){ %>
						<button onclick="location.href='<%= contextPath %>/reply.ad?currentPage=<%= currentPage+1 %>'">&gt;</button>
					<% } %>
				</div>
				<!-- 페이징 바 끝 -->

			</div>
		</div>
	</main>
	<!-- 메인 끝 -->

	<!-- 모달 시작 -->
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

					<form id="seledtedDeleteForm" action="deleteReply.ad" method="post">
						<input type="hidden" name="replyNo">
						<button id="selectedDelete" type="button">삭제</button>
					</form>

				</div>

			</div>
		</div>
	</div>

	<!-- 모달 끝 -->

	<script>
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
        // 전체선택이 체크되었을때는 '모든' 카테고리 체크박스가 체크된 상태일때만 가능
        // 선택된 체크박스의 길이 == 전체 체크박스의 길이 ==> true일시 전체선택버튼에 불이 들어오게 작업
        const checkedLength = document.querySelectorAll("input[name=check-btn]:checked").length;
        if(checkedLength == categorys.length){
            selectAllBtn.checked = true;
        } else{
            selectAllBtn.checked = false;
        }
      }
    /* -------------------------------------전체선택 해제 끝------------------------------------------------ */
//		      선택삭제 시작
          const selectedDelete = document.getElementById("selectedDelete");
          selectedDelete.addEventListener("click",insertCheckValue);
          
          function insertCheckValue(){
            const checkedListNo = document.querySelectorAll("input[name=check-btn]:checked");
			// 3,2,1
            const checkNo = [].map.call(checkedListNo, (e,i) => {
				return e.value
			}).join(",");

            document.querySelector("#seledtedDeleteForm>input[name=replyNo]").value=checkNo;
            
            document.getElementById("seledtedDeleteForm").submit();

          }
			
          
//            체크 없이 선택삭제 누르면 알람뜨게
	       	function noSelectAnswer(){
       		alert("선택하신 댓글이 없습니다.")
   	    	};

           	const selectedRemove = document.querySelector("#selectedRemove");
            
           	selectedRemove.addEventListener("click",noSelectAnswer);
           	
            categorys.forEach(function(item){
                item.addEventListener('input', checkCount);
            });
            
            function checkCount(){
            	const checkedLength = document.querySelectorAll("input[name=check-btn]:checked").length;
            	
            	if(checkedLength > 0){
            		
            		selectedRemove.removeEventListener("click",noSelectAnswer);
            		selectedRemove.setAttribute("data-target","#delete");
            		
            	} else {
            		
            		selectedRemove.addEventListener("click",noSelectAnswer);
            		selectedRemove.removeAttribute("data-target","#delete");
            		
            	}
            };
        
//      	   선택삭제 끝
  </script>
</body>
</html>
