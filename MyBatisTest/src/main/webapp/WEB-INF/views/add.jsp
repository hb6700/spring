<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Example</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>
	
</style>
</head>
<body>
	<!-- add.jsp -->
	<!-- 
		DB컬럼명, DTO멤버변수명,HTML태그이름을 동일하게 작성하면 좋음. 추천~~
	-->
	<h1>Input</h1>
	<form method="POST" action="/mybatis/addok.do">
		<table class="vertical">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" required class="short"></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="text" name="age" required></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address" required class="full"></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<select name="gender">
						<option value="m">남자</option>
						<option value="f">여자</option>
					</select>
				</td>
			</tr>
		</table>
		<div>
			<button>등록하기</button>
		</div>
	</form>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script>
		
	</script>
</body>
</html>