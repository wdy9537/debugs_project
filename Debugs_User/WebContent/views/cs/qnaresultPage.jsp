<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.debugs.cs.model.vo.Qna" %>
<%
	ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEBUGS</title>
<link rel="stylesheet" type="text/css" href="resources/css/qnaResultPageCss.css">
<link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
</head>

<body>

<%@include file="/views/common/headerView.jsp" %>

<div id="wholemain">
    <h1 id="resultmaintext">고객센터</h1>

    <div class="wholeresultmenu">
        <div class="resultmenu"><a href="<%=contextPath %>/noticelist.bo">공지사항</a></div>
        <div class="resultmenu"><a href="<%=contextPath %>/faqlist.fa">FAQ</a></div>
        <div class="resultmenu"><a href="<%=contextPath %>/goQna.me">1:1문의</a></div>
        <div class="resultmenu" id="resultchoicemenu"><a href="<%=contextPath %>/goQnaResult.me">나의 문의내역</a></div>
    </div>












    <table id="resulttable">
        <thead>
            <tr>
                <th width="70">번호</th>
                <th width="780">문의</th>
                <th width="150">상태</th>
            </tr>
        </thead>
        <tbody>
        <% if(list.isEmpty()) { %>
			<!-- 리스트가 비어있을 경우 -->
			<tr>
				<td colspan="4">문의내역이 없습니다</td>
			</tr>
		<% } else { %>
					
		<% for( Qna q  :   list   ) { %>
            <tr class="result-row">
                <td><%= q.getQnaNo() %></td>
                <td class="titlebold"><%= q.getQnaContent().length() >= 20 ? q.getQnaContent().substring(0, 20) + "..." : q.getQnaContent() %></td>
                <td>
                <%if (q.getQnaResult().equals("N") && q.getQnaAnswer() == null) {%>
                	처리중
                <%}else{%>
                	처리 완료
                 <%} %>
                 </td>
            </tr>
                 
            <tr class="result-content">
                <td colspan="4">
                    <div class="result-detail-content">
                    <%if (q.getQnaAnswer()==null) {%>
                 		답변 대기중입니다..
                 	<%}else{%>
                    <b>첨부파일</b> : <a href="<%= contextPath %>/<%= q.getFilePath() + q.getQnaImageChange() %>" download="<%= q.getQnaImage() %>"><%= q.getQnaImage() %></a>
                 	<br><br>
                 	<b>문의내용</b> : <%= q.getQnaContent() %> <br><br><br>
                 	----------------------------------------------------------------------------------------------------------------------
                 	<br><br><br>
                 	
                    <b>답변</b> : <%=q.getQnaAnswer() %>
                    <%} %>
                    </div>
                </td>
            </tr>
            <% } %>
			<% } %>

        </tbody>
    </table>

    <script>
        const resultRows = document.querySelectorAll('.result-row');

        resultRows.forEach((row) => {
            row.addEventListener('click', () => {
                row.classList.toggle('clicked');
            });
        });
    </script>
    
   
    


    <a href="<%=contextPath %>/goQna.me" id="reclaimtxt"><button id="reclaimbtn">1:1 문의하기</button></a>
</div>
<br><br><br><br><br>
<%@include file="/views/common/footerView.jsp" %>
<%@include file="/views/musicPlayer/playerView.jsp" %>
</body>
</html>