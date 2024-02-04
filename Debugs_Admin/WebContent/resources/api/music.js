let allMusic = [
];

function addCurrentPlayList(mno){
	$.ajax({
        url : contextPath+"/addCurrentPlayList",
        data: {mno},
        success: function(result){
        	if(result == "loginFalse"){
        		//로그인 안함
        		alert("로그인후 이용해주세요!");
        		return;
        	}else if(result == "playFalse"){
        		//이용권 구매안함
        		alert("이용권 구매 후 이용해주세요!");
        		return;
        	}
        	
        	console.log(result);
            $(".playlist_tab_1").click();
            selectCurrentPlayList(mno);
        }
	})
}

function addCurrentPlayListAll(pno){
	$.ajax({
        url : contextPath+"/addCurrentPlayListAll",
        data: {pno},
        success: function(result){
        	console.log(result);
        	if(result == "loginFalse"){
        		//로그인 안함
        		alert("로그인후 이용해주세요!");
        		return;
        	}else if(result == "playFalse"){
        		//이용권 구매안함
        		alert("이용권 구매 후 이용해주세요!");
        		return;
        	}
        	
        	if(result == "-1"){// 테스트용
        		alert("플리가 비었습니다");
        		return false;
        	}
            selectCurrentPlayList(result); // result :: 첫번째 플리번호임..
            $(".playlist_tab_1").click();
        }
	})
}

function playRecommend(){
    //musicno값들 불러오기
    let musicNos = [];
    $(".hidden-music-no").each(function(index,item){
        musicNos.push(item.value);
    });
    $.ajax({
        url : contextPath+"/playRecommend",
        data : {musicNos : musicNos.join(",")},
        success : function(result){
        	console.log(result);
        	if(result == "loginFalse"){
        		//로그인 안함
        		alert("로그인후 이용해주세요!");
        		return;
        	}else if(result == "playFalse"){
        		//이용권 구매안함
        		alert("이용권 구매 후 이용해주세요!");
        		return;
        	}
        	
            selectCurrentPlayList(musicNos[0]);
            $(".playlist_tab_1").click();
        }
    })
}
