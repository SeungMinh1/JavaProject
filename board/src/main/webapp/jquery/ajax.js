/**
 * 
 */


$(document).ready(function(){
	//페이지 로딩후 목록출력 'memberAjax.do'
	//fetch().then().then().catch()
	$.ajax({
		url: '../memberAjax.do',
		method: 'get',
		dataType: 'json' //JSON.parse()
	})
	.done(function(result){
		console.log(result);
		//목록출력 id, 이름, 연락처, 비번 => 작성.
		result.forEach(member => {
			$('<tr />').append($('<td />').text(member.memberId),
							$('<td />').text(member.memberNm),
							$('<td />').text(member.phone),
							$('<td />').text(member.memberPw))
							.appendTo($('#ttbody'))
		})
		
	})
	.fail(function(err){
		console.error(err);
	})
	.always(function(data){
		//console.log(data)
	})
	
	
	//등록버튼 이벤트
	$('div.register button').on('click', function(e){  //form[name="myFrm"]'
		e.preventDefault();
		ajax({
			url:'../addMemberAjax.do',
			method: 'post',
			data: $('form[name="myFrm"]').serialize() ,// 전송데이터
			dataType: 'join'
		})
		.done(function(result){
			console.log(result);
		})
		.fail(function(err){
			console.log(err);
		})
	})
	
	
	
	
	
	
	
	
	
	
	
	
	
	
})