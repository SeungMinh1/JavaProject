/**
 * func.js
 */


const data = ['Apple', 'Banana', 'Cherry'];

document.querySelector('#show').innerHTML='';

let ul = document.createElement('ul');
document.querySelector('#show').appendChild(ul);
//화살표 함수
data.forEach(elem =>{
	let li = document.createElement('li');
	li.addEventListener('mouseover', e => li.style.background = 'red');
	li.addEventListener('mouseout', e => li.style.background = '');
	li.innerText = elem;
	let btn = document.createElement('button');
	btn.innerText = '삭제';
	btn.addEventListener('click', e => btn.parentElement.remove()); //이벤트유형, 이벤트 핸들러
	
	li.appendChild(btn);
	ul.appendChild(li);
	
});