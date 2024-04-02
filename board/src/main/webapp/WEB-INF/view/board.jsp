<%@page import="co.yedam.common.SearchVO"%>
<%@page import="co.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../includes/menu.jsp" %>
<%@ include file="../includes/header.jsp" %>



	<%
		BoardVO vo = (BoardVO) request.getAttribute("bvo");
	%>
	<h3>상세 페이지</h3>
	<form action="modifyForm.do">
	<input type="hidden" name="bno" value="${bvo.boardNo }">
	<input type="hidden" name="page" value="${page }">
	<input type="hidden" name="searchCondition" value="${searchCondition }">
	<input type="hidden" name="keyword" value="${keyword }">
	<table class="table">
		<tr>
			<th>글번호</th><td>${bvo.boardNo }</td>
			<th>글제목</th><td>${bvo.title }</td>
		</tr>
		<tr>
			<th>글내용</th><td colspan="3">${bvo.content }</td>
		</tr>
		<tr>
			<th>작성자</th><td>${bvo.writer }</td>
			<th>작성일시</th><td>${bvo.createDate }</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<button type="submit" class="btn btn-primary">수정</button>
				<button type="button" class="btn btn-danger"  onclick="deleteFormFunc()">삭제</button>
			</td>
		</tr>
		
	</table>
	</form>
<script>
	function deleteFormFunc(){
		document.forms[0].action="removeForm.do";
		console.dir(document.forms[0].action);
		document.forms[0].submit();
	}
</script>

<%@ include file="../includes/footer.jsp" %>