<%@ page import="java.util.ArrayList, com.debugs.adminPage.model.vo.Qna, com.debugs.common.model.vo.PageInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("list");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>    	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qna관리</title>
</head>
<body>
	<%@ include file="/views/adminPage/adminMenubar.jsp" %>
	<!-- 메인시작 -->
	<main id="main-container">
		<div class="side-section"></div>
		<div class="main-section">
			<div class="main-title">
				<h1>문의 관리</h1>
			</div>
			<div class="main-btn">
				<button id="selectedAnswer" type="submit" data-toggle="modal">
					<div>선택 답변</div>
				</button>
				<button id="selectedRemove" type="button" data-toggle="modal">
					<div>선택 삭제</div>
				</button>
			</div>
			<div class="main-content">
				<table>
					<thead>
						<th width="50px" height="50px"><input type="checkbox" id="selectAll"></th>
						<th width="100px">번호</th>
						<th width="200px">아이디</th>
						<th width="900px">문의내용</th>
						<th width="200px">처리결과</th>
					</thead>
					<tbody>
						<% if(list.isEmpty()) { %>
							<tr>
								<td colspan="5">미답변 문의가 없습니다.</td>
							</tr>
						<% } else { %>
						<% for(Qna q : list){ %>
								<tr>
									<td><input type="checkbox" name="check-btn" value="<%= q.getQnaNo() %>"></td>
									<td><%= q.getQnaNo() %></td>
									<td><%= q.getQnaUserNo()  %></td>
									<td><%= q.getQnaContent() %></td>
									<% if(q.getQnaResult().equals("Y")){ %>
									<td>처리완료</td>
									<% } else { %>
									<td>처리중</td>
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
						<button onclick="location.href='<%= contextPath %>/qna.ad?currentPage=<%= currentPage -1 %>'">&lt;</button>
					<% } %>
			
					<% for(int p = startPage; p <= endPage; p++){ %>
						<% if(p != currentPage){ %>
							<button onclick="location.href='<%= contextPath %>/qna.ad?currentPage=<%= p %>'"><%= p %></button>
						<% } else { %>
							<!-- 현재 내가 보고있는 페이지일 경우 클릭이 안되게끔 -->
							<button disabled><%= p %></button>
						<% } %>
					<% } %>
			
					<% if(currentPage != maxPage){ %>
						<button onclick="location.href='<%= contextPath %>/qna.ad?currentPage=<%= currentPage+1 %>'">&gt;</button>
					<% } %>

				</div>
				<!-- 페이징 바 끝 -->

			</div>
		</div>
	</main>
	<!-- 메인 끝 -->

	<!-- The Modal -->
	<div class="modal" id="insertqna">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<div></div>
					<h4 class="modal-title">답변</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
						<form action="<%= contextPath %>/updateQna.ad" method="post">
						<input type="hidden" id="qnaNo" name="qnaNo">
						<table class="main-content-insertTable">
							<tr>
								<th>사진보기</th>
								<td id="faq-modal-category">
									<div>
										<button type="button" id="loadQnaImage" data-toggle="modal" data-target="#qnaImage">
											<div>사진보기</div>
										</button>
									</div>
								</td>
							</tr>
							<tr>
								<th>분류</th>
								<td id="faq-modal-category">
									<div id="qna-category"></div>
								</td>
							</tr>
							<tr>
								<th colspan="2">문의내용</th>
							</tr>
							<tr>
								<td colspan="2">
									<div id="qna-content"></div>
								</td>
							</tr>
							<tr>
								<th colspan="2">답변내용</th>
							</tr>
							<tr>
								<td colspan="2"><textarea placeholder="내용을 입력하세요." name="qnaAnswer"></textarea>
								</td>
							</tr>
						</table>
						<br>
						<button type="submit">답변등록</button>
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
					<form id="seledtedDeleteForm" action="deleteQna.ad" method="post">
						<input type="hidden" name="qnaNo">
						<button id="selectedDelete" type="button">삭제</button>
					</form>
				</div>

			</div>
		</div>
	</div>

	<!-- The Modal -->
	<div class="modal" id="qnaImage">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<div></div>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<img id="watchQnaImg" style="width: 700px; height: 700px;">
				</div>

			</div>
		</div>
	</div>

	<script>
// 		알람 시작	
       	function noSelectAnswer(){
       		alert("선택하신 문의가 없습니다.")
       	};
       	
       	function overSelectAnswer(){
       		alert("한개의 문의만 답변 가능합니다.")
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
        
        // ----------------답변 : 한개만 선택시 모달 시작 / 삭제 : 선택 삭제 체크 없을시 알람, 체크 있을시 모달 오픈 시작-------------------------------------
       	const selectedAnswer = document.querySelector("#selectedAnswer");
       	const selectedRemove = document.querySelector("#selectedRemove");
        
       	selectedAnswer.addEventListener("click",noSelectAnswer);
       	selectedRemove.addEventListener("click",noSelectAnswer);
       	
        categorys.forEach(function(item){
            item.addEventListener('input', checkCount);
        });
        
        
        function checkCount(){
        	const checkedLength = document.querySelectorAll("input[name=check-btn]:checked").length;
        	
        	if(checkedLength == 1){
        		selectedAnswer.removeEventListener("click",noSelectAnswer);
        		selectedAnswer.removeEventListener("click",overSelectAnswer);
        		selectedAnswer.setAttribute("data-target","#insertqna");
        		bool = true;
        		selectedRemove.removeEventListener("click",noSelectAnswer);
        		selectedRemove.setAttribute("data-target","#delete");
        		
        	} else if (checkedLength == 0){
        		selectedAnswer.addEventListener("click",noSelectAnswer);
        		selectedAnswer.removeAttribute("data-target","#insertqna");
        		
        		selectedRemove.addEventListener("click",noSelectAnswer);
        		selectedRemove.removeAttribute("data-target","#insertqna");
        		
        	} else {
        		selectedAnswer.addEventListener("click",overSelectAnswer);
        		selectedAnswer.removeAttribute("data-target","#insertqna");
        		
        		selectedRemove.removeEventListener("click",noSelectAnswer);
        		selectedRemove.setAttribute("data-target","#delete");
        	}
        };
        
        
//         선택답변
		
        selectedAnswer.addEventListener("click", function (){
     		if(!bool){
     			return;
     		}
        	$.ajax({
        		url : "/debugsadmin/loadQnaInfo.ad",
        		type : "post",
        		data : {qnaNo : document.querySelector("input[name=check-btn]:checked").value},
        		success : function(result){
        			$("#qnaNo").val(result.qnaNo);
        			$("#qnaCategory").val(result.qnaCategory);
        			$("#qna-category").text(result.qnaCategory);
        			$("#qnaContent").val(result.qnaContent);
        			$("#qna-content").text(result.qnaContent);
        		}

        	})
        });
        
//         사진보기
			const loadQnaImage = document.querySelector("#loadQnaImage");
			loadQnaImage.addEventListener("click", function (){

        	$.ajax({
        		url : "/debugsadmin/loadQnaImage.ad",
        		type : "post",
        		data : {qnaNo : document.querySelector("input[name=check-btn]:checked").value},
        		success : function(result){
        			$("#watchQnaImg").attr("src", result);

        		}

        	})
        });
        
//	      선택삭제 시작
        const selectedDelete = document.getElementById("selectedDelete");
        selectedDelete.addEventListener("click",insertCheckValue);
        
        function insertCheckValue(){
          const checkedListNo = document.querySelectorAll("input[name=check-btn]:checked");
			// 3,2,1
          const checkNo = [].map.call(checkedListNo, (e,i) => {
				return e.value
			}).join(",");

          document.querySelector("#seledtedDeleteForm>input[name=qnaNo]").value=checkNo;
          
          document.getElementById("seledtedDeleteForm").submit();

        }
        
     // --------------------------------------- 한개만 선택시 모달 오픈 끝-------------------------------------
     
     
  </script>


</body>
</html>