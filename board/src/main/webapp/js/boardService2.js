/**
 *  댓글에 쓰는 boardService
 * XMLHttpRequest -> fetch
 */

const n1 = 100;
const n2 = 200;


const svc = {
	//댓글목록 매소드
	replyList(param = {bno: 1,  page: 1}, successCall){
		/*
		let xhtp = new XMLHttpRequest();
		xhtp.open('get', 'replyList.do?bno=' + param.bno + '&page=' +  param.page);
		xhtp.send();
		xhtp.onload = function(){
			let result = JSON.parse(xhtp.response);
			successCall(result);
		}*/
		//fetch
		let url = 'replyList.do?bno=' + param.bno + '&page=' +  param.page
		fetch(url)
			.then(result => result.json()) //body값 -> 자바스크립트 객체.
			.then(successCall)   // function(result2) successCall(result2)
			.catch(function(err){
				console.error(err);
			})
		
	},
	removeReply(rno = 1, successCall, errorCall){
		fetch('removeReply.do?rno='+rno)
		.then(result=>result.json())
		.then(result => {
			if(result.retCode == 'Success'){
				successCall();
			}else{
				errorCall();
			}
		})
		.catch(err=>console.error(err));
		
	},
		
	//페이징 목록
	pagigList(bno=1, successCall){
		fetch('replyCount.do?bno=' +bno)
		.then(result =>result.json())
		.then(successCall)
		.catch(err =>console.log(err));
		
	},
	
	//댓글등록
	addReply(rvo={bno, reply, replyer}, successCall){
		
		fetch('addReply.do', {
			method: 'post',
			headers: {'Content-Type': "application/x-www-form-urlencoded"},
			body: 'bno='+rvo.bno+'&reply='+rvo.reply+'&replyer='+rvo.replyer
		})
		.then(result =>result.json())
		.then(successCall)
		.catch(err => console.error(err));
	} //end of addReply
	
	
 }//end of svc


export {svc};












