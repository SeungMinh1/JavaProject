/**
 * 
 */

 document.getElementById('findBtn').addEventListener('click', e =>{
	 let search = document.getElementById('keyword').value;
	 
	 document.querySelectorAll('#show span').forEach(item => {
		 if(search == item.innerHTML){
			 item.remove();
		 }
	 })
	 document.querySelector('#keyword').value ='';
 })
 