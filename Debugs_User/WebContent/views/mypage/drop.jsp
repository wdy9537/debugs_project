<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="com.debugs.member.model.vo.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEBUGS</title>
<link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style>
/* sidebar */
.sidebar {
    /* position: relative; */
    /* width:100%; */
    /* margin-top: 60px; */
    /* clear: both; */

    /* border-top: 1px solid #e0e1e5; */
    /* padding-top: 32px;
    bottom: 70px; */
    top:60px;
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
body {
    margin: 0;
    font-family: 'Noto Sans KR', sans-serif;
}

a {
    text-decoration: none;
    color: black;
}

button{
    background-color: transparent;
    border:none;
}


body  .MainIcon{
    width: 120px; height: 100px;
    padding: 10px 35px;
    color : #666;  
}





#userid{
	padding: 30px 0px;
	margin-top: 10px;
}


pre {
      display: flex;
      
      align-items: center;
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
    margin-left: 300px;
    top: 50px;
}
.loginbox h2{
    width: 100%; /* 부모영역을 상속 */
    /* 한줄텍스트인 경우만 height와 line-height가 같으면 세로 가운데 처리 */
    height: 100px; line-height: 100px;
    font-size: 30px;
    font-weight: normal;
    margin-left: 52px;
}
.loginbox form{
    width: 110%; height: 950px;
    background-color: #fff;
    /* 패딩수치를 인사이드 처리 */
    padding: 0px; box-sizing: border-box;
    
}
.loginbox fieldset{
    border: none; /* 테두리 제거 */ 
    margin-left: 20px;
}
.loginbox legend{
    /* 요소를 화면 밖으로 처리 */
    position: absolute; left: -999em;

    /* 웹접근성으로 스크린리더기가 읽어줘야 하므로 display: none;을 사용하지 말것 */
}
.loginbox label{
    display: block;
    font-size: 12px; color: #333;
    margin-bottom: 10px; /* 동위선택자와의 간격 조정 */
    
}
.loginbox input{
    width: 85%; height: 50px;
    margin-bottom: 25px; /* 동위선택자와의 간격 조정 */
    border: none; background-color: #ededed;
    padding: 0 20px; /* 앞상하 뒷좌우 */
    box-sizing: border-box; /* 패딩수치를 인사이드 처리 */
    margin-left: 5%;
}

.loginbox ul{
    width: 100%;
    text-align: right; /* 글자를 오른쪽으로 처리 */
    margin-bottom: 60px;
}
.loginbox li{
    display: inline-block;
    height: 12px; line-height: 12px;
}
.loginbox li:last-child{
    border-left: 1px solid #333;
    padding-left: 10px; /* 테두리 안쪽 여백 */
    margin-left: 4px; /* 테두리 바깥쪽 여백 */
}

.loginbox button{
    width: 100px; height: 50px;
    margin: 0 auto; /* 블록요소가 부모 영역에서 가운데 오기 */
    border: none;
    background-color: #E391A4;
    color: #fff; font-size: 14px; font-weight: bold;
    
    
}
#button1{
    margin-left: 40%;
}


.confirm_btn {
    /* border:1px solid red; */
    /* padding-left: 30%; 중복확인 버튼 오른쪽으로 옮길때 사용 */
    /* margin: 0 auto; 블록요소가 부모 영역에서 가운데 오기 */
    /* display: flex; */
    /* justify-content: space-between; */
    padding-right: 40px;


}
#button2{
    margin-left: 170px;
}

#button3{

    margin-left: 20px;
    width: 100px; height: 50px;
    
    
    
    border: none;
    background-color: #E391A4;
    color: #fff; font-size: 15px; font-weight: bold;
    /* position: absolute; 중복확 버튼 위쪽으로 옮길때 사용 */
    /* justify-content: center; */
    
    text-align: center;
    align-items: center;

    
}

.loginbox textarea {
    margin-left: 5%;
   
}

.checkbox-size { /*체크박스 랑 옆에 글씨 크기 설행주는 기능*/
    
    width: 20px;
    height : 20px;
    border : 2px;
    top: 20%;
}

    
.body_hr {
      width: 60%; /* Adjust the width as needed */
      margin: 0 auto; /* Center the <hr> horizontally */
    }
.footer {
      background-color: #fff;
      padding: 20px;
      text-align: center;
      color : #666;
      margin-bottom: 110px;
    }
.copyright {
    padding-top: 16px;
    padding-bottom: 0;
    font-size: 11px;
    text-align: center;
    color: #8e8e93;
}
#check_all{ /*체크박스 설정 기능*/
    
    width: 20px;
    height : 20px;
    border : 5px;
    margin-left: 29px;
    margin-top: 10px;
    font-size: 15px;
   
}





/* 푸터영역 끝 */
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
                        <li><a  href="pwdupdate.me">PW 수정</a></li>
                        <br>
                        <li><a href="">회원탈퇴</a></li>
                        <br>
                        <li><a href="ticket_Select.me">이용권 조회</a></li>
                        <br>
                        <li><a href="#">내 플리 목록</a></li>
                    </ul>
            
                </div>
            </td>
            <td>
  

        <div class="loginbox">

            <!--  <svg data-v-520830cc="" width="55" height="23" viewBox="0 0 55 23" fill="none" xmlns="http://www.w3.org/2000/svg" class="icon"><path d="M23.8009 18.3051H31.4211V22.4533H22.4807C20.3597 22.4533 18.6415 20.7338 18.6415 18.614V0.334047H22.9783V17.4814C22.9783 17.9356 23.3467 18.304 23.8009 18.304V18.3051ZM14.3503 0.664663C13.7589 0.995278 11.9262 1.84756 9.76402 1.76405C6.78849 1.64965 6.60773 0.613183 3.22264 0.725295C1.64278 0.777919 0.657799 1.24009 0 1.74574V5.99684C0 6.09408 0.110968 6.14785 0.187616 6.08721C0.760759 5.63305 1.89789 5.12397 3.42284 5.07134C6.586 4.96038 6.98411 6.014 9.90359 6.10895C12.2099 6.18331 13.9099 5.32417 14.5219 4.95694V0.765335C14.5219 0.676103 14.427 0.621191 14.3492 0.664663H14.3503ZM14.3618 8.91975C13.7371 9.18745 12.0875 9.79834 10.193 9.7869C7.24952 9.7686 6.53566 8.76989 3.68825 8.84425C1.79379 8.89459 0.608607 9.52035 0 10.1999V22.4533H4.3369V13.0839C7.22778 13.0702 7.54696 13.9167 10.3703 14.0529C12.5439 14.1581 13.9842 13.4694 14.5219 13.2429V9.02615C14.5219 8.94263 14.4373 8.88658 14.3606 8.91975H14.3618ZM55 11.44C55 17.7583 49.8783 22.88 43.56 22.88C37.2417 22.88 32.12 17.7583 32.12 11.44C32.12 5.12168 37.2417 0 43.56 0C49.8783 0 55 5.12168 55 11.44ZM50.6311 11.44C50.6311 7.44743 47.4656 4.21106 43.56 4.21106C39.6544 4.21106 36.489 7.44743 36.489 11.44C36.489 15.4325 39.6544 18.6689 43.56 18.6689C47.4656 18.6689 50.6311 15.4325 50.6311 11.44Z" fill="black"></path></svg>-->

          
                <span><h2><strong>회원탈퇴</strong></h2></span>
                <pre style="color: #4c4c4c;">        *본인확인을 위해 비밀번호를 입력해주세요.</pre><br>
                <pre style="color: #4c4c4c;">        *항상 비밀번호는 타인에게 노출되지 않도록 주의해 주세요.</pre>
                <br>
                <!--작성하지 않아도 문제는 없음-->
                <fieldset>
                    <legend></legend>
                   <form id="enroll-form" action="<%= contextPath %>/delete.me" method="post">
                    <label for="loginpw">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>비밀번호</strong></label>
                    <input type="password" id="loginpw"
                        name="userPwd" placeholder="비밀번호를 입력해 주세요">
                    <button id="button1" type="button"  onclick="pwdCheck()" >확인</button>
                    <br><br><br>
                    <label for="loginpw">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>안내사항</strong></label>
                    <textarea name="content" cols="75" rows="15"
                        style="resize: none">
소셜 계정으로 가입한 회원 탈퇴 시, 소셜 계정 및 모든 정보가 DEBUGS에
서 삭제 처리됩니다. 탈퇴 시, 자동으로 연동 해제되지 않으며 
                                             
네이버/ 카카오/Apple 계정 관리 페이지에서 연결 해제해주세요.
이메일에 연동한 소셜 계정의 탈퇴는 소셜 로그인을 한 후,
                        
진행해주시기 바랍니다.
탈퇴 시 이용중인 모든 이용권(혜택, 쿠폰 등 무료 이용권 포함)은
                        
소멸되며 재가입 하더라도 복구되지 않습니다.
자동 결제 상품 이용중인 경우, 기기 내에서 수동으로 구독해지를 해주셔야 합니다.
                        
유료 이용권(단권/정기결제 상품 모두 포함) 보유 상태에서 회원 탈퇴 시, 이용권 자동 환불이 되지
않으므로 회원님의 권리보호를 위해 사용 중 이용권의 해지 및 환불 신청을 먼저 진행해 주시기  바랍니다.
                                                               
FLO 이용권 혜택을 받을 수 있는 부가서비스 사용 중 탈퇴 후
재가입 하더라도 이용권 혜택을 받을 수 없습니다.
                                                
이용권 혜택을 다시 받기 위해서는 부가서비스 재가입을 해주셔야 합니다.
NUGU 에 연동되어 있는 계정 탈퇴 시, NUGU에서 이용중인
                        
모든 이용권( 혜택, 쿠폰 등 무료 이용권 포함)은 소멸되며
 재가입 하더라도 복구되지 않습니다.
                                                
DEBUGS 크리에이터 스튜디오에 등록된 크리에이터가 있는 계정 탈퇴 시,
더 이상 동일한 계정으로 스튜디오를 이용할 수 없습니다. 삭제를 원하는 콘텐츠가 있다면, 반드시
                        
회원탈퇴 전에 스튜디오에서 비공개 처리하거나 삭제하시기 바랍니다. 서비스 이용계약 해지 이후 콘텐츠
삭제를 요청하는 경우 회사는 콘텐츠 삭제를 지원해드릴 수 없습니다. 다른 회원들의 정상적인 서비스
이용을 위해, 삭제하지 않은 콘텐츠는 필요한 범위 내에서 무상으로 서비스될 수 있습니다.
                    </textarea>
                    <table  align="center" style="font-size: 13px;">
                        <tr>
                            <td>
                                <input type="checkbox" id="check_all"
                                    class="checkbox-size" required>
                            </td>
                            <td width="300px">
                                <label for="check_all"><strong
                                        style="color:#E391A4"></strong style="color:#181818">안내사항을
                                        모두 확인였으며 이에 동의합니다</label>
                                </td>
                            </tr>

                        </table>
                        
                         <!-- userid  session 정보 임 -->
                          <input type="hidden" id="loginid" name="userId"   value="<%=loginUser.getUserId() %>"  style="width: 400px;">
                        
                        <!--데이터를 서버로 전송-->
                        <div class="confirm_btn">
                            <button id="button2" type="submit">회원탈퇴</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button id="button3" type="button"
                                style="background-color: #ccc;  color:black;">취소</button>
                        </div>
                        <br>

                    </fieldset>
                </form>
            </div>
           </td>
        </tr>
    </table> 
           
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%@ include file="/views/common/footerView.jsp" %>
<%@ include file="/views/musicPlayer/playerView.jsp" %>

           
           
	<script>
             function pwdCheck(){ 
   	
 /*       alert("phoneCheck  1");  */
           
          const $userPwd = $("#enroll-form input[name=userPwd]");
      
       
         
          $.ajax(
          {
        	 url : "<%= contextPath%>/pwdCheck.me",    
        	 data : {checkpwd : $userPwd.val()},     
        	 success : function(result)
        	 {
        		 /* alert("pwdCheck  success   result "  +  result);   */
        		  
        		 if(result == "0")
        		 {
        			 alert("비밀번호가 맞지 않습니다.");
        			   $userPwd.focus();  
        	     } 
        		 else
        	     {
        	    	 if(confirm("확인되었습니다."))
        	    	 {
        	    		 $userPwd.attr("readonly",true);
        	    		 
        	    	 }
        	    	 else
        	    	 {
        	    		 $userPwd.focus();
        	    	 }
        	     }
        	  }
        	 
     
          });
        

          
       }
             </script>     
            
</body>
</html>