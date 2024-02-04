<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.debugs.cs.model.vo.*" %>
<%
	ArrayList<Category> list =  (ArrayList<Category>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEBUGS</title>
<link rel="stylesheet" type="text/css" href="resources/css/qnaPageCss.css">
<link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
</head>
<script>
		
		const msg = "<%= (String)session.getAttribute("alertMsg") %>";
		
		if(msg != "null"){
			alert(msg);
			// 알림창을 띄워준 후 session에 담긴 해당 메세지는 지워줘야한다.
			// 안그럼, menubar.jsp가 로딩될때마다 항상 메세지가 뜰것..
			<% session.removeAttribute("alertMsg"); %>
		}
	</script>

<body>
<%@include file="/views/common/headerView.jsp" %>

<div id="wholeqnapage">
    <h1 id="clamemaintext">고객센터</h1>

    <div class="wholeclamemenu">
        <div class="clamemenu"><a href="<%=contextPath %>/noticelist.bo">공지사항</a></div>
        <div class="clamemenu"><a href="<%=contextPath %>/faqlist.fa">FAQ</a></div>
        <div class="clamemenu" id="clamechoicemenu"><a href="<%=contextPath %>/goQna.me">1:1문의</a></div>
        <div class="clamemenu"><a href="<%=contextPath %>/goQnaResult.me">나의 문의내역</a></div>
    </div>



    <form action="<%= contextPath %>/insertqna.qn" method="post" enctype="multipart/form-data">
        <select name="qnaCategory" class="clamekind">
            <% for(Category c :  list) { %>
			 <% if (c.getCategoryName().equals("선택")) { %>
			   <option value="<%= c.getCategoryNo() %>" selected><%= c.getCategoryName() %></option>
			 <% } else { %>
				<option value="<%= c.getCategoryNo() %>"><%= c.getCategoryName() %></option>
				<% } %>
			<% } %> 
        </select>

        <input type="file" id="upfile" name="upfile">
        <br>
        <br clear="both">

        <textarea name="qnaContent" id="qnaContent"
            placeholder="내용을 입력해주세요. &#13;&#10;*개인정보가 포함되지 않도록 유의해 주세요.&#13;&#10;*해당 문제가 발생하는 이미지를 첨부해주시면 보다 빠른 처리가 가능합니다.&#13;&#10;*파일 첨부는 5MB 이하만 가능합니다  "></textarea>

        <br>

        <pre>


<b style="font-size: 17px;">개인정보 수집 및 이용 동의</b>

디버그는 이용자의 문의를 처리하기 위해 다음과 같이 개인정보를 수집 및 이용하고 있습니다.

    (공통)아이디, 이메일 주소, 휴대전화번호
    (캐시프렌즈 문의 시)구매한 상품명, 주문번호
    (권리침해신고 시)권리침해 증명자료, 신분증 사본, 위임장 및 대리인 신분증 사본(필요시)
    (현금환불 문의 시)예금주명, 계좌은행명, 계좌번호, 관계증명서류(필요 시)
    (인앱결제 환불 문의 시)구글 이메일 계정(필요 시)
    (연락처 변경/도용 문의 시)이름, 신분증 사본, 휴대전화 이용계약증명서(필요 시)
    (사망자 탈퇴 문의 시)개인정보 삭제 요구서, 사망사실증명서, 관계증명서(필요시)
<span id="prespan">
문의 유형에 따라 광고 식별자(ADID, IDFA), 기기정보를 추가로 수집할 수 있습니다. 
수집된 개인정보는 문의접수일 기준 3년 간 보관 후 파기됩니다. 
본 개인정보 수집에 대해 동의를 거부하는 경우 문의사항에 대한 답변이 불가능한 점 양해 부탁 드립니다. 
더 자세한 내용에 대해서는 멜론의 개인정보처리방침을 참고하시기 바랍니다.
</span>
    </pre>
    

        <br>
        <button type="submit" id="clamesumbit">문의하기</button>
    </form>


</div>

<br><br><br><br><br>
<%@include file="/views/common/footerView.jsp" %>
<%@include file="/views/musicPlayer/playerView.jsp" %>
</body>
</html>