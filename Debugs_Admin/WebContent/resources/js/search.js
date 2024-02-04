/* 검색결과화면 페이지 */
function artistPlay(aNo){
	let artistNo = aNo;
	
	$.ajax({
		url : "listen.pl",
		data : { artistNo : aNo, type: "search" },
		success : function(result){
			alert(result);
		}
	})
};