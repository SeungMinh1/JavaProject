<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  domFor.jsp   -------------->

<h3>dom연습</h3>

<!--멤버추가화면 -->
<form>
	<table class="table">
		<tr>
			<th>아이디</th>
			<td><input type="text" id="mid"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" id="fname"></td>
		</tr>
		<tr>
			<th>성씨</th>
			<td><input type="text" id="lname"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="email" id="email"></td>
		</tr>
		<tr>
			<td>급여</td>
			<td><input type="number" id="salary"></td>
		</tr>
		<tr>
			<th>성별</th>
			<td><select id="gender">
				<option value="Male">Male</option>
				<option value="Female">Female</option>
			</select></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button id="addBtn">저장</button>
			</td>
			<td  align="left" class = "btn btn-primary">
			<button id = "updBtn">수정</button>
			</td>
		</tr>
	</table>

</form>

<div id="show">
	<input id=''>
	<table border='1' class = 'table' >
		<thead id="header"/>
		<tbody id="list" />	
	
	</table>

</div>

<span id="timer"></span>




<!--  <script src="js/mock_data.js"></script>
<script src="js/member.js"></script>
-->

<!--<script src="js/string.js"></script>-->
<!--<script src="js/array.js"></script> -->
<script src="js/ajax.js"></script> 