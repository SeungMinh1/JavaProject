<%@page import="co.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  


<%
	BoardVO vo = (BoardVO) request.getAttribute("bvo");
%>
	<form action="modifyBoard.do">
	<input type="hidden" name="boardNo" value="${bvo.boardNo }">
	<input type="hidden" name="page" value="${page }">
	<input type="hidden" name="searchCondition" value="${searchCondition }">
	<input type="hidden" name="keyword" value="${keyword }">
	<table class="table">
		<tr>
			<th>글번호</th><td>${bvo.boardNo }</td>
			<th>글제목</th><td><input type="text" name="title" value="${bvo.title }"></td>
		</tr>
		<tr>
			<th>글내용</th><td colspan="3"><textarea name="content">${bvo.content }</textarea></td>
		</tr>
		<tr>
			<th>작성자</th><td>${bvo.writer }</td>
			<th>작성일시</th><td>${bvo.createDate }</td>
		</tr>
		<tr>
			<td colspan="4">
				<button type="submit">저장</button>
				<!--  <button type="button">삭제</button>-->
			</td>
		</tr>
		
	</table>
	</form>
	
