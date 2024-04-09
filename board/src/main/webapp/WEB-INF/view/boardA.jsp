<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<table class ="table">

	<tr>
	  <td>글제목</td>
	  <td><input type="text" id="title"></td>
	</tr>
	<tr>
	  <td>글내용</td>
	  <td><textarea id="content"></textarea></td>
	</tr>
	<tr>
	  <td>작성자</td>
	  <td><input type="text" id="writer" ></td>
	</tr>
	<tr>
	  <td colspan="2" align="center">
	    <button id="addBtn">등록</button>
	  </td>
	</tr>

</table>

<div id="show">
	<table class="table">
		<tbody id="list"></tbody>
	
	</table>

</div>



<script src="js/boardService.js"></script>