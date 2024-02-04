<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%@ page import="com.debugs.member.model.vo.Member"   %>  
<%@ page import="com.debugs.member.model.vo.Ticket"   %>
<%
	Ticket UserTicket = (Ticket) request.getAttribute("UserTicket");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEBUGS</title>
<link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
<style>

body  .MainIcon{
    width: 120px; height: 100px;
    padding: 10px 35px;
    color : #666;  
}


/* sidebar */
.sidebar {
    /* position: relative; */
    /* width:100%; */
    /* margin-top: 60px; */
    /* clear: both; */

    /* border-top: 1px solid #e0e1e5; */
    /* padding-top: 32px;
    bottom: 70px; */
}

.sidebar  table {
    margin-top: 1px;
    background-color: #faecec80;
}



.sidebar ul {
		/* list-style-type: none; */
		/* background-color: #ccc; */
		/* width: 13%; */
		padding: 0;
		/* margin:  0; */
		/* position: fixed;  사이드 바 세로 설정 기능 */
		/* height: 100%; 사이드 바 세로 길이 설정 기능 */
		/* overflow: auto;    스크롤바 생기게 해주는 설정 기능*/ 
}


.sidebar li a { /*사이드바 글씨 크기 위치 설정 기능*/
		text-decoration: none;
		display: block;
		color: #000;
		padding: 8px 1px 8px 40px;
		font-weight: bold;
        font-size: 18px;
}


.sidebar li a.job {
	background-color: #333;
	color: #fff;
}

.sidebar li a:hover:not(.job) {/*사이드 바 글씨 마우스 갖다대면 효과일어나게 해주는 기능*/
	background-color: #333;
	color: #fff;
}


/* base - 브라우저 별로 다를 수도 있는 것을 초기화 */
*{ padding: 0; margin: 0; } /* 태그 여백 없앰 */
li{ list-style: none; } /* 기호나 번호를 제거 */
a{ text-decoration: none; } /* 링크텍스트에 밑줄없앰 */
button{ cursor: pointer; } /* 모든 버튼에 마우스손모양 처리 */

/* body설정 */
body{ 
   background-color: #fff; 
   /* width: 1000px;  */
}

.loginbox{
    width: 600px; height: 550px;
    /* margin: 0 auto; 블록요소를 부모영역에서 가운데 처리 */
    margin-left: 100px;
    /* border: 1px solid gray; */
}

h2{
    width: 100%; /* 부모영역을 상속 */
    /* 한줄텍스트인 경우만 height와 line-height가 같으면 세로 가운데 처리 */
    height: 100%; line-height: 150px;
    font-size: 30px;
    font-weight: normal;
    margin-left: 550px;
   
}

form{
    font-size: 15px;
    margin-left: 30px;
   
}

pre{
    margin-left: 370px;
}


.loginbox table{
    border: 1px solid gray;
    /* border-collapse : collapse; */
    
    /* margin: auto; */
    margin-left: 100px;
    border-radius: 15px;
    background-color: #E391A4;
    font-weight: bold;  
    /* overflow: hidden; */

}


.loginbox button{
    width: 80px;
    height: 50px;
    margin: 0 auto;
    padding: 0px 5px;
    border: 1px solid white;
    border-radius: 20px;
    background-color: #E391A4;
    color: #fff; 
    font-size: 14px;
    font-weight: bold; 

}

#button1{
  width: 130px;
   
  

}


</style>
</head>
<body>
<%@ include file="/views/common/headerView.jsp" %>
     <table>
        <tr>
            <td magrin>
                <div class="sidebar">
                    <ul id="ur1">
                        <li> <img class="MainIcon" src="<%= contextPath %>/resources/img/debugs_logo1.png" ></li>
                            
                        <br>
                        <li><a  href="update.me">정보수정</a></li>
                        <br>
                        <li><a href="http://localhost:8081/semi_project/views/mypage/drop.jsp">회원탈퇴</a></li>
                        <br>
                        <li><a href="#">이용권 조회</a></li>
                        <br>
                        <li><a href="#">내 플리 목록</a></li>
                    </ul>
            
                </div>
            </td>
            <td>
            
  

        <div class="loginbox">

            <form id="ticketSelect"  action="<%= contextPath %>/ticket_Select.me" method="post">
                <input type="hidden" id="loginid" name="userId" value="<%= loginUser.getUserId() %>"  style="width: 400px;">
            </form>
            <form id="enroll-form"  action="<%= contextPath %>/ticket_Cancel.me" method="post">
                <span><h2><strong><a href="<%= contextPath %>/ticket_Select.me?userId=<%= loginUser.getUserId() %>">이용권조회</a> (클릭)</strong></h2></span>
                <pre style="color: #4c4c4c;">       *회원님이 사용중이신 이용 서비스를 확인할수 있습니다.</pre><br>
                <br>
                <br>

                <% if (UserTicket == null) { %>
                <table width="1000px" height="200px">
                    <tr>
                        <td width="500px" >
                          <span  style="font-size: 25px; margin-left: 60px;" >해당 이용권 정보가 없습니다. </span>
                        </td>
                        
                        <td width="500px"   >
                        </td>
                        <td  width="100px" >
                            
                        </td>

                    </tr>
                </table>
                        
                
                <% } else { %>

                <table width="1000px" height="200px">
                    <tr>
                        <td width="500px" >
                            <br><br><br>
                            <span  style="font-size: 25px; margin-left: 60px;" ><%=UserTicket.getTicketName() %></span>
                            <br><br><br><br>
                            <span style="margin-left: 60px;"><u>이용중</u></span>
                            <br>
                            <br><br><br><br>

                        </td>
                        <td width="500px"   >
                            <span style="margin-left: 60px; color: #f0ffff;">
                            이용 가능 서비스 : <% if (UserTicket.getTicketLoopPlay().equals("Y") ) { %>무제한 듣기  + <% } %> 
                                           <% if (UserTicket.getTicketOfflinePlay().equals("Y")) { %>오프라인 재생 <% } %> 
                                           
                                            </span>
                            <br><br>
                            <span style="margin-left: 60px; color: #f0ffff;">
                             
                            이용기간 일 : <%=loginUser.getTicket_Date() %></span>
                            <br><br>
                            <span style="margin-left: 60px; color: #f0ffff;">
                            구매출처 : DEBUGS</span>
                            <br><br>
                            <span style="margin-left: 60px; color: #f0ffff;">
                            결제설정 : 정기결제</span>
                            <br>
                            <!-- userid  session 정보 임 -->
                          <input type="hidden" id="loginid" name="userId"   value="<%=loginUser.getUserId() %>"  style="width: 400px;">
                          
                        </td>
                        <td  width="100px" >
                            <button type="submit">해지</button> 
                            
                        </td>

                    </tr>
                </table>
                <% } %>
            </form>


        </div>
        </td>   
      </tr>
   </table>
   
   
   <%@ include file="/views/common/footerView.jsp" %>
<%@ include file="/views/musicPlayer/playerView.jsp" %>
        <script>
          function ticket_select(){    // 화면   onLoad = ticket_select()
        	  ticketSelect.method = "post"; //전송방식 post
        	  ticketSelect.action = "<%= contextPath %>/ticket_Select.me"; //action 속성을 서블릿 매핑 이름으로
        	  ticketSelect.submit(); //자바스크립트에서 서블릿으로 전송	
          }
       </script>

        
        
        
        
</body>
</html>