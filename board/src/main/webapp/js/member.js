/**
 *  member.js
 */

 
document.querySelector('#show>table').innerHTML='';
const fields = ['id', 'first_name', 'last_name', 'email', 'gender', 'salary'];

const tab = document.querySelector('#show>table');
tab.appendChild(makeHeader()); //thead
tab.appendChild(makeBody()); //tbody

//thead 생성. 아이디/이름/이메일/성별/급여
function makeHeader(){
	//thead 생성. tr생성
	let thd = document.createElement('thead');
	let tr = document.createElement('tr');
	thd.appendChild(tr);
	fields.forEach(field =>{
		let th = document.createElement('th');
		th.innerHTML = field;
		tr.appendChild(th);
	});
	return thd;
}

//tbody 생성. 
function makeBody(){
	let thd = document.createElement('tbody');
	members.forEach((elem, idx) => {
		console.log(elem, idx);
		if(idx<25 && elem.gender =='Male'){
			thd.appendChild(makeRow(elem));
		}
		
	});
	return thd;
}
	
//row 생성
function makeRow(member = {}){
	let tr = document.createElement('tr');
	fields.forEach(field =>{
		let td = document.createElement('td');
		td.innerHTML = member[field];
		tr.appendChild(td);
		
		//console.log(tr.children[0].innerHTML);
		//document.querySelectorAll('tr').addEventListener('click', e=>
		//	document.getElementById('mid').value = tr.children[0].innerHTML)
	})
	
	
	//버튼추가
	let btn = document.createElement('button');
	btn.innerText = '삭제';
	btn.addEventListener('click', e=>btn.parentElement.parentElement.remove());
	let td = document.createElement('td');
	td.appendChild(btn);
	tr.appendChild(td);
	return tr;
}




//저장버튼 이벤트

document.getElementById('addBtn').addEventListener('click', function(e) {
	console.log('message')
});


console.dir(document.forms[0]);
document.querySelector('form:nth-of-type(1)').addEventListener('submit', function(evt){
	console.log(evt)
	evt.preventDefault();
	
	//id, fname, lname, email, gender, salary => 입력값
	const userVal = {}
	userVal.id = document.getElementById('mid').value;
	userVal.first_name = document.getElementById('fname').value;
	userVal.last_name = document.getElementById('lname').value;
	userVal.email = document.getElementById('email').value;
	userVal.gender = document.getElementById('gender').value;
	userVal.salary = document.getElementById('salary').value;
	
	let tr = makeRow(userVal);
	
	document.querySelector('#show tbody').appendChild(tr);
	
	
})


//수정처리
document.querySelectorAll('#show tbody tr').forEach(item =>{
	//console.log(item.children[0].innerHTML);	
	item.addEventListener('click', e=>(
		document.getElementById('mid').value= item.children[0].innerHTML,
		document.getElementById('fname').value= item.children[1].innerHTML,
		document.getElementById('lname').value= item.children[2].innerHTML,
		document.getElementById('email').value= item.children[3].innerHTML,
		document.getElementById('gender').value= item.children[4].innerHTML,
		document.getElementById('salary').value= item.children[5].innerHTML
		
	))
});
	



















