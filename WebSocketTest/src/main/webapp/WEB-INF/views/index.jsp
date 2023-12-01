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
	<!-- index.jsp -->
	<h1>WebSocket <small>chat</small></h1>
	
	<div>
		<div class="group">
			<label>대화명</label>
			<input type="text" name="name" id="name" class="name">
		</div>
	</div>
	
	<div>
		<button type="button" class="in">enter</button>
		<button type="button" class="in" data-name="카리나">K</button>
		<button type="button" class="in" data-name="안유진">A</button>
		<button type="button" class="in" data-name="설윤아">S</button>
		<button type="button" class="in" data-name="장원영">J</button>
	</div>
	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script>
		$(".in").click(function(){
			let name = $('#name').val();
			
			if($(event.target).data('name') != null && $(event.target).data('name') != ''){
				name = $(event.target).data('name');
			}
			
			let child = window.open('/socket/chat.do', 'chat', 'width=404 height=510');
			
			//child.connect(name);
			
			child.addEventListener('load', function(){
				//자식창 다 뜨고 나면 발생
				child.connect(name);
			});
			
			$('.in').css('opacity', .5)
					.prop('disabled', true);
			$('#name').prop('readOnly', true);
		});
	</script>
</body>
</html>