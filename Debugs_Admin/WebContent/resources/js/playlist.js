/* 플레이리스트 */
/* 현재 플레이리스트 재생목록에 그대로 추가하기 */
function allPlay(){
	$.ajax({
		url: "insert.pl",
		data: { 
			playlistNo : $("#playlist_no").val(),
			type : "all"
		},
		success : function(result){
			if (result > 0) {
				successMsg();
			} else {
				alert("이미 등록된 곡입니다")
			}
		}
	})
}

/* 현재 플레이리스트 재생목록에 랜덤하게 추가하기 */
function shufflePlay(){
	$.ajax({
		url: "insert.pl",
		data: { 
			playlistNo : $("#playlist_no").val(),
			type : "shuffle"
		},
		success : function(result){
			if (result > 0) {
				successMsg();
			} else {
				alert("이미 등록된 곡입니다")
			}
		}
	})
}

/* 음원 추가 성공메세지 */
function successMsg(){
	$(".success_msg").fadeIn(100, function(){
		$(this).fadeOut(1000);
	})
};

/* 추천 상세페이지에서 플레이리스트 클릭시 해당 플레이리스트의 상세 페이지로 접속하기 */
$(".playlist_list_img").each(function(){
	$(this).click(function(){
		plno = $(this).siblings("#playlist_no").val();
		location.href = "detail.pl?plno="+plno;
	});
})

$(".playlist_list_comment").each(function(){
	plno = $(this).siblings("#playlist_no").val();
	$(this).children(".middle_title_name").click(function(){
		location.href = "detail.pl?plno="+plno;
	});
})

function insertMyPlaylist(plNo){
   if ( loginUser != "null") { 
      $("#my_list_popup").addClass("show"); // 팝업을 보여줌 
    show_playlist("pl", plNo); // 리스트를 보여줌 
   } else {
      alert ( "로그인 후 이용해주세요" );
   }
}

