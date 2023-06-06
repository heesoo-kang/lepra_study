<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>event_main</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<link rel="stylesheet" type="text/css"
	href="resources/eventcss/event_main.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Reggae+One&display=swap"
	rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/confetti_v2.js"></script>
<script type="text/javascript" src="resources/js/eventmain.js"></script>


</head>
<body>


	<div id="chocolate_rains"></div>

	<div class="cover">
		<img class="animate__animated animate__tada" id="animate_id" alt=""
			src="resources/video/any2.gif" onclick="imgclick()">
	</div>
	<div class="content">
		<button class="learn-more" id="message_button" onclick="message()">メッセージ</button>
		<button class="learn-more" id="picture_button">写真</button><br>
		<p class="typing"></p>
	</div>
	
</body>

</html>