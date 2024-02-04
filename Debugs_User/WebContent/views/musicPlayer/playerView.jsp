<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEBUGS</title>
<link href="resources/css/audio.css" rel="stylesheet">
<link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
<!-- Latest compiled and minified CSS -->
<!-- jQuery library -->
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>


<!-- 	<section class="player"> -->


		<!-- 플레이어 펼친 화면 -->
		<div class="full_player music__list"
			style="height: 100%; width: 100%; background-color: black;">
			<div class="full_player_bg"></div>
			<div class="full_player_inner">
				<div class="player_header full_player_header">
					<button class="player_header_close close">닫기</button>
				</div>
				<div class="full_player_content">
					<!-- 왼쪽 부분 -->
					<div class="content full_player_player music__song">
						<div class="content_box">
							<div>
								<a href="" class="content_title title name">
								</a>
							</div>
							<div class="artist_name">
								<a href="" class="artist_name_link artist">
								</a>
							</div>
							<div class="content_thumbnail">
								<div class="content_thumbnail music__img">
									<img src="<%= request.getContextPath() %>/resources/img/common/앨범커버이미지샘플.jpg">
								</div>
							</div>
						</div>
					</div>
					<!-- 오른쪽 부분 -->
					<div class="playlist full_player_playlist">
						<div class="playerlist_tab">
							<div class="playerlist_tab_inner music__list">
								<div class="title">
									<ul class="playlist_tab_list">
										<li>
											<button class="playlist_tab_1 on">재생목록</button>
										</li>

										<!-- <li>
											<button class="playlist_tab_2">플레이리스트1</button>
										</li>
										
										<li>
											<button class="playlist_tab_3">플레이리스트2</button>
										</li> -->
										
									</ul>

								</div>
								<div class="list">
									<ul>
										<!-- Javascript -->

									</ul>
								</div>
								




							</div>



						</div>

					</div>
				</div>
			</div>
		</div>
