<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3> ù������ �Դϴ�...(index.jsp)</h3>
	<a href="info/resume.html">resume �������� �̵�.</a>
	<form action="MainServlet" method="post">
		<table border ='1'>
			<tr>
				<th>����</th><td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>�ۼ���</th><td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>����</th><td><textarea cols="25" rows="3" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button type="submit">���</button></td>
			</tr>
		</table>
	</form>
</body>
</html>