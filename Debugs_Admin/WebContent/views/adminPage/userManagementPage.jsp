<%@ page import="java.util.ArrayList, com.debugs.adminPage.model.vo.DebugUser, com.debugs.common.model.vo.PageInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<DebugUser> list = (ArrayList<DebugUser>)request.getAttribute("list");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/debugsAdminDashboard.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	
	<%@ include file="/views/common/menubar.jsp" %>
	
	<!-- 메인시작 -->
  <main id="main-container">
      <div class="side-section"></div>
      <div class="main-section">
        <div class="main-title"><h1>회원 관리</h1></div>
        <div class="main-btn">
          <span class="search-member">
            <!-- <label>회원검색 : </label> -->
            <form action="<%= contextPath %>/searchuser.ad" method="post">
            <input type="text" placeholder="회원이름 검색" name="searchUserName">
			<button type="submit" class="search-user-submit" style="width:80px;">검색</button>
			</form>
          </span>
          <button type="button" id="updateMember"><div>회원 수정</div></button>
          <button type="button" id="removeMember"><div>회원 삭제</div></button>
        </div>
        <div class="main-content">
          <table id="main-table">
            <thead>
              <th width="50px" height="50px"><input type="checkbox" id="selectAll" onclick="selectAll();"></input></th>
              <th width="100px">번호</th>
              <th width="200px">아이디</th>
              <th width="300px">이름</th>
              <!-- <th width="350px">비밀번호</th> -->
              <th width="330px">전화번호</th>
              <th width="350px">이메일</th>
              <th width="350px">주민등록번호</th>
              <th width="250px">이용권 정보</th>
            </thead>
            <tbody>
              <% if(list.isEmpty()) { %>
					<tr>
						<td colspan="9">조회된 리스트가 없습니다.</td>
					</tr>
					<% } else {%>
						<% for(DebugUser du : list) { %>
							<tr>
								<td id="usercheckbox"><input type="checkbox" name="check-btn" value="<%= du.getUserNo() %>"></td>
								<td><%= du.getUserNo() %></td>
								<td><%= du.getUserId() %></td>
								<td><%= du.getUserName() %></td>
								<%-- <td><%= du.getUserPwd() %></td> --%>
								<td><%= du.getphone() %></td>
								<td><%= du.getemail() %></td>
								<td><%= du.getssn() %></td>
								<% if(du.getTicketName() == null ) {%>
									<td>-</td>
								<% } else { %>
									<td><%= du.getTicketName() %></td>
								<% } %>
							</tr>
						<% } %>
					<% } %>
            </tbody>
          </table>
          <br><br>
          <!-- 페이징 바 -->
          <div class="main-pagingbar">
				<% if(currentPage != 1) { %>
					<button onclick="location.href='<%= contextPath%>/user.ad?currentPage=<%= currentPage - 1 %>'">&lt;</button>
				<% } %>
			
				<% for(int p = startPage; p <= endPage; p++) { %>
					<% if(p != currentPage) { %>
						<button onclick="location.href='<%= contextPath%>/user.ad?currentPage=<%= p %>'"><%= p %></button>
					<% } else { %>
						<!-- 현재 내가 보고있는 페이지일 경우 클릭이 안되게끔 -->
						<button disabled><%= p %></button>
					<% } %>
				<% } %>
			
				<% if(currentPage != maxPage) { %>
					<button onclick="location.href='<%= contextPath %>/user.ad?currentPage=<%= currentPage + 1 %>'">&gt;</button>
				<% } %>
			</div>
        </div>
      </div>  
  </main>
  <!-- 메인 끝 -->
  

  <!-- 회원 수정 모달창 -->
  <div class="member-update-modal">
    <div class="member-update-modal-body">
      <button id="member-out">X</button>
      <form action="<%= contextPath %>/updateuser.ad" method="post">
      <input type="hidden" name="userNo">
        <h2>회원 정보 수정</h2>
        <!-- 회원 수정 폼 -->
        <table id="member-modal-table">
          <tr>
            <th style="text-align: left; background-color: lightgray;"><label>회원정보</label></th>
          </tr>
          <tr>
            <td colspan="4">
              <table class="member-info">
                <thead>
                  <th style="width: 5%;">이름</th>
                  <th style="width: 8%;">아이디</th>
                  <!-- <th style="width: 8%;">비밀번호</th> -->
                  <th style="width: 10%;">전화번호</th>
                  <th style="width: 10%;">주민등록번호</th>
                  <th style="width: 15%;">이메일</th>
                  <th style="width: 13%;">이용권</th>
                  <th style="width: 20%;">이용권 기간</th>
                </thead>
                <tbody>
                </tbody>
              </table>
              <br>
            </td>
          </tr>
          <tr>
            <th colspan="4" style="background-color: lightgray;"><label>수정</label></th>
          </tr>
          <tr>
            <td>이름 : </td>
            <td><input type="text" name="change-name"></td>
            <td>아이디 : </td>
            <td><input type="text" name="change-id"></td>
          </tr>
          <tr>
            <!-- <td>비밀번호 : </td>
            <td><input type="text" name="change-pwd"></td> -->
            <td>전화번호 : </td>
            <td><input type="text" name="change-phone"></td>
            <td>이메일 : </td>
            <td><input type="text" name="change-email"></td>
          </tr>
          <tr>
            <!-- <td>이메일 : </td>
            <td><input type="text" name="change-email"></td> -->
            <td>주민등록번호 : </td>
            <td><input type="text" name="change-ssn"></td>
            <td>이용권 : </td>
            <td>
            <select name="change-ticket-option" id="ticket-option">
            </select>
            </td>
          </tr>
          <!-- <tr>
            <td>이용권 : </td>
            <td>
            <select name="change-ticket-option" id="ticket-option">
            </select>
            </td>
          </tr> -->
        </table>
        <br>
        <!-- 관리자 생성 버튼 -->
        <button type="submit" id="member-update">수정</button>
      </form>
    </div>
  </div>

  <!-- 회원 삭제 모달창 -->
  <div class="member-delete-modal">
    <div class="member-delete-modal-body">
      <button id="delete-member-out">X</button>
      <form action="<%= contextPath %>/deleteuser.ad" method="post">
      <input type="hidden" name="userNos">
        <h2>정말 삭제하시겠습니까?</h2>
        <!-- 관리자 삭제 버튼 -->
        <button type="submit" id="member-remove">삭제</button>
      </form>
    </div>
  </div>

  <script>
    function selectAll(){
            const checked = document.getElementById("selectAll").checked; // true : 체크, false : 미선택

            const categorys = document.getElementsByName("check-btn");

            categorys.forEach(function(item){
                item.checked = checked;
            });
        }

         // 전체선택버튼과 각각의 체크박스들 연동

         const categorys = document.getElementsByName("check-btn");
        const selectAllBtn = document.querySelector("#selectAll");
        
        categorys.forEach(function(item){
            item.onclick = onOff;
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
    // 관리자 생성 모달 관련 스트립트
      const memberUpdateModalBody = document.querySelector('.member-update-modal-body');
      const memberUpdateModal = document.querySelector('.member-update-modal');
      const memberDeleteModal = document.querySelector('.member-delete-modal');
      const memberDeleteModalBody = document.querySelector('.member-delete-modal-body');
      const udpateMemberBtn = document.querySelector('#updateMember');
      const removceMemberBtn = document.querySelector('#removeMember');
      const memberOut = document.querySelector('#member-out');
      const deleteMemberOut = document.querySelector('#delete-member-out');

    // 수정
      udpateMemberBtn.addEventListener('click', () => {
    	  
    	  $.ajax({
  			url : "<%= contextPath %>/selectticketlist.ad",
  			success : function(result){
  				let str = "";
  				
  				for(let i = 0; i < result.length; i++) {
  					str += 
  						"<option value=" + result[i].ticketNo + ">" + result[i].ticketName + "</option>";
  				}
  				$("#ticket-option").html(str);
  			}
  		});
    	  
    	  
    	  var checkboxes = document.getElementsByName('check-btn');
    	  var vals = [];
    	  for (var i=0, n = checkboxes.length; i<n; i++) {
    	      if (checkboxes[i].checked) {
    	          vals.push(checkboxes[i].value);
    	      }
    	  }
    	  if (vals.length === 0) {
    		  alert("수정할 사용자를 체크해주세요");
    		  return;
    	  } else if (vals.length != 1){
    		  alert("한명만 체크해주세요");
    		  return;
    	  }
    	  
    	  document.getElementsByName('userNo')[0].value = vals.join(",");
    	  
    	  $.ajax({
				url : "<%= contextPath %>/selectuser.ad",
				data : {userNo : document.getElementsByName('userNo')[0].value},
				success : function(result){
					let str = "";
					
					str += 
						  "<td>" + result.userName + "</td>"
						+ "<td>" + result.userId + "</td>"
						/* + "<td>" + result.userPwd + "</td>" */
						+ "<td>" + result.phone + "</td>"
						+ "<td>" + result.ssn + "</td>"
						+ "<td>" + result.email + "</td>"
						+ (result.ticketName == null ? "<td>-</td>" : "<td>" + result.ticketName + "</td>")
						+ (result.ticketDate == null ? "<td>-</td>" : "<td>" + result.ticketDate + "</td>");
						
					$(".member-info tbody").html(str);
				}
			});
    	  
        memberUpdateModal.classList.toggle('show');

        if (memberUpdateModal.classList.contains('show')) {
          memberUpdateModalBody.style.overflow = 'hidden';
        }
      });

      memberUpdateModal.addEventListener('click', (event) => {
        if (event.target === memberUpdateModal) {
          memberUpdateModal.classList.toggle('show');

          if (!memberUpdateModal.classList.contains('show')) {
            memberUpdateModalBody.style.overflow = 'auto';
          }
        }
      });

      // 삭제
      removceMemberBtn.addEventListener('click', () => {
    	  var checkboxes = document.getElementsByName('check-btn');
    	  var vals = [];
    	  for (var i=0, n = checkboxes.length; i<n; i++) {
    	      if (checkboxes[i].checked) {
    	          vals.push(checkboxes[i].value);
    	      }
    	  }
    	  if (vals.length === 0) {
    		  alert("삭제할 사용자를 체크해주세요");
    		  return;
    	  }
    	  
    	  document.getElementsByName('userNos')[0].value = vals.join(",");
    	  
        memberDeleteModal.classList.toggle('show');

        if (memberDeleteModal.classList.contains('show')) {
          memberDeleteModalBody.style.overflow = 'hidden';
        }
      });

      memberDeleteModal.addEventListener('click', (event) => {
        if (event.target === memberDeleteModal) {
          memberDeleteModal.classList.toggle('show');

          if (!memberDeleteModal.classList.contains('show')) {
            memberDeleteModalBody.style.overflow = 'auto';
          }
        }
      });

    // 모달창 바깥쪽 클릭시 없어짐
      memberOut.addEventListener('click', () => {
        memberUpdateModal.classList.remove('show');
        memberUpdateModalBody.style.overflow = 'auto';
      });

      deleteMemberOut.addEventListener('click', () => {
        memberDeleteModal.classList.remove('show');
        memberDeleteModalBody.style.overflow = 'auto';
      });
      
     
  </script>
	
</body>
</html>