<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>footer</title>
<link rel="stylesheet" href="resources/css/footer.css" />
</head>
<body>
<!-- 성공 메세지 팝업 -->
<div class="success_msg">
   	추가되었습니다
</div>

<!-- 듣기 미니 팝업 -->
<div class="play_popup_outer">
    <div class="play_popup">
        <div id="uncheck" onclick="uncheck();">
            <img src="resources/img/musiclist/check_button.png"> <br>
            선택해제
        </div>
        <div onclick="checkListen();">
            <img src="resources/img/musiclist/play_button2.png"> <br>
            듣기
        </div>
        <div class="my_list" onclick="checkPlaylist();">
            <img src="resources/img/musiclist/folder_button2.png"> <br>
            담기
        </div>
    </div>
</div>


<!-- 듣기 미니 팝업 > 담기 > 플레이리스트 확인 팝업 -->
<div class="my_list_popup_outer" id="my_list_popup">
    <div class="my_list_popup">
        <h1>플레이리스트 추가</h1>
        <div>
            <p class="playlist_title">My Playlist</p>
            <button class="new_playlist">+ 새 플리 만들기</button>
            
            <div class="add_playlist">
			   	새 플리 만들기
			   	<hr>
			   	제목 : <input class="add_playlist_subject" name="add_playlist_subject" type="text" style="width:200px" placeholder="제목을 입력해주세요" required >
			   	<div class="button">
			    	<button class="add_save" type="submit">저장</button>
			    	<button class="add_cancel">취소</button>
			   	</div>
			   </div>    
        </div>
    </div>	
</div>
    
<footer id="footer" role="contentinfo" class="">
        <div class="footer_inner">
            <div class="debugs_fnb">
                <ul class="footer_title">
                    <li><a href="" class=""> 고객센터</a></li>
                    <li><a href="" class=""> 공지사항 </a></li>
                </ul>
                <ul>
                    <li class="footer_title">debugs 서비스</li>
                    <li><a href="" class=""> debugs 크리에이터 스튜디오 </a></li>
                    <li><a href="" class=""> debugs 플레이어 다운로드 </a></li>
                    <li><a href="" class=""> 서비스 소개 </a></li>
                </ul>
                <ul>
                    <li class="footer_title">기업 정보</li>
                    <li><a href="" target="_blank">회사소개</a></li>
                    <li><a href="" target="_blank">인재 채용</a></li>
                </ul>
                <ul class="inquiry_area">
                    <li class="footer_title">문의</li>
                    <li><a href="">마케팅・광고・제휴 문의</a></li>
                    <li><a href="">서비스 이용 문의</a></li>
                    <li><a href="">음원 유통 문의</a></li>
                </ul>
            </div>
            <div class="social_area">
                <ul>
                    <li><a href="" target="_blank"
                            class="btn-facebook"><span class="hidden">facebook 바로 가기</span></a></li>
                    <li><a href="" target="_blank"
                            class="btn-instagram"><span class="hidden">instagram 바로 가기</span></a></li>
                    <li><a href="" target="_blank"
                            class="btn-youtube"><span class="hidden">youtube 바로 가기</span></a></li>
                    <li><a href="" target="_blank" class="btn-twitter"><span
                                class="hidden">twitter 바로 가기</span></a></li>
                </ul>
            </div>
            <div class="policy_area">
                <ul>
                    <li><a href="" class="" target="_blank"> 이용약관 </a></li>
                    <li><a href="" class="" target="_blank"><em>개인정보 처리방침</em></a></li>
                    <li><a href="" class="" target="_blank"> 청소년 보호정책 </a></li>
                    <li><a href="" target="_blank">사업자정보 확인</a>
                    </li>
                </ul>
            </div>
            <address>
                <div class="inner">
                    <div class="address_top"><span>대표이사 : 정동현</span><span>사업자 등록번호&nbsp;: 대충 번호 아무거나</span><span>통신판매업
                            신고번호&nbsp;: 2008-서울서초-1039</span></div>
                    <div class="address_bottom"><span>서울특별시 서초구 강남대로 311 드림플러스 15F</span><span>8947-9537</span><span>
                        debugs@music-debugs.com</span></div>
                </div>
            </address>
            <p class="copyright"><span>(주)1등조컴퍼니</span>ALL RIGHTS RESERVED</p>
            <p class="browser_support">본 사이트는 Chrome 및 Microsoft Edge 브라우저에서 사용 가능합니다.</p>
        </div>
    </footer>
    
    <script src="resources/js/musiclist.js"></script>
    <script src="resources/js/playlist.js"></script>
    <script src="resources/js/search.js"></script>
</body>
</html>