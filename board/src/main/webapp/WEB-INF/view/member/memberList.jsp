<%@page import="co.yedam.common.PageDTO"%>
<%@page import="co.yedam.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  

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

<!-- 검색조건 추가. -->

<!-- 검색조건 추가. -->

<h3>회원목록 </h3>
<%
	List<MemberVO> list = (List<MemberVO>) request.getAttribute("mlist");
%>
<p>${blist}</p>
<p>${paging}</p>

<table class="table">
	<thead>
		<tr>
			<th>회원ID</th><th>회원PW</th><th>회원이름</th><th>날짜</th><th>회원PHONE</th>
		</tr>
</thead>
<tbody>

<c:forEach var="vo" items="${mlist}">
	<tr>
		<td><c:out value="${vo.memberId}"></c:out></td>
		<td><c:out value="${vo.memberPw }" /></td>
		<td><c:out value="${vo.memberNm }" /></td>
		<td><c:out value="${vo.createDate }" /></td>
		<td><c:out value="${vo.phone }" /></td>
	</tr>
</c:forEach>

</tbody>

</table>

<div class="center">
  <div class="pagination">



  <!-- <a href="boardList.do?page=2" class="active">2</a>
  <a href="boardList.do?page=3">3</a>
  <a href="#">4</a>
  <a href="#">5</a>
  <a href="#">6</a> -->

  </div>
</div>

	


