<%@ page import="java.util.ArrayList, com.debugs.cs.model.vo.*, com.debugs.common.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
   	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
   	ArrayList<Category> list2 =  (ArrayList<Category>) request.getAttribute("list2");
   	String nn = (String) request.getAttribute("n");
   	
   	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int startPage   = pi.getStartPage();
	int endPage     = pi.getEndPage();
	int maxPage     = pi.getMaxPage(); 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEBUGS</title>
<link rel="stylesheet" type="text/css" href="resources/css/noticePageCss.css">
<link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
</head>
<body>
<%@include file="/views/common/headerView.jsp" %>
	<div id="wholenoticepage">
		<h1 id="noticemaintext">고객센터</h1>

		<div class="wholenoticemenu">
			<div class="noticemenu" id="noticechoicemenu">
				<a href="<%=contextPath %>/noticelist.bo">공지사항</a>
			</div>
			<div class="noticemenu">
				<a href="<%=contextPath %>/faqlist.fa">FAQ</a>
			</div>
			<div class="noticemenu">
				<a href="<%=contextPath %>/goQna.me">1:1문의</a>
			</div>
			<div class="noticemenu">
				<a href="<%=contextPath %>/goQnaResult.me">나의 문의내역</a>
			</div>
		</div>

		


		<%-- <select name="category" class="noticekind">
			
			 <% for(Category c :  list2) { %>
			 <% if (c.getCategoryName().equals("선택")) { %>
			   <option value="<%= c.getCategoryNo() %>" selected><%= c.getCategoryName() %></option>
			 <% } else { %>
				<option value="<%= c.getCategoryNo() %>"><%= c.getCategoryName() %></option>
				<% } %>
			<% } %> 
		</select> <br>
 --%>



		<table id="noticetable">
			<thead>
				<tr>
					<th width="80">번호</th>
					<th width="250">분류</th>
					<th width="620">제목</th>
				</tr>
			</thead>
			<tbody>
				<% if(list.isEmpty()) { %>
				<tr>
					<td colspan="3">존재하는 공지사항이 없습니다</td>
				</tr>
				<% } else { %>
				
					<% for( Notice n  :   list   ) { %>
				
				<tr class="notice-row">
					<td><%= n.getNoticeNo() %></td>
					<td class="categorybold"><%= n.getNoticeCategory() %></td>
					<td class="notice-title"><%= n.getNoticeTitle() %></td>
				</tr>
					<% } %>
				<% } %>
					
				
				
			</tbody>
		</table>
<br>
    	<div align="center" class="paging-area">
			<% if(currentPage != 1) { %>
				<button onclick="location.href= '<%=contextPath %>/noticelist.bo?currentPage=<%= currentPage -1 %>' " >&lt;</button>
			<% } %>
			
			<% for(int p = startPage; p<= endPage; p++){ %>
			
				<% if(p != currentPage) {%>
					<button onclick="location.href='<%=contextPath %>/noticelist.bo?currentPage=<%=p %>'" ><%= p %></button>
				<% } else { %>
					<!-- 현재 내가 보고있는 페이지일 경우 클릭이 안되게끔  -->
					<button disabled><%= p %></button>
				<% } %>
				
			<% } %>
			
			
			<% if(currentPage != maxPage) { %>
				<button onclick="location.href = '<%=contextPath %>/noticelist.bo?currentPage=<%= currentPage+1 %>'">&gt;</button>
			<% } %>
			
		</div>
		
		
		<script>
        const noticeRows = document.querySelectorAll('.notice-row');

        noticeRows.forEach((row) => {
            row.addEventListener('click', () => {
                row.classList.toggle('clicked');
            });
        });
    	</script>
    	
    	
    	
    	
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script>
			$(document).ready(function() {
				$(".notice-row").click(function() {
					const nno = $(this).children().eq(0).text();
					location.href = "<%= contextPath%>/detail.no?nno=" + nno;
				});
			});
		</script>
    	
    	
		
	</div>
	<br><br><br><br><br>
	<%@include file="/views/common/footerView.jsp" %>
<%@include file="/views/musicPlayer/playerView.jsp" %>
</body>
</html>