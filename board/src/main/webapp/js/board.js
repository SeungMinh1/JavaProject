/**
 * 
 */

//board js


import {svc} from './boardService2.js';
console.log(svc);
let page = 1;
svc.replyList({bno,page},replyListFnc2);


function replyListFnc2(result){
	console.log(result);
	//초기화
	document.querySelectorAll('.content>ul>li[style="display: block;"]').forEach(item=>item.remove());
	
	//5개출력
	result.forEach(elem =>{
		let template = document.querySelector('div.content>ul>li:nth-of-type(3)').cloneNode(true);
		
		console.log(template);
		
		
		template.querySelector('span:nth-of-type(1)').innerText = elem.replyNo;
		template.querySelector('span:nth-of-type(2)').innerText = elem.reply;
		template.querySelector('span:nth-of-type(3)').innerText = elem.replyer;
		template.querySelector('button').addEventListener('click', function(e){
			svc.removeReply(elem.replyNo, 
			// 성공했을때 실행할 함수
			()=> template.remove(), 
			//실패했을때 실행할 함수
			()=> alert('처리중 에러!'));
			
		});
		
		template.style.display='block';
		document.querySelector('div.content>ul').appendChild(template);
		
		//페이지 생성
		svc.pagigList(bno, createPageList);
	});
	
};


function replyListFnc1(result){
		console.log(result);
		result.forEach(elem =>{
			let li = document.createElement('li');
			let span = document.createElement('span');
			span.innerText = elem.replyNo;
			span.className = 'col-sm-2';
			li.appendChild(span);

			span = document.createElement('span');
			span.innerText = elem.reply;
			span.className = 'col-sm-5';
			li.appendChild(span);

			span = document.createElement('span');
			span.innerText = elem.replyer;
			span.className = 'col-sm-2';
			li.appendChild(span);
			
			let btn = document.createElement('button');
			btn.innerText = '삭제';
			btn.className = 'col-sm-2';
			li.appendChild(btn);
			document.querySelector('div.content ul').appendChild(li);
		})
	}


function deleteFormFunc(){
	document.forms[0].action="removeForm.do";
	console.dir(document.forms[0].action);
	document.forms[0].submit();
}

//submitForm
document.querySelector('form[name="submitForm"]').addEventListener('submit', function(e){
	e.preventDefault(); //기본기능 차단
	if(logId == writer){
		this.submit();
	}else{
		alert('권한이 없습니다.');
	}
})



//paging 생성
let pageTarget = document.querySelector('div.pagination');

svc.pagigList(bno, createPageList);


function createPageList(result){
	
	//기존코드가 존재하면 초기ㅗ하
	pageTarget.innerHTML='';
	
	
	console.log(result);
	let totalCnt = result.totalCount;
	let startPage, endPage; //시작페이지 마지막페이지
	let next, prev; //이전,이후
	let realEnd = Math.ceil(totalCnt / 5);
	
	endPage = Math.ceil(page/5) * 5;
	startPage = endPage - 4;
	endPage = endPage>realEnd ? realEnd : endPage;
	
	next = endPage<realEnd ? true : false;
	prev = startPage>1;
	
	//a태그 생성
	if(prev){
		let aTag = document.createElement('a');
		aTag.innerHTML = "&laquo";
		aTag.href = "#";
		aTag.setAttribute('data-page', (startPage -1));
		pageTarget.appendChild(aTag);
	}
	for(let pg = startPage; pg<= endPage; pg++){
		let aTag = document.createElement('a');
		aTag.innerHTML = pg;
		aTag.href = "#";
		aTag.setAttribute('data-page', pg);
		pageTarget.appendChild(aTag);
		if(pg == page){
			aTag.className = 'active';
		}
	}
	if(next){
	let aTag = document.createElement('a');
	aTag.innerHTML = "&raquo";
	aTag.href = "#";
	aTag.setAttribute('data-page', (endPage+1));
	pageTarget.appendChild(aTag);
	}
	
	//pagination 이용
	document.querySelectorAll('.pagination>a').forEach(item =>{
		item.addEventListener('click', function(e){
		e.preventDefault();
		console.log(item.dataset.page);
		page = item.dataset.page;
		svc.replyList({bno,page}, replyListFnc2);
	})
})
	
}//end of createPageList;

//댓글 등록버튼 클릭
document.getElementById('addReply').addEventListener('click', function(e){
	if(!logId){
		alert("로그인 하세요!");
		return;
	}
	if(!reply){
		alert("댓글을 입력 하세요!");
		return;
	}
	let rvo = {
		bno: bno,
		replyer: logId, 
		reply:document.getElementById('reply').value
		};
	
	svc.addReply(rvo, function(result){
		console.log(result);
		if(result.retCode == 'Success'){
			let page =1;
			svc.replyList({bno,page},replyListFnc2);
			document.getElementById('fir').className ='active';
		}else{
			alert('처리중 에러발생');
		}
		
	});
	document.getElementById('reply').value = '';
});







