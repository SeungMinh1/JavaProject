/**
 * 
 */

import {svc} from './boardService2.js';
console.log(svc);

svc.replyList(bno,replyListFnc2);


function replyListFnc2(result){
	console.log(result);
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
	});

	
	
}



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