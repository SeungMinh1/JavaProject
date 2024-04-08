/**
 *  ajax.js (Asynchranous Javascript and XML) 비동기
 */


/*
setTimeout(function(){
	console.log('code 1')
	
		setTimeout(function(){
		console.log('code 2')
		
			setTimeout(function(){
			console.log('code 3')
			
		}, 2000);
		
	}, 3000);
	
}, 1000);
*/

setTimeout(function(){   //////// 비동기 순서대로가 아니라 끝나는대로 바로처리
	console.log('code 4')
}, 1000);
setTimeout(function(){
	console.log('code 5')
}, 3000);
setTimeout(function(){
	console.log('code 6')
}, 2000);



let xhtp = new XMLHttpRequest(); // 비동기식 처리 대표 객체
xhtp.open('get', 'js/MOCK_DATA.json'); //서버의 파일요청
xhtp.send();
xhtp.onload = function() {
	console.log('1');
	console.log('xhtp: ', xhtp.response);
	console.log(JSON.parse(xhtp.response));
}
console.log('2');
//console.log("xhtp: ", xhtp.response);

































