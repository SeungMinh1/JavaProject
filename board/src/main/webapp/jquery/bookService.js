/**
 * 
 */


console.log('bookService.js');

$(document).ready(function(){
	
	$('div.register table button:eq(0)').on('click', function(){
		$('#List').append(
				$('<tr />').append(
				  $('<td />').text($('#bookCode').val()),
				  $('<td />').text($('#bookName').val()),
				  $('<td />').text($('#bookAuthor').val()),
				  $('<td />').text($('#bookPrice').val()),
				  $('<td />').append($('<button>삭제</button>').on('click', deleteBook)),
				  $('<td />').append($('<input />').attr('type', 'checkbox').on('click', checkChage))
		
		
		));
		
		//$('#bookCode').val(''); // 초기화
	})
	function deleteBook(e){
		console.log(e.target);
		$(e.target).parent().parent().remove();
	}
	
	$('thead input[type="checkbox"]').on('change', function(){
		let chk = $('thead input[type="checkbox"]').prop('checked');
		$('tbody input[type="checkbox"]').prop('checked', chk);
	})
	
	
	function checkChage(e){
		const allchecked = $('tbody input[type="checkbox"]').length;
		const checked = $('tbody input[type="checkbox"]:checked').length;
		if(allchecked != checked){
			//cosole.log(false)
			$('thead input[type="checkbox"]').prop('checked', false);
		}
		else {
			$('thead input[type="checkbox"]').prop('checked', true);
		}
		
	}

	
	
});
/*
$(document).ready(function(){  
	$('div.list thead tr th input').on('click', function(){
		console.log($('div.list thead tr th input').prop('checked'));
		
		let boool = $('div.list thead tr th input').prop('checked');
		if(boool != true){
			$('input[type="checkbox"]').attr('checked', false);
		}else{
			$('input[type="checkbox"]').attr('checked', true);
		}
		

	})
})*/


$(document).ready(function(){
	$('div.register table button:eq(1)').on('click', function(){
		$('tbody input[type="checkbox"]:checked').parent().parent().remove();
	})
});





