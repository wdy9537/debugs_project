/* 듣기 미니 팝업 관련 JS */
const chk = $("input[name=music_list]").length;

/* 체크버튼 전부 선택 */
$("#all_check").click(function(){
    if($(this).is(":checked")){
        $("input[name=music_list]").prop("checked",true);
    } else {
        $("input[name=music_list]").prop("checked",false);
    };
});

/* 체크버튼 전부 해제 */
$("input[name=music_list]").change(function(){
    let chk2 = $("input[name=music_list]:checked").length;

    if ( $(this).is(":checked") ){
        $(".play_popup_outer").css("display","block");
    } else {
        if ( chk2 == 0 ) {
            $(".play_popup_outer").css("display","none");
        }

        if ( chk > chk2 ) {
            $("#all_check").prop("checked",false);
        }

    }
});

/* 선택해제 */
function uncheck(){
	$("input[name=music_list]").prop("checked",false);
	$(".play_popup_outer").css("display","none");
}

/* 듣기 : 노래 리스트에서 체크박스 선택 후 나오는 미니 팝업에서 듣기를 눌렀을 경우, 체크된 노래들 현재 재생 목록에 추가 */
function checkListen(){
	$("td>input[name=music_list]:checked").each(function(){
		addCurrentPlayList($(this).val());
		uncheck();
	})
}


/* 미니팝업 담기 > 플레이리스트 추가 > 체크된 음악들을 원하는 플레이리스트에 추가 */
function checkPlaylist(){
	$("#my_list_popup").addClass("show");
	show_playlist("check", 0);
}

/* 담기 클릭하면 해당 열의 음악을 플레이리스트 삽입 */
function myListAdd(num){
   if ( loginUser != "null") { 
      $("#my_list_popup").addClass("show");
      show_playlist("my", num);
   } else {
      alert ( "로그인 후 이용 ㅇㅇ");
   }
}


function insertPlaylistMusic(plNo, mNo){
	$.ajax({
		url : "insertMy.pl",
		data : { 
			musicNo : mNo,
			plNo: plNo
		 },
		success : function(result){
			$(".my_list_popup_outer").removeClass("show");
      		$(".add_playlist").removeClass("show");
      		if (result > 0) {
				successMsg();
			} else {
				alert("이미 등록된 곡입니다")
			}
		}
	})
}

/* 외부영역 클릭시 플레이리스트 팝업 닫기 */
$(document).mouseup(function (e) {
    if($(".my_list_popup_outer").has(e.target).length === 0){
        $(".my_list_popup_outer").removeClass("show");
        $(".add_playlist").removeClass("show");
		$(".my_list_list").remove();
		$(".my_list_list3").remove();
    }
});

/* 현재 회원정보로 플레이리스트 목록 불러오는 ajax */
function show_playlist(type, musicNo){
	$.ajax({
		url : "show.pl",
		success : function(list){
			let result = "";
			for ( let pl of list ) {
				result += "<div class='my_list_list'>" 
				+"<input type='hidden' id='playlist_no' value='"+pl.playlistNo+"'>"
					+ "<table width='100%'>"
					  + "<tr>"
					  +"<th rowspan='2' width='80px' height='80px'>"
					  	+"<img src='resources/img/"+( ( pl.th1 == null ) ? "playlist_pic/"+pl.playlistTh : "album_pic/" + pl.th1 )+"'>"
					  	+"</th>" 
                        + "<td>"+pl.playlistSubject+"</td>"
                    +"</tr>"
                    +"<tr>"
                        +"<td>총 "+pl.count+" 곡</td>"
                    +"</tr>"
                +"</table>"
                +"</div>"
			}
		$(".my_list_list").remove();
		$(".my_list_list3").remove();
		$(".my_list_popup>div").append(result);
		},
		complete : function(){
			if ( type == "my" ) { 
				$(".my_list_list").each(function(i,e){
					e.addEventListener("click" , function(){
						const playlistNo = $(this).children($(".playlist_no")).val();
						insertPlaylistMusic(playlistNo, musicNo);
					})
				})
			}
			if ( type == "check") {
				$(".my_list_list").each(function(i,e){
					e.addEventListener("click" , function(){
						const playlistNo = $(this).children($(".playlist_no")).val();
						$("td>input[name=music_list]:checked").each(function(){
							$.ajax({
								url : "insertMy.pl",
								data : { 
									musicNo : $(this).val(),
									plNo: playlistNo
								 },
								success : function(){
									show_playlist("check", 0);
									successMsg();
								}
							})
						})
					})
				})
			}
			if ( type == "pl" ) {
				$(".my_list_list").each(function(i,e){
				e.addEventListener("click" , function(){
					const playlistNo = $(this).children($(".playlist_no")).val();
					const copyPlNo = musicNo;
					$.ajax({
						url : "copy.pl",
						data : { 
							copy : copyPlNo,
							plNo: playlistNo
						 },
						success : function(){
							$(".my_list_popup_outer").removeClass("show");
      						$(".add_playlist").removeClass("show");
							successMsg();
						}
					})
				})
			})
			}
		}
	});
}


/* 담기 > 플레이리스트추가 > 새플리만들기 */
$(".new_playlist").click(function(){
	$(".add_playlist").addClass("show");
})
$(".add_cancel").click(function(){
	$(".add_playlist").removeClass("show");
})

/* 제목 입력 후 저장 누르면 새 플레이리스트 생성하는 ajax */
$(".add_save").click(function(){
	$.ajax({
		url : "add.pl",
		data : {
				add_playlist_subject: $("input[name=add_playlist_subject]").val()
			},
		success : function(){
			show_playlist();
			$(".add_playlist").removeClass("show");
			$("input[name=add_playlist_subject]").val("")
		}
	})
})

        
/* 재생 아이콘 클릭하면 해당 열의 음원을 현재 재생에 추가하기 */
$(".now_play").each(function(){
	$(this).click(function(){
		const musicNo = $(this).siblings().children('#music_list').val();
		$.ajax({
			url : "listen.pl",
			data : {
				musicNo : musicNo
			},
			success : function(result){
				if (result > 0) {
    				successMsg();
				} else {
					alert("이미 등록된 곡입니다")
				}
			}
		});
	});
});

/* 삭제 아이콘 클릭하면 해당 열의 음악을 플레이리스트에서 삭제 후 해당 페이지 새로고침 */
$(".delete_music").each(function(){
	$(this).click(function(){
		const musicNo = $(this).siblings().children('#music_list').val();
		const plNo = $("#playlist_no").val();
		
		$.ajax({
			url : "delete.pl",
			data : {
				musicNo : musicNo,
				plNo: plNo
			},
			success : function(){
				alert("삭제 되었습니다");
				document.location.reload();
			}
		});
		
	});
});



/* 좋아요 클릭시 아이콘 변경 및 좋아요 DB 저장/삭제 */
$(".music_like").each(function(){
	$(this).click(function(){
		const musicNo = $(this).siblings().children('#music_list').val();
		$.ajax({
			url : "music.like",
			data : { musicNo : musicNo }, 
			context : this,
			success : function(result){
				if ( result == 1 ) {
					$(this).children("img").attr("src", "resources/img/musiclist/like_button.svg");
				} else {
					$(this).children("img").attr("src", "resources/img/musiclist/like_button_on.png");
				}
			}
		});
	})
});

/* 아티스트 이름 클릭시 아티스트 이름으로 검색된 페이지 연결 */
$(".artist_name").each(function(){
	$(this).click(function(){
		location.href = "search.li?keyword="+$(this).text();
	});	
});


/* 차트페이지 : 순위 색상 css */
$(".rank").each(function(index, item){
    switch ( $(item).text() ) {
        case '1': $(this).addClass("rank_1");break;
        case '2': $(this).addClass("rank_2");break;
        case '3': $(this).addClass("rank_3");break;
    } 
})
	

