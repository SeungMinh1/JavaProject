<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
	<h3>회원등록</h3>
	<form action="addMember.do" method="post">
	<table border="1" class="table">
		<tr>
			<th>회원ID</th><td><input class="form-control" type="text" name="id"></td>
		</tr>
		<tr>
			<th>회원PW</th><td><input class="form-control" type="text" name="pw"></td>
		</tr>
		<tr>
			<th>회원이름</th><td><input class="form-control" type="text" name="name"></td>
		</tr>
		<tr>
			<th>전화번호</th><td><input class="form-control" type="text" name="tel"></td>
		</tr>
		<tr>
			<td align="center"><input class="btn btn-primary" type="submit" value="회원등록"></td>
		</tr>
	</table>
	</form>