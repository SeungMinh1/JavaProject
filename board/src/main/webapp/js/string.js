/**
 *  string.js
 */


document.querySelector('form').remove()
document.getElementById('show').innerHTML='';

let str1 = new String('hello');
console.log(typeof str1);

let str2 = 'hello';

console.log(str2.trim().toUpperCase().slice(2));

let str3 = 'hello,nice,kind';
console.log(str3.indexOf('nice'));

let str4 = str3.replace('hello', '안녕');
console.log(str3, str4);

let str3Ary = str3.split(",");
console.log(str3Ary);


function checkGender(sso = '981005-1234567'){
	if(sso.length == 14){
		if(sso.substring(7,8) == '1' || sso.substring(7,8) == '3'){
			return console.log('man');
		}else if(sso.substring(7,8) == '2' || sso.substring(7,8) == '4'){
			return console.log('woman');
		}else{
			return console.log('다시입력');
		}
	}if(sso.length == 13){
		if(sso.substring(6,7) == '1' || sso.substring(6,7) == '3'){
			return console.log('man');
		}else if(sso.substring(6,7) == '2' || sso.substring(6,7) == '4'){
			return console.log('woman');
		}else{
			return console.log('다시입력');
		}
	}

}


let numbers = ['990102-2345678', '010204-3123456', '0303044123456', '970304 1123456']
numbers.forEach(elem => checkGender(elem));

/*
function checkGender(sso = '981005-1234567'){
	let genChar = sso.replace(/\w/, '');
	switch(genChar.charAt(6)){
		case '1' :
		case '3' : console.log('man');  break;
		case '2' :
		case '4' : console.log('woman');  break;
	}
}
*/


console.clear();

const today = new Date(); //실행시점의 시스템시간.
console.log(today);
today.setFullYear(2020);
today.setMonth(0);
today.setDate(1-1);

console.log('말일', today.getDate());


console.log(today.getFullYear()); //년도
console.log(today.getMonth() + 1); // 월 (0부터시작)
console.log(today.getDate()); // 날짜
console.log(today.getHours()); // 분
console.log(today.getMinutes()); // 분
console.log(today.getSeconds()); // 초
console.log(today.getDay()); // 요일 (0~6)


const show = document.querySelector('#show');

function createCalendar(year = 2024, month = 4){
	show.innerHTML = "<input type='text'>";
	show.innerHTML ="<h3>" + year + "년" + month +"월"+"</h3>";
	let table = document.createElement('table');
	table.className = 'table';
	

	show.appendChild(table);
	//요일출력
	//날짜출력
	
	//말일 찾기
	let ndate = new Date();
	ndate.setFullYear(year);
	ndate.setMonth(month);
	ndate.setDate(1-1);
	let lastday = ndate.getDate();
	//space 찾기
	ndate.setFullYear(year);
	ndate.setMonth(month-1);
	ndate.setDate(1);
	console.log(ndate.getDay());
	let space = 0;
	switch(ndate.getDay()){
		case 0: space=0; break;
		case 1: space=1; break;
		case 2: space=2; break;
		case 3: space=3; break;
		case 4: space=4; break;
		case 5: space=5; break;
		case 6: space=6; break;
	}
	
	
	//날짜
	const days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'];
	
	let tr = document.createElement('tr');
  	
  	days.forEach(function(elem){
		  let th = document.createElement('th');
		  th.innerText = elem;
		  tr.appendChild(th);
	})
  	console.log(tr);
  	table.appendChild(tr);
  	
	let start = 1;
	let end = lastday;
	tr = document.createElement('tr');
	  
 	for(let d= 0; d< space; d++){
	  let td = document.createElement('td');
	  td.innerText ='';
	  tr.appendChild(td);
  	}
  	for(let d = start; d<=end; d++){
	  let td = document.createElement('td');
	  td.innerText = d;
	  tr.appendChild(td);
	   if((d+space)%7 == 0){
		  table.appendChild(tr);
		  tr = document.createElement('tr');
		  
	  	}
  	}
 	 table.appendChild(tr);
	
}

createCalendar()

let timer = document.getElementById('timer');

setInterval(function() {
	let now = new Date();
	timer.innerHTML =now.format();
	
}, 1000);

Date.prototype.format = function(){
	let yyyy = this.getFullYear();
	let MM = this.getMonth() + 1;
	let dd = this.getDate();
	let hh = this.getHours();
	let mm = this.getMinutes();
	let ss = this.getSeconds();
	
	return yyyy +"/" + ("0" + MM).slice(-2) + "/" +("0" + dd).slice(-2)//
	+ " " + ("0" + hh).slice(-2) + ":" + ("0" + mm).slice(-2) +":"+("0" + ss).slice(-2);
}
