<!-- 	</section> -->
			<!-- 으아아ㅏ아아아아아 -->
			<script>
    
        /* 
$(function(){
	$(".playlist_tab_list>li").click(function(){
		const l = $(this).next();
		
		if(l.css("display") == "none"){
			l.css("display", "show");
			l.siblings("div").css("display","none");
		} else {
			l.siblings("div").css("display","none");
		}
	})
}) */
    </script>
			<!-- 으아아ㅏ아아아아아 -->





			<div class="player_ct_mini">
				<section class="playbar_wrap wrap__music">
					<div class="player_seek_wrap music__progress">
						<div class="player_seek_wrap_action bar">
							<!-- 오디오 추가 -->
							<audio id="main-audio" src=""></audio>
						</div>
						<div class="player_seek">
							<div class="player_seek_inner" style="width: 0%;"></div>
							<div class="player_seek_item" style="left: 50%"></div>
						</div>
					</div>
					<div class="playbar_ct music__inner">
						<div class="track_area">
							<div class="thumb music__img">
								<a herf=""><img src="<%= request.getContextPath() %>/resources/img/common/앨범커버이미지샘플.jpg" alt="앨범커버 이미지"></a>
							</div>
							<div class="track_info music__song">
								<a href="" class="title name">재생할 곡을 추가해주세요.</a>
								<div class="artist_name ">
									<a href="" class="artist_name_link artist"></a>
								</div>
							</div>
							<button type="button" class="player_like"></button>
						</div>
						<div class="player_controller music__control">
                     <div class="controller">
                        <button type="button" id="control-repeat"><img src="<%= contextPath %>/resources/img/common/흰색 전체반복.png"></button>
                        <button type="button" id="control-prev"><img src="<%= contextPath %>/resources/img/common/흰색이전곡.png"></button>
                        <div class="control_toggel_play play-pause">
                           <button type="button" id="control-play" class="control-pause"><img src="<%= contextPath %>/resources/img/common/흰색재생버튼.png"></button>
                        </div>
                        <button type="button" id="control-next"><img src="<%= contextPath %>/resources/img/common/흰색다음곡.png"></button>

                     </div>
							<!-- 펼친화면 list에 music__list 추가 예정 -->
						</div>
						<div class="player_side">
							<div>
								<div class="player_time timer">
									<span class="player_time_current current">00:00</span> <span
										class="player_time_duration">/</span> <span
										class="player_time_duration duration">00:00</span>
								</div>
							</div>
							<div class="player_side_right">
								<div class="volume_area">
									<button type="button" class="volume_icon"><img src="<%= contextPath %>/resources/img/common/흰색오디오.png"></button>
									<input type="range" id="vol" name="vol" class="volum_icon"
										min="0" max="100">
									<div class="volume">
										<div class="volume_inner" style="width: 50%;"></div>
										<div class="volume_click"></div>
									</div>
								</div>
								<div class="util_area">
									<button type="button" id="control-list"><img src="<%= contextPath %>/resources/img/common/흰색메뉴버거.png"></button>
								</div>
							</div>

						</div>
					</div>
				</section>

				<script>
        $(function(){
            $(".playlist_tab_list li").click(function(){
                $(this).siblings().children().removeClass("on");
                $(this).children().eq(0).addClass("on");

                //클릭시 비동기 요청으로  simplebar_content안의 내용을 바꿔주기.
                // $.ajax({
                //     url : "/debugs/selectPlayList",
                //     data : {
                //         plNo : 1
                    // li태그 아ㅣㄴ면 button에 pl에 pk값을 저장해서 비동기화에 파라미터로 넘겨라 ㅎ. . .ㅎ.ㅎㅎ.ㅎ.ㅎㅎ...ㅎ.ㅎㅎㅎ.
                //     },
                //     dataType : "html",
                //     success: function(data){
                //         $(".simplebar_content").html(data)
                //     }

                // })
            })  
        })

        $(function(){
            $(".util_area button").click(function(){
                if($(".full_player").css("top") == "0px"){
                    $(".full_player").css("top","50vw");
                    return;
                }
                $(".full_player").css("top","0"); //펼쳐진
            })

            $(".player_header_close").click(function(){
                $(".full_player").css("top","50vw");
            })
        })
        window.onkeyup = function(e) {
         var key = e.keyCode ? e.keyCode : e.which;
         if(key == 27) {
            $(".full_player").css("top","50vw");
         }
      }
        
        
    </script>






	<script src="resources/api/music.js"></script>
				<script>
    const musicWrap = document.querySelector(".wrap__music");
	const musicImg1 = musicWrap.querySelector(".music__img img");
	const musicImg2 = document.querySelector(".music__img img");
    const musicName = document.querySelectorAll(".name");
    const musicArtist = document.querySelectorAll(".artist");
    const musicAudio = musicWrap.querySelector("#main-audio");
    const musicPlay = musicWrap.querySelector("#control-play");
    const musicPrevBtn = musicWrap.querySelector("#control-prev");
    const musicNextBtn = musicWrap.querySelector("#control-next");
    const musicProgress = musicWrap.querySelector(".music__progress");
    const musicProgressBar = musicProgress.querySelector(".bar");
    
    const musicPlayerTime = musicWrap.querySelector(".player_time"); 
    const musicProgressCurrent = musicPlayerTime.querySelector(".current");
    const musicProgressDuration = musicPlayerTime.querySelector(".duration");
    	
    const fullPlayer = document.querySelector(".full_player");
    const playerCtMini = document.querySelector(".player_ct_mini")
    const musicRepeat = musicWrap.querySelector("#control-repeat");
    const musicList = fullPlayer.querySelector(".music__list");
    const MusicListBtn = playerCtMini.querySelector("#control-list");
    const MusicListClose = fullPlayer.querySelector(".close"); 
    const musicListUl = fullPlayer.querySelector(".list ul"); 
    
    const musicVolume = document.getElementById('vol');
    const MusicLike = document.querySelector('.player_like');
    let musicIndex = 1;
    let musicNumber = "";
    
    let musicRepeatTitle = "repeat";

    // 음악 재생
    function loadMusic(num){
    	if(allMusic.length == 0){
    		return;
    	}
        //musicImg1.src = "resources/img/album_pic/"+allMusic[num - 1].img+".jpg";
        musicImg1.src = contextPath+allMusic[num - 1].albumImg;
        //musicImg2.src = "resources/img/album_pic/"+allMusic[num - 1].img+".jpg";
        musicImg2.src = contextPath+allMusic[num - 1].albumImg;

        for(let i = 0;  i<musicName.length; i++){
        	musicName[i].innerText = allMusic[num-1].musicTitle;
        }
        for(let i = 0;  i<musicArtist.length; i++){
        	musicArtist[i].innerText = allMusic[num-1].artistName;
        }
        // 현재 allMusic안의 musicLike값을가지고 하트 꾸며주기 
        const img = document.createElement("img");
        img.src = contextPath+"/resources/img/common/"+(allMusic[num-1].musicLike == 0 ? "흰색하투.png":"흰색꽉찬하트.png");
        $(MusicLike).empty();
        MusicLike.appendChild(img);
        
        //라이크버튼 바꿔주기
        MusicLike.onclick = function(){
        	$.ajax({
        		url : contextPath+"/changeMusicLike",
        		data : {mno :  allMusic[num-1].musicNo},
        		success : function(result) {
        			if(result == "cancel"){
        				MusicLike.querySelector("img").src = contextPath+"/resources/img/common/흰색하투.png";
        				allMusic[num-1].musicLike = 0;
        			}else if(result == "like"){
        				MusicLike.querySelector("img").src = contextPath+"/resources/img/common/흰색꽉찬하트.png";
        				allMusic[num-1].musicLike = 1;
        			}else{
        				alert("좋아요 삽입 실패");
        			}
        		}
        	})
        }
        musicAudio.src = contextPath+allMusic[num - 1].musicPath + allMusic[num - 1].musicChangeName;
        musicNumber = allMusic[num - 1].musicNo;
    }


    // 플레이 버튼
    function playMusic(){
       
        musicWrap.classList.add("paused");
        musicPlay.innerHTML = `<img src='${contextPath}/resources/img/common/흰색일시정지.png'>`;
        musicPlay.setAttribute("title", "일시정지")
        musicAudio.play();
    }

    // 일시정지 버튼
    function pauseMusic(){
        musicWrap.classList.remove("paused");
        musicPlay.innerHTML = `<img src='${contextPath}/resources/img/common/흰색재생버튼.png'>`;
        musicPlay.setAttribute("title", "재생")
        musicAudio.pause();
    }
    
    // 이전 곡 듣기 버튼
    function prevMusic(){
        musicIndex--;
        musicIndex < 1 ? musicIndex = allMusic.length : musicIndex = musicIndex;
        loadMusic(musicIndex);
        playMusic();
        playListMusic();
    }

    // 다음 곡 듣기 버튼
    function nextMusic(){
        musicIndex++;
        musicIndex > allMusic.length ? musicIndex = 1 : musicIndex = musicIndex;
        loadMusic(musicIndex);
        playMusic(); 
        playListMusic();
    }

    // 뮤직 진행바
    musicAudio.addEventListener("timeupdate", (e)=>{
        const currentTime = e.target.currentTime;
        const duration = e.target.duration;
        let progressWidth = (currentTime/duration) * 100;
        musicProgressBar.style.width = progressWidth+"%";

        musicAudio.addEventListener("loadeddata", ()=>{
            let audioDuration = musicAudio.duration;
            let totalMin = Math.floor(audioDuration / 60);
            let totalSec = Math.floor(audioDuration % 60);
            if (totalSec < 10) totalSec = "0"+totalSec;

            musicProgressDuration.innerText = totalMin+":"+totalSec;
        })

        let currentMin = Math.floor(currentTime / 60);
        let currentSec = Math.floor(currentTime % 60);
        if (currentSec < 10) currentSec = "0"+currentSec;
        musicProgressCurrent.innerText = currentMin+":"+currentSec
    })

    // 진행 버튼
    musicProgress.addEventListener("click", e=>{
        let progressWidth = musicProgress.clientWidth;
        let clickedOffsetX = e.offsetX;
        let songDuration = musicAudio.duration;
        
        musicAudio.currentTime = (clickedOffsetX / progressWidth) * songDuration;
        playMusic();
    })




    // 재생/일시정지
    musicPlay.addEventListener("click", ()=>{
        const isMusicPaused = musicWrap.classList.contains("paused");
        isMusicPaused ? pauseMusic() : playMusic();
    })

    musicPrevBtn.addEventListener("click", ()=>{
        prevMusic();
    });
    musicNextBtn.addEventListener("click", ()=>{
        nextMusic();
    });

    // 반복 버튼
    musicRepeat.addEventListener("click", ()=>{
        //let getText = musicRepeat.innerText;
        
        switch(musicRepeatTitle){
            case "repeat" :
               musicRepeatTitle ="repeat_one";
                musicRepeat.innerHTML = `<img src='${contextPath}/resources/img/common/흰색한곡반복.png'>`;
                musicRepeat.setAttribute("title", "한곡 반복")
                
            break;

            case "repeat_one" : 
               musicRepeatTitle ="shuffle";
               musicRepeat.innerHTML = `<img src='${contextPath}/resources/img/common/흰색 셔플아이콘.png'>`;
                musicRepeat.setAttribute("title", "랜덤 반복")
                
            break;

            case "shuffle" : 
               musicRepeatTitle ="repeat";
               musicRepeat.innerHTML = `<img src='${contextPath}/resources/img/common/흰색 전체반복.png'>`;
                musicRepeat.setAttribute("title", "전체 반복")
                
            break;
        }
        playListMusic();
    })
    // 오디오가 끝나고 
    musicAudio.addEventListener("ended", ()=>{
        let getText = musicRepeat.innerText;

        switch(getText){
            case "repeat" :
                nextMusic();
                playListMusic();
            break;

            case "repeat_one" : 
                loadMusic(musicIndex);
                playMusic();
                playListMusic();
            break;

            case "shuffle" : 
                let randIndex = Math.floor((Math.random() * allMusic.length) + 1);
                do {
                    randIndex = Math.floor((Math.random() * allMusic.length) + 1);
                } while (musicIndex == randIndex);
                musicIndex = randIndex;
                loadMusic(musicIndex);
                playMusic();
                playListMusic();
            break;
        }
    })

    
    
    // 리스트리스트
     //뮤직 리스트 버튼
    MusicListBtn.addEventListener("click", ()=>{
        musicList.classList.add("show");
    }) 

    // 뮤직 리스트 닫기 버튼
   MusicListClose.addEventListener("click", ()=>{
     musicList.classList.remove("show");
    }) 
    
    /** 
    	callback? 함수형 데이터 이거나 undefined.
    			  넘어온 데이터가 함수형 데이터라면 실행시킴. kh민경민강사
    */
	function init(callback){
	    // 뮤직 리스트 구현하기
	    for(let i=0; i<allMusic.length; i++){
	        let li = 
	            `<li data-index='${i + 1}'>
	                <div>
	                    <div>${allMusic[i].musicTitle}</div>
	                    <p>${allMusic[i].artistName}</p>
	                </div>
	                <audio class='audio_${allMusic[i].musicNo}' src="${allMusic[i].musicPath}${allMusic[i].musicChangeName}"></audio>
	                <span id='audio_${allMusic[i].musicNo}' class="audio-duration current"></span>
	            </li>`;
	            
	        musicListUl.insertAdjacentHTML("beforeend", li);
			
	        let liAudioDuration = musicListUl.querySelector("#audio_"+allMusic[i].musicNo);
	        let liAudio = musicListUl.querySelector(".audio_"+allMusic[i].musicNo);
	        
	        liAudio.addEventListener("loadeddata", () => {
	            let audioDuration = liAudio.duration;
	            let totalMin = Math.floor(audioDuration / 60);
	            let totalSec = Math.floor(audioDuration % 60);
	            if (totalSec < 10) totalSec = "0"+totalSec;
	
	            liAudioDuration.innerText = totalMin+" : "+ totalSec;
	            liAudioDuration.setAttribute("data-duration", totalMin +" : "+ totalSec);
	        });
	    }
	    
	    if(callback != undefined){
	    	callback(1);
	    }
    }

    // 뮤직 리스트 클릭하기 // 플레이리스트별 음악담는 기능

    
    function playListMusic(){
    	const musicListAll = musicListUl.querySelectorAll("li");
        
    	for(let j=0; j<musicListAll.length; j++){
            let audioTag = musicListAll[j].querySelector(".audio-duration");
            let adDuration = audioTag.getAttribute("data-duration");

            if(musicListAll[j].classList.contains("playing")){
                musicListAll[j].classList.remove("playing");
                audioTag.innerText = adDuration;
            }
            
            if(musicListAll[j].querySelector("#audio_"+musicNumber)){
                musicListAll[j].classList.add("playing");
                
                audioTag.innerText = "재생중";
              	
            }
            musicListAll[j].setAttribute("onclick", "clicked(this)");
       }
    }

    function clicked(el){
        let getLiIndex = el.getAttribute("data-index");
        
        musicIndex = getLiIndex;
        loadMusic(musicIndex);
        playMusic();
        playListMusic();
    }
    
    // 창이 열리면 노래 시작
    window.addEventListener("load", ()=>{
        //loadMusic(musicIndex);
        playListMusic();
    });
    
    musicVolume.addEventListener("change", function(){
    	musicAudio.volume = this.value / 100;
    })
    
    $(function(){
    	if(loginUser != "null" ){
		    $.ajax({
		    	url : contextPath+"/selectUserPlaylist",
		    	
		    	success : function(result){
		    		console.log(result);
		    		if(result == "playFalse"){
		    			return;
		    		}
		    		// 사용자 플레이리스트 목록 불러오기
		    		let count = 2; 
		    		for(let playList of result){
		    			const li = document.createElement("li");
		    			const button = document.createElement("button");
                        li.appendChild(button);
                        button.innerText = playList.playlistSubject;
                        button.setAttribute("class" , "playlist_tab_"+ count++ );
                        button.setAttribute("data-pno" , playList.playlistNo );
                        document.querySelector(".playlist_tab_list").appendChild(li);
		    		}
		    		// 플레이리스트마다 클릭이벤트 부여
		    		$(".playlist_tab_list li").click(function(){
		                $(this).siblings().children().removeClass("on");
		                $(this).children().eq(0).addClass("on");
		                const pno = $(this).children().eq(0).data("pno");
		                console.log(pno);
		                if(pno == undefined){
		                	selectCurrentPlayList( () => false  );
		                	return false;
		                }
		                $.ajax({
		                	url : contextPath+"/selectPlayList",
		                	data : {pno},
		                	success : function(list){
		                		showPlayList(list);
		                	}
		                })
		            })  
		            // 페이지로딩 완료후, 현재재생목록을 비동기식으로 요청을 다 받은후 실행시킬 callback함수를 매개변수로 전달함.
		            selectCurrentPlayList( () => loadMusic(1));
		    	}
		    	
		    	
		    })
  		  	/* init( () => {
	  		  	return setTimeout(() => {
	  		  	  loadMusic(1);
	  		  	}, 100);	
  		  	}); */
		   
    	}
    	//loadMusic(1);
    })
    
   	function showPlayList(list){
    	$(".list ul").empty();
		allMusic = list;
		musicIndex = 1;
		for(let i=0; i<list.length; i++){
			// 경로에 / 추가해야할수도 있음.
			let audio = list[i].musicPath + list[i].musicChangeName;
	        let li = 
	            `<li data-index='${i + 1}'>
	                <div>
	                    <div>${list[i].musicTitle}</div>
	                    <p>${list[i].artistName}</p>
	                </div>
	                <audio class='audio_${list[i].musicNo}' src="${contextPath}${audio}"></audio>
	                <span id='audio_${list[i].musicNo}' class="audio-duration current"></span>
	            </li>`;
	            
	        musicListUl.insertAdjacentHTML("beforeend", li);
			
	        let liAudioDuration = musicListUl.querySelector("#audio_"+list[i].musicNo);
	        let liAudio = musicListUl.querySelector(".audio_"+list[i].musicNo);
	        
	        liAudio.addEventListener("loadeddata", () => {
	            let audioDuration = liAudio.duration;
	            let totalMin = Math.floor(audioDuration / 60);
	            let totalSec = Math.floor(audioDuration % 60);
	            if (totalSec < 10) totalSec = "0"+totalSec;

	            liAudioDuration.innerText = totalMin+" : "+ totalSec;
	            liAudioDuration.setAttribute("data-duration", totalMin +" : "+ totalSec);
	        });
	    }
		playListMusic();
    }
    /**
    	arg?? 선택한 뮤직번호이거나, 함수가 매개변수로 들어옴
    		  함수형 데이터가 넘어온다면 해당함수를 실행시킴(페이지 로딩완료후 플레이어바에 음원정보 표시해주는 함) 2023.07.18 kh민경민강사
    */
    function selectCurrentPlayList(arg){
        $.ajax({
            url : contextPath+"/selectCurrentPlayList",
            success: function(list){
            	if(list != "playFalse"){
	                showPlayList(list.reverse());
            	}
            },
            complete : function(){
            	if(arg != undefined && (typeof arg === 'number' || typeof arg === 'string')){
	                document.querySelector(".audio_"+arg).parentNode.click();//
            	}else if(arg != undefined && typeof arg === 'function' ) {
            		return arg();
	            	//loadMusic(1); //이거 없으면 현재재생목록 못불러옴 근데 있으머ㅕㄴ 플리갓다가 현재재생눌럿을때 1번이 무조건 실행됨 빠큐 빠큐 빠큐 빠큐 빠큐 빠큐 빠큐 ㅗㅗㅗㅗㅗㅗㅗ
            	}else{
            		loadMusic(1);
             	}
            }
        })
    }
    
    
    const slider = document.querySelector('.playerlist_tab .title');
    let isDown = false;
    let startX;
    let scrollLeft;

    slider.addEventListener('mousedown', e => {
      isDown = true;
      slider.classList.add('active');
      startX = e.pageX - slider.offsetLeft;
      scrollLeft = slider.scrollLeft;
    });

    slider.addEventListener('mouseleave', () => {
      isDown = false;
      slider.classList.remove('active');
    });

    slider.addEventListener('mouseup', () => {
      isDown = false;
      slider.classList.remove('active');
    });

    slider.addEventListener('mousemove', e => {
      if (!isDown) return; 
      e.preventDefault();
      const x = e.pageX - slider.offsetLeft;
      const walk = x - startX;
      slider.scrollLeft = scrollLeft - walk;
    });
    
 	</script>
</body>
</html>