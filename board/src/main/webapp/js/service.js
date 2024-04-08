/**
 * service.js
 */

const fields = ['memberId', 'memberPw', 'memberNm', 'phone'];

function makeRow(member ={}){
	let tr = document.createElement('tr');
	//td생성
  	fields.forEach(elem=>{
	  let td = document.createElement('td');
	  td.innerText = member[elem] == undefined ? '':member[elem];
	  tr.appendChild(td);
	})
	let btn = document.createElement('button');
	btn.innerText = '삭제';
	btn.addEventListener('click', function(e){
		//데이터 삭제후 화면삭제
		const delHtp = new XMLHttpRequest();
		delHtp.open('get', 'removeMember.do?mid=' + member.memberId);
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
xhtp.open('get', 'memberAjax.do');
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
	let id = document.getElementById('mid').value;
	let nm = document.getElementById('mname').value;
	let ps = document.getElementById('mpw').value;
	let ph = document.getElementById('phone').value;
	
	const addHtp = new XMLHttpRequest();
	addHtp.open('get', 'addMemberAjax.do?mid='+id+'&name='+nm+'&pass='+ps+'&phone='+ph);
	addHtp.send();
	addHtp.onload = function(){
		let result = JSON.parse(addHtp.response);
		const obj = {memberId:id, memberPw:ps, memberNm:nm, phone:ph};
			if(result.retCode == 'Success'){
				alert('등록성공');
				document.getElementById('list').append(makeRow(obj));
			}else if(result.retCode == 'Fail'){
				alert('등록중 에러.');
			}else{
				alert('알수없는 코드입니다.');
			}
		
	}
})



///게시글 등록 삭제 게시글ajax














