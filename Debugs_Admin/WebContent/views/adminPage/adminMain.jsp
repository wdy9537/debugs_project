<%@ page import="java.util.ArrayList, com.debugs.adminPage.model.vo.Qna, com.debugs.common.model.vo.PageInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<%@ include file="/views/adminPage/adminMenubar.jsp" %>
	<%	
		int adminNo = loginAdmin.getAdminNo();
		String adminName = loginAdmin.getAdminName();
		String adminId = loginAdmin.getAdminId();
		String adminPhone = loginAdmin.getAdminPhone();
		String adminMemo = loginAdmin.getAdminMemo() == null ? "저장된 메모가 없습니다." : loginAdmin.getAdminMemo();
		
		/* 페이징바 */
		PageInfo pi = (PageInfo)request.getAttribute("pi");
		ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("list");
	
		int currentPage = pi.getCurrentPage();
		int startPage = pi.getStartPage();
		int endPage = pi.getEndPage();
		int maxPage = pi.getMaxPage();
		
	%>
	
	<!-- 메인시작 -->
	<main id="main-container">
		<div class="side-section"></div>
		<div class="main-section">
			<div class="main-title"></div>
			<div class="main-content">
				<div class="mainPageUp">
					<div class="adminInf">
						<table>
							<tr>
								<th colspan="2">내 정보</th>
							</tr>
							<tr>
								<td>관리번호</td>
								<td><%= adminNo %></td>
							</tr>
							<tr>
								<td>이름</td>
								<td><%= adminName %></td>
							</tr>
							<tr>
								<td>아이디</td>
								<td><%= adminId %></td>
							</tr>
							<tr>
								<td>전화번호</td>
								<td><%= adminPhone %></td>
							</tr>
						</table>

					</div>
					<form action="<%= contextPath %>/updateMemo.ad" method="post">
					<div class="adminMemo">
						<table>
							<tr>
								<th>MEMO</th>
								<th><button type="submit" class="adminMemo-btn">
										<div>저 장</div>
									</button></th>
							</tr>
							<tr>
								<td colspan="2" style="border: none;"><textarea name="adminMemo"><%= adminMemo %></textarea></td>
							</tr>
						</table>
					</div>
					</form>
				</div>

				<table class="mainPageDown">
					<div>
						<h2>미답변 문의</h2>
					</div>
					<thead>
						<tr>
						<th width="110px" height="50px">번호</th>
						<th width="220px">카테고리</th>
						<th width="220px">아이디</th>
						<th width="900px">문의내용</th>
						</tr>
					</thead>
					<tbody>
						<% if(list.isEmpty()) { %>
							<tr>
								<td colspan="4">미답변 문의가 없습니다.</td>
							</tr>
						<% } else { %>
							<% for(Qna q : list){ %>
								<tr>
									<td><%= q.getQnaNo() %></td>
									<td><%= q.getQnaCategory() %></td>
									<td><%= q.getQnaUserNo() %></td>
									<td><%= q.getQnaContent() %></td>
								</tr>
							<% } %>
						<% } %>

					</tbody>
				</table>
				<br>
				<!-- 페이징 바 시작 -->
				<div class="main-pagingbar">
					<% if(currentPage != 1){ %>
						<button onclick="location.href='<%= contextPath %>/main.ad?currentPage=<%= currentPage -1 %>'">&lt;</button>
					<% } %>
			
					<% for(int p = startPage; p <= endPage; p++){ %>
						<% if(p != currentPage){ %>
							<button onclick="location.href='<%= contextPath %>/main.ad?currentPage=<%= p %>'"><%= p %></button>
						<% } else { %>
							<!-- 현재 내가 보고있는 페이지일 경우 클릭이 안되게끔 -->
							<button disabled><%= p %></button>
						<% } %>
					<% } %>
			
					<% if(currentPage != maxPage){ %>
						<button onclick="location.href='<%= contextPath %>/main.ad?currentPage=<%= currentPage+1 %>'">&gt;</button>
					<% } %>
				
				</div>
				<!-- 페이징 바 끝 -->

			</div>
		</div>
	</main>
	<!-- 메인 끝 -->

	<script>
		function selectAll() {
			const checked = document.getElementById("selectAll").checked; // true : 체크, false : 미선택

			const categorys = document.getElementsByName("check-btn");

			categorys.forEach(function(item) {
				item.checked = checked;
			});
		}
	</script>

</body>
</html>