<%@page import="co.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  


	<h3>글등록</h3>
	<form action="addBoard.do" method="post" enctype="multipart/form-data">
	<table border="1" class="table">
		<tr>
			<th>글제목</th><td><input class="form-control" type="text" name="title"></td>
		</tr>
		<tr>
			<th>내용</th><td><textarea name="content"></textarea></td>
		</tr>
		<tr>
			<th>이미지</th><td><input class="form-control" type="file" name="myImg"></input></td>
		</tr>
		<tr>
			<th>작성자</th><td><input class="form-control" type="text" name="writer" value="${logId}" readonly></td>
		</tr>
		<tr>
			<td align="center"><input class="btn btn-primary" type="submit" value="글등록"></td>
		</tr>
	</table>
	</form>
	
