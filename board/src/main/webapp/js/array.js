/**
 *  array.js
 */


document.querySelector('form').remove();
document.getElementById('show').innerHTML='';

const fruits = ['사과'];
fruits.push('수박');
fruits.push('복숭아');
fruits.pop();
fruits.unshift('포도');
fruits.shift();


fruits.splice(1,0, '참외');
fruits.splice(1,1);


console.log(fruits);


const members = [{name:"홍길동", age: 20}];
members.push({name:"김길동" , age:21});
members.push({name:"박길동" , age:20});


members.forEach(elem =>{
	console.log(elem);
})

//filter 반환 :배열반환
let result = members.filter(elem => elem.age>20);

// map : -> A'
result = members.map(elem =>{
	let obj ={};
	obj.fullName = elem.name;
	obj.age = elem.age;
	obj.point = 100;
	
	return obj;
})

result = [10,20,30,40,23,15].reduce((acc, elem, idx, ary) =>{
	console.log(acc, elem, idx, ary);
	if(idx+1 == ary.length){
		return (acc + elem)/ary.length;
	}
	return (acc + elem); // acc활용
}, 0);

console.log(result);

let ul = document.createElement('ul');
document.getElementById('show').appendChild(ul);
members.reduce((acc, elem) => {
	let li = document.getElementById('li');
	li.innerHTML = '이름: ' + elem.name + ', 나이: ' + elem.age;
	acc.appendChild(li);
	return acc;
},ul);




