/**
 * 
 */


const fields = ['boardNo', 'title', 'content', 'writer'];

function makeRow(member={}){
	
	let tr = document.createElement('tr');
	
	fields.forEach(elem=>{
		let td = document.createElement('td');
		td.innerText = member[elem];
		tr.appendChild(td);
	})
	
	let btn = document.createElement('button');
	btn.innerText = '삭제';
	btn.addEventListener('click', function(e){
		const delHtp = new XMLHttpRequest();
		delHtp.open('get', 'removeBoardAjax.do?boardN='+member.boardNo);
		delHtp.send();
		delHtp.onload = function(){
			let result = JSON.parse(delHtp.response);
			if(result.retCode == 'Success'){
				alert('삭제성공');
				tr.remove();
			}else if(result.retCode == 'Fail'){
				alert('삭제처리중 에러.');
			}else{
				alert('알수없는 코드입니다.');
			}
		}
	})
	let td = document.createElement('td');
	td.append(btn);
	tr.append(td);
	return tr;
}


//Ajax 호출`
const xhtp = new XMLHttpRequest();
xhtp.open('get', 'boardAjax.do');
xhtp.send();

xhtp.onload = function(){
	let members = JSON.parse(xhtp.response);
	console.log(members);
	members.forEach(member =>{
		document.getElementById('list').appendChild(makeRow(member));
	})
	
}

//등록버튼
document.getElementById('addBtn').addEventListener('click', function(e){
	//let boardNO = document.getElementById('boardN').value;
	let tit = document.getElementById('title').value;
	let cont = document.getElementById('content').value;
	let wri = document.getElementById('writer').value;
	
	const addHtp = new XMLHttpRequest();
	addHtp.open('get','addBoardAjax.do?title='+tit+'&content='+cont+'&writer='+wri);
	addHtp.send();
	addHtp.onload = function(){
		let result = JSON.parse(addHtp.response);
		const obj = {title:tit, content:cont, writer:wri};
			if(result.retCode == 'Success'){
				alert('등록성공');
				
				document.querySelector('#show>table>tbody').innerHTML='';
				const xhtp = new XMLHttpRequest();
				xhtp.open('get', 'boardAjax.do');
				xhtp.send();
				
				xhtp.onload = function(){
					let members = JSON.parse(xhtp.response);
					console.log(members);
					members.forEach(member =>{
						document.getElementById('list').appendChild(makeRow(member));
					})
					
				}
				//document.getElementById('list').append(makeRow(obj));
				
			}else if(result.retCode == 'Fail'){
				alert('등록중 에러.');
			}else{
				alert('알수없는 코드입니다.');
			}
		
	}
})







