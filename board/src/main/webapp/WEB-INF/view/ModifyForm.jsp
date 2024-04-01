<%@page import="co.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ include file="../includes/menu.jsp" %>
<%@ include file="../includes/header.jsp" %>

<%
	BoardVO vo = (BoardVO) request.getAttribute("bvo");
%>
	<form action="modifyBoard.do">
	<input type="hidden" name="boardNo" value="<%=vo.getBoardNo() %>">
	<table border="2" class="table">
		<tr>
			<th>글번호</th><td><%=vo.getBoardNo() %></td>
			<th>글제목</th><td><input type="text" name="title" value="<%=vo.getTitle() %>"></td>
		</tr>
		<tr>
			<th>글내용</th><td colspan="3"><textarea name="content"><%=vo.getContent() %></textarea></td>
		</tr>
		<tr>
			<th>작성자</th><td><%=vo.getWriter() %></td>
			<th>작성일시</th><td><%=vo.getCreateDate() %></td>
		</tr>
		<tr>
			<td colspan="4">
				<button type="submit">저장</button>
				<!--  <button type="button">삭제</button>-->
			</td>
		</tr>
		
	</table>
	</form>
	
<%@ include file="../includes/footer.jsp" %>