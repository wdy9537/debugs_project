<%@ page import="java.util.ArrayList, com.debugs.ticket.model.vo.Ticket"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<Ticket> list = (ArrayList<Ticket>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEBUGS</title>
<link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="resources/css/ticketPageCss.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>

<body>
<script>
		
		const msg = "<%= (String)session.getAttribute("alertMsg") %>";
		
		if(msg != "null"){
			alert(msg);
			// 알림창을 띄워준 후 session에 담긴 해당 메세지는 지워줘야한다.
			// 안그럼, menubar.jsp가 로딩될때마다 항상 메세지가 뜰것..
			<% session.removeAttribute("alertMsg"); %>
		}
</script>

<%@include file="/views/common/headerView.jsp" %>




	<div id="wholeticket">
		<br>
		<div class="container">

			<h2 id="debugsbuy">DEBUGS 이용권 구매</h2>


			<!-- 메인 이용권-->
			<img src="resources/img/mainticket.PNG" id="mainimg">
			<button id="ticketbuy1">구매하기</button>

			<br> <br>

			<script>
			$(function(){
			
				$("#ticketbuy1").click( function(){
					const tno = $(".ticket-table").children().eq(0).text();;
					location.href ="<%= contextPath%>/buyTicket.ti?tno="+5;
				})
			})
			</script>


			<!--이용권 유형-->

			<% for( Ticket t  :   list   ) { %>
			<table class="ticket-table">
				<tr>
					<td class="ticketNo"><%= t.getTicketNo() %></td>
					<td class="ticket-name"><%= t.getTicketName() %></td>
					<td class="ticket-price"><span class="hrhr">|</span><%= t.getTicketPrice() %>원</td>
					<td><button class="ticket-buy">구매</button></td>
				</tr>

			</table>
			
			<% } %>

			<script>
			$(function(){
				
			
				$(".ticket-buy").click( function(){
					const tno = $(this).closest("tr").find(".ticketNo").text();
					location.href ="<%= contextPath%>/buyTicket.ti?tno="+tno;
				})
			})
			</script>



		</div>
	</div>
	
	<br><br><br><br><br>
<%@include file="/views/common/footerView.jsp" %>
<%@include file="/views/musicPlayer/playerView.jsp" %>
	
	
</body>
</html>