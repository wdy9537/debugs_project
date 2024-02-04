<%@ page import="java.util.ArrayList, com.debugs.adminPage.model.vo.Ticket, com.debugs.common.model.vo.PageInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Ticket> list = (ArrayList<Ticket>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/debugsAdminDashboard.css">
</head>
<body>

	<%@ include file="/views/common/menubar.jsp" %>

	 <!-- 메인시작 -->
  <main id="main-container">
      <div class="side-section"></div>
      <div class="main-section">
        <div class="main-title"><h1>이용권 관리</h1></div>
        <div class="main-btn">
            <button type="button" id="enrollTicket"><div>등록</div></button>
            <button type="button" id="deleteTicket"><div>선택 삭제</div></button>
        </div>
        <div class="main-content">
          <table>
            <thead>
              <th width="50px" height="50px"><input type="checkbox" id="selectAll" onclick="selectAll();"></input></th>
              <th width="150px">번호</th>
              <th width="800px">이용권 이름</th>
              <th width="500px">가격</th>
              <th width="600px">이용기한</th>
            </thead>
            <tbody>
              <% if(list.isEmpty()) { %>
					<tr>
						<td colspan="5">조회된 리스트가 없습니다.</td>
					</tr>
					<% } else {%>
						<% for(Ticket t : list) { %>
							<tr>
								<td id="admincheckbox"><input type="checkbox" name="check-btn" value="<%= t.getTicketNo() %>"></td>
								<td><%= t.getTicketNo() %></td>
								<td><%= t.getTicketName() %></td>
								<td><%= t.getTicketPrice() %>원</td>
								<td><%= t.getTicketPer() %>일</td>
							</tr>
						<% } %>
					<% } %>

              
            </tbody>
          </table>
          <br><br>

        </div>
      </div>  
  </main>
  <!-- 메인 끝 -->
 
  <!-- 이용권 등록 모달창 -->
  <div class="ticket-enroll-modal">
    <div class="ticket-enroll-modal-body">
      <button id="ticket-out">X</button>
      <form action="<%= contextPath %>/insertticket.ad" method="post">
        <h2>이용권 등록</h2>
        <!-- 관리자 생성 폼 -->
        <table id="ticket-modal-table">
          <tr>
            <th><label style="text-align:left;">이용권 이름</label></th>
            <td colspan="2"><input type="text" name="ticket-name" placeholder="내용을 입력하세요" required></td>
          </tr>
          <tr>
            <th><label style="text-align:left;">가격</label></th>
            <td colspan="2"><input type="text" name="ticket-price" placeholder="내용을 입력하세요" required></td>
          </tr>
          <tr>
          	<th><label style="text_align:left;">이용기한</label></th>
          	<td colspan="2"><input type="text" name="ticket-per" placeholder="내용을 입력하세요" required></td>
          </tr>
          <tr>
            <th><label style="text-align:left;">무제한 듣기</label></th>
            <td><input type="radio" id="listen" name="music-listen" value="Y">가능</td>
            <td><input type="radio" id="listen" name="music-listen" value="N">불가능</td>
          </tr>
          <tr>
            <th><label style="text-align:left;">오프라인 재생</label></th>
            <td><input type="radio" id="music-start" name="music-start" value="Y">가능</td>
            <td><input type="radio" id="music-start" name="music-start" value="N">불가능</td>
          </tr>
        </table>
        <br>
        <!-- 이용권 등록 버튼 -->
        <button type="submit" id="ticket-enroll">등록</button>
      </form>
    </div>
  </div>

  <!-- 이용권 삭제 모달창 -->
  <div class="ticket-delete-modal">
    <div class="ticket-delete-modal-body">
      <button id="ticket-delete-out">X</button>
      <form action="<%= contextPath %>/deleteticket.ad" method="post">
      <input type="hidden" name="ticketNo">
        <h2>정말 삭제하시겠습니까?</h2>
        <!-- 이용권 삭제 버튼 -->
        <button type="submit" id="ticket-delete">삭제</button>
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
      const ticketEnrollBodyModal = document.querySelector('ticket-enroll-modal-body');
      const ticketEnrollModal = document.querySelector('.ticket-enroll-modal');
      const ticketDeleteMod = document.querySelector('.ticket-delete-modal');
      const ticketDeleteModalBody = document.querySelector('.ticket-delete-modal-body');
      const enrollTicketBtn = document.querySelector('#enrollTicket');
      const deleteTicketBtn = document.querySelector('#deleteTicket');
      const ticketOut = document.querySelector('#ticket-out');
      const deleteTicketOut = document.querySelector('#ticket-delete-out');

      // 생성
      enrollTicketBtn.addEventListener('click', () => {
        ticketEnrollModal.classList.toggle('show');

        if (ticketEnrollModal.classList.contains('show')) {
          ticketEnrollBodyModal.style.overflow = 'hidden';
        }
      });

      ticketEnrollModal.addEventListener('click', (event) => {
        if (event.target === ticketEnrollModal) {
          ticketEnrollModal.classList.toggle('show');

          if (!ticketEnrollModal.classList.contains('show')) {
            ticketEnrollBodyModal.style.overflow = 'auto';
          }
        }
      });

      // 삭제
      deleteTicketBtn.addEventListener('click', () => {
    	  
    	  var checkboxes = document.getElementsByName('check-btn');
    	  var vals = [];
    	  for (var i=0, n = checkboxes.length; i<n; i++) {
    	      if (checkboxes[i].checked) {
    	          vals.push(checkboxes[i].value);
    	      }
    	  }
    	  if (vals.length === 0) {
    		  alert("삭제할 이용권을 체크해주세요");
    		  return;
    	  }
    	  document.getElementsByName('ticketNo')[0].value = vals.join(",");
    	  
        ticketDeleteMod.classList.toggle('show');

        if (ticketDeleteMod.classList.contains('show')) {
          ticketDeleteModalBody.style.overflow = 'hidden';
        }
      });

      ticketDeleteMod.addEventListener('click', (event) => {
        if (event.target === ticketDeleteMod) {
          ticketDeleteMod.classList.toggle('show');

          if (!ticketDeleteMod.classList.contains('show')) {
            ticketDeleteModalBody.style.overflow = 'auto';
          }
        }
      });

    // 모달창 바깥쪽 클릭시 없어짐
    ticketOut.addEventListener('click', () => {
        ticketEnrollModal.classList.remove('show');
        ticketEnrollBodyModal.style.overflow = 'auto';
      });

      deleteTicketOut.addEventListener('click', () => {
        ticketDeleteMod.classList.remove('show');
        ticketDeleteModalBody.style.overflow = 'auto';
      });
  </script>

</body>
</html>