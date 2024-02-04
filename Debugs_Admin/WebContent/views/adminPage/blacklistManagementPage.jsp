<%@ page import="java.util.ArrayList, com.debugs.adminPage.model.vo.Blacklist, com.debugs.common.model.vo.PageInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   PageInfo pi = (PageInfo)request.getAttribute("pi");
   ArrayList<Blacklist> list = (ArrayList<Blacklist>)request.getAttribute("list");
   
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
</head>
<body>

   <%@ include file="/views/common/menubar.jsp" %>
   
   <!-- 메인시작 -->
  <main id="main-container">
      <div class="side-section"></div>
      <div class="main-section">
        <div class="main-title"><h1>블랙리스트 관리</h1></div>
        <div class="main-btn">
            <span class="search-member">
            <!-- <label>회원검색 : </label> -->
            <form action="<%= contextPath %>/searchblacklist.ad" method="post">
            <input type="text" placeholder="회원이름 검색" name="searchblacklistname">
            <button type="submit" class="search-member-submit" style="width:80px;">검색</button>
            </form>
            </span>
            <button type="button" id="enroll-blacklist"><div>등록</div></button>
            <button type="button" id="delete-blacklist"><div>선택 삭제</div></button>
        </div>
        <div class="main-content">
          <table id="main-table">
            <thead>
              <th width="50px" height="50px"><input type="checkbox" id="selectAll" onclick="selectAll();"></input></th>
              <th width="100px">번호</th>
              <th width="200px">이름</th>
              <th width="200px">아이디</th>
              <th width="500px">제제사유</th>
              <th width="200px">상태</th>
              <th width="200px">제재날짜</th>
            </thead>
            <tbody>
              <% if(list.isEmpty()) { %>
               <tr>
                  <td colspan="7">조회된 리스트가 없습니다.</td>
               </tr>
               <% } else {%>
                  <% for(Blacklist bl : list) { %>
                     <tr>
                        <td id="usercheckbox"><input type="checkbox" name="check-btn" value="<%= bl.getBlacklistNo() %>"></td>
                        <td><%= bl.getBlacklistNo() %></td>
                        <td><%= bl.getBlacklistName()%></td>
                        <td><%= bl.getBlacklistUserNo() %></td>
                        <td><%= bl.getBlacklistReason() %></td>
                        <% if(bl.getBlacklistStatus().equals("Y")) { %>
                        <td>정지</td>
                        <% } %>
                        <td><%= bl.getBlacklistDate() %></td>
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
  

  <!-- 블랙리스트 등록 모달창 -->
  <div class="enroll-blacklist-modal">
    <div class="enroll-blacklist-body-modal">
      <button id="blacklist-out">X</button>
      <form action="<%= contextPath %>/insertblacklist.ad" method="post">
        <h2>블랙리스트 등록</h2>
        <!-- 블랙리스트 등록 폼 -->
        <table id="enroll-blacklist-modal-table">
          <tr>
            <td><label for="admin-name">회원 이름 :</label></td>
            <td><input type="text" id="admin-no" name="userId" placeholder="내용을 입력하세요" required></td>
          </tr>
          <tr>
            <td><label for="admin-name">회원 아이디 :</label></td>
            <td><input type="text" id="admin-no" name="blacklist-name" placeholder="내용을 입력하세요" required></td>
          </tr>
          <tr>
            <td><label for="admin-name">제제사유 :</label></td>
            <td>
              <select name="blacklist-reason" id="blacklist-reason">
				<option value="욕설">욕설</option>
				<option value="광고">광고</option>
				<option value="비방">비방</option>
				<option value="도배">도배</option>
				<option value="기타">기타</option>
              </select>
          </td>
          </tr>
          <tr>
            <td><label for="admin-id">날짜 :</label></td>
            <td><input type="date" name="date" required></td>
          </tr>
        </table>
        <br>
        <!-- 블랙리스트 등록 버튼 -->
        <button type="submit" id="blacklist-enroll">등록</button>
      </form>
    </div>
  </div>

  <!-- 블랙리스트 삭제 모달창 -->
  <div class="blacklist-delete-modal">
    <div class="blacklist-delete-modal-body">
      <button id="delete-blacklist-out">X</button>
      <form action="<%= contextPath %>/deleteblacklist.ad" method="post">
      <input type="hidden" name="blacklistNo">
        <h2>정말 삭제하시겠습니까?</h2>
        <!-- 블랙리스트 삭제 버튼 -->
        <button type="submit" id="blacklist-delete">삭제</button>
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
      const enrollBlacklistBoayModal = document.querySelector('.enroll-blacklist-body-modal');
      const enrollBlacklistModal = document.querySelector('.enroll-blacklist-modal');
      const blacklistDeleteModal = document.querySelector('.blacklist-delete-modal');
      const blacklistDeleteModalBody = document.querySelector('.blacklist-delete-modal-body');
      const enrollBlacklist = document.querySelector('#enroll-blacklist');
      const deleteBlacklist = document.querySelector('#delete-blacklist');
      const blacklistOut = document.querySelector('#blacklist-out');
      const deleteBlacklistOut = document.querySelector('#delete-blacklist-out');

    // 생성
      enrollBlacklist.addEventListener('click', () => {
         
        enrollBlacklistModal.classList.toggle('show');

        if (enrollBlacklistModal.classList.contains('show')) {
          enrollBlacklistBoayModal.style.overflow = 'hidden';
        }
      });

      enrollBlacklistModal.addEventListener('click', (event) => {
        if (event.target === enrollBlacklistModal) {
          enrollBlacklistModal.classList.toggle('show');

          if (!enrollBlacklistModal.classList.contains('show')) {
            enrollBlacklistBoayModal.style.overflow = 'auto';
          }
        }
      });

      // 삭제
      deleteBlacklist.addEventListener('click', () => {
         
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
         
         document.getElementsByName('blacklistNo')[0].value = vals.join(",");
         
        blacklistDeleteModal.classList.toggle('show');

        if (blacklistDeleteModal.classList.contains('show')) {
          blacklistDeleteModalBody.style.overflow = 'hidden';
        }
      });

      blacklistDeleteModal.addEventListener('click', (event) => {
        if (event.target === blacklistDeleteModal) {
          blacklistDeleteModal.classList.toggle('show');

          if (!blacklistDeleteModal.classList.contains('show')) {
            blacklistDeleteModalBody.style.overflow = 'auto';
          }
        }
      });

    // 모달창 바깥쪽 클릭시 없어짐
    blacklistOut.addEventListener('click', () => {
        enrollBlacklistModal.classList.remove('show');
        enrollBlacklistBoayModal.style.overflow = 'auto';
      });

      deleteBlacklistOut.addEventListener('click', () => {
        blacklistDeleteModal.classList.remove('show');
        blacklistDeleteModalBody.style.overflow = 'auto';
      });
  </script>
   
</body>
</html>