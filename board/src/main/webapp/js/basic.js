
 console.log('basic js');
 
 //매개값 입력 => 반환
 function sum(n1=0, n2=0) {
	 return n1 + n2;	 
 }
 
 let result = sum(10);
 
  console.log(result);
  
  const sum1 = function(a=0,b=0){
	  return a + b;
  }
  const sum2 = sum1;
  
  console.log(sum1() + sum2(10));
  
  function sum3(n1 = [0, 10]){
	  let result = 0;
	  for(let num of n1){
		  result += num;
	  }
	  return result;
  }
  
  result = sum3([10, 20, 30]);
  console.log(result);

 function showDay(day = []){
	
  	let tr = document.createElement('tr');
  	
  	day.forEach(function(elem){
		  let th = document.createElement('th');
		  th.innerText = elem;
		  tr.appendChild(th);
	})
  	console.log(tr);
  	document.getElementById('header').appendChild(tr);
  }
  
  
  function showDay2(day = []){
	  let tr = document.createElement('tr');
	  for(let word of day){
		  let th = document.createElement('th');
		  th.innerText = word;
		  tr.appendChild(th); 
	  }
	  document.querySelector('#header').appendChild(tr);
  }
  
  
  showDay(['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat']);
  
  
  const showDate = function(start = 1, end = 31){
	  let spaces = getSpaces(5);
	  console.log(start, end);
	  let tr = document.createElement('tr');
	  
	  for(let d= 0; d< spaces; d++){
		  let td = document.createElement('td');
		  td.innerText ='';
		  tr.appendChild(td);
	  }
	  for(let d = start; d<=end; d++){
		  let td = document.createElement('td');
		  td.innerText = d;
		  tr.appendChild(td);
		   if((d+spaces)%7 == 0){
			  document.querySelector('#list').appendChild(tr);
			  tr = document.createElement('tr');
			  
		  }
		  
	  }
	  document.querySelector('#list').appendChild(tr);
  }
  
  showDate(1, getLastDate(5));
  
 //공백계산함수
 function getSpaces(month = 1){
	 switch(month){
		 case 1: return 1;
		 case 4: return 1; 
		 case 5: return 3; 
	 }
 } 
 
 function getLastDate(month = 1){
	 switch(month){
		 case 1: return 31;
		 case 4: return 30;
		 case 5: return 31;
	 }
 }
  
  
  
  
  
  
  
  
  
  
  
  
  
  