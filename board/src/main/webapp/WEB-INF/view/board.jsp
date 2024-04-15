<%@page import="co.yedam.common.SearchVO"%>
<%@page import="co.yedam.vo.BoardVO"%>
<%@page import="co.yedam.vo.ReplyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="//cdn.datatables.net/2.0.3/css/dataTables.dataTables.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.2/moment.min.js"></script>
<script src ="//cdn.datatables.net/2.0.3/js/dataTables.min.js"></script>
<style>
  div.reply div{
  	margin: auto;
  }
  div.reply ul{
  	list-style-type:none;
  	margin-top:10px;
  }
  div.reply li{
  	padding-top:1px;
  	padding-bottom:1px;
  }
  div.reply span{
    display:inline-block;
 
  }
</style>
<style>
.center {
  text-align: center;
}

.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
  margin: 0 4px;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>


	<%
		BoardVO vo = (BoardVO) request.getAttribute("bvo");
	%>
	  
	<!-- ReplyVO rvo = (ReplyVO) request.getAttribute("rvo"); -->


	<h3>상세 페이지</h3>
	<form name="submitForm" action="modifyForm.do">
	<input type="hidden" name="bno" value="${bvo.boardNo }">
	<input type="hidden" name="page" value="${page }">
	<input type="hidden" name="searchCondition" value="${searchCondition }">
	<input type="hidden" name="keyword" value="${keyword }">
	<table class="table">
		<tr>
			<th>글번호</th><td>${bvo.boardNo }</td>
			<th>글제목</th><td>${bvo.title }</td>
			<th>조회수</th><td>${bvo.viewCnt}</td>
		</tr>
		<tr>
			<th>글내용</th><td colspan="3">${bvo.content }</td>
		</tr>
		<tr>
			<th>작성자</th><td>${bvo.writer }</td>
			<th>작성일시</th><td>${bvo.createDate }</td>
		</tr>
		
		<c:choose>
		<c:when test="${bvo.img != null}">
			<tr>
				<td colspan="4"><img src="upload/${bvo.img }" width="200px"></td>
			</tr>
		</c:when>
		</c:choose>
		<tr>
			<td colspan="4" align="center">
				<button type="submit" class="btn btn-primary">수정</button>
				<button type="button" ${logId != bvo.writer ? 'disabled' : '' } class="btn btn-danger"  onclick="deleteFormFunc()">삭제</button>
			</td>
		</tr>

		
	</table>
	</form>
	
	<div class="header">
		<input class="col-sm-8" id="adddreply">
		<button class="col-sm-2" id="addReply">댓글등록</button>
		<br><br><br>
	
	</div>
	
	<table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                <th>댓글번호</th>
                <th>내용</th>
                <th>작성자</th>
                <th>작성일시</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>댓글번호</th>
                <th>내용</th>
                <th>작성자</th>
                <th>작성일시</th>
            </tr>
        </tfoot>
    </table>
	
	<!--<button onclick="addNewRow()">칼럼추가</button>-->
	<p><button id="button">Delete selected row</button></p>


<!-- <script src ="js/boardService2.js"></script> -->


<script>
	const logId = "${logId}";
	const writer = "${bvo.writer}";
	const bno = "${bvo.boardNo}";
	
	const table = new DataTable('#example', {
	    ajax: 'datatable.do?bno='+bno,
	    columns: [
	        { data: 'replyNo' },
	        { data: 'reply' },
	        { data: 'replyer' },
	        { data: 'replyDate' },
	    ],
	   lengthMenu: [
		   			[5, 10, 25, -1],
		   			[5, 10, 25, 'All']
	   			]
	    
	});
	
	function addNewRow(reply={}) {
	    table.row
	        .add({
	        	replyNo: reply.replyNo,
	        	reply: reply.reply,
	        	replyer: reply.replyer,
	        	replyDate: reply.replyDate
	        })
	        .draw(false);
	}
	 
	//addReply를 클릭하면  ...axaj호출...성공: 화면에 row추가.
		document.querySelector('#addReply').addEventListener('click', function(e){
		let reply =document.querySelector('#adddreply').value;
		if(!logId){
			alert("로그인하세요");
			return;
		}
		if(!reply){
			alert("댓글을 입력하세요");
			return;
		}
		fetch('addReply.do', {
			method: 'post',
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			body:'bno='+bno+'&reply='+reply+'&replyer='+logId
		})
		.then(result => result.json())
		.then(result=>{
			console.log(result);
			if(result.retCode == 'Success'){
				alert('등록성공');
				addNewRow(result.retVal)
			}
		})
		.catch(err=>console.log(err));


	})

	table.on('click', 'tbody tr', (e) => {   //클릭한 tr의 번호를 저장해야되는데
   	 	let classList = e.currentTarget.classList;
		console.log(classList);
		if (classList.contains('selected')) {
			classList.remove('selected');
			console.log(classList);
		}
		else {
			table.rows('.selected').nodes().each((row) => row.classList.remove('selected'));
			classList.add('selected');
			
		}
	});
	
	// document.querySelector('#button').addEventListener('click', function () {
	// 	table.row('.selected').remove().draw(false);
	// });
	document.querySelector('#button').addEventListener('click', function () {
		fetch('removeReply.do', {
			method: 'post',
			headers: {'Content-Type': 'application/x-www-form-urlencoded'},
			body:'bno='+bno
		})
		.then(result => result.json())
		.then(result=>{
			console.log(result);
			if(result.retCode == 'Success'){
				alert('삭제성공');
				table.row('.selected').remove().draw(false);
			}
		})
		.catch(err=>console.log(err));
		
	});
	
	
	
</script>






