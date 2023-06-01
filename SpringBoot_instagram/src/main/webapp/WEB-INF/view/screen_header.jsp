<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="resources/css/screen_style.css">
<link rel="icon" href="resources/images/default_img/insta-icon.png">
<title>screen</title>
</head>
<body class="screen_body">
	<header class="screen_header">
		<div class="header_controll_bar">
			<div id="logo_bar">
				<img src="resources/images/default_img/default_logo_text.png" alt="">
			</div>
			<div class="noti_msg">
				<img src="resources/images/default_img/default_Notification.png"
					alt="">
			</div>
			<div class="noti_msg">
				<img src="resources/images/default_img/default_message.png" alt="">
			</div>
		</div>

	</header>

	
		<jsp:include page="/WEB-INF/view/insta_screen.jsp" />