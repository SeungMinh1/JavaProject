<%@page import="co.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ include file="../includes/menu.jsp" %>
<%@ include file="../includes/header.jsp" %>



	<%
		BoardVO vo = (BoardVO) request.getAttribute("bvo");
	%>
	<h3>상세 페이지</h3>
	<form action="modifyForm.do">
	<input type="hidden" name="bno" value="<%=vo.getBoardNo() %>">
	<table class="table">
		<tr>
			<th>글번호</th><td><%=vo.getBoardNo() %></td>
			<th>글제목</th><td><%=vo.getTitle() %></td>
		</tr>
		<tr>
			<th>글내용</th><td colspan="3"><%=vo.getContent() %></td>
		</tr>
		<tr>
			<th>작성자</th><td><%=vo.getWriter() %></td>
			<th>작성일시</th><td><%=vo.getCreateDate() %></td>
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