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
	<h1>파일 업로드</h1>
	<form method ="POST" action ="/file/addok.do" enctype="multipart/form-data">
		<table class="vertical">
			<tr>
				<th>TEXT</th>
				<td><input type="text" name="txt" value="홍길동"></td>
			</tr>
			<tr>
				<th>FILE</th>
				<td><input type="file" name="attach"></td>
			</tr>
		</table>
		<button style="margin-left:30px;">button</button>
	</form>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script>
		
	</script>
</body>
</html>