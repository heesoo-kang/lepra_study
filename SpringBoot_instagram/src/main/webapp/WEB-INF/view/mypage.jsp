<%@ page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>screen</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
<link rel="stylesheet" type="text/css" href="resources/css/mypage.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
<link rel="icon" href="resources/images/default_img/insta-icon.png">

</head>

<header>
	<div class="header_controll_bar">
		<div id="setiing_button">
			<img src="resources/images/default_img/default_setting.png" alt="">
		</div>
		<div id="default_account">${param.account}</div>

		<div id="default_friend">
			<img src="resources/images/default_img/friend_plus.png" alt=""
				id="default_friend">
		</div>

	</div>
</header>

<body class="mypage_body">
	<script type="text/javascript" src="resources/js/mypage.js"></script>
	<input type="hidden" id="myaccount" value='${param.account}' />
	<div class="body_head">
		<div class="body_profile b_head">
			<img alt=""
				src="resources/images/privacy_img/profile/${loginvo.profile_image}"
				onerror="this.src='resources/images/default_img/default_porfile.png'">
		</div>
		<div class="body_profile b_account">
			<a>${param.account}</a> &nbsp;&nbsp;
			<div class="body_profile b_profile_img">
				<img alt="" src="resources/images/default_img/default_setting.png">
			</div>
			<div>プロフィールを編集</div>

		</div>

		<div class="body_profile b_info">
			<a>#test</a> <a>#mypage</a>

			<table class="MyFollow_Feed_set">
				<tr>
					<td >投稿<br><span id="feedcount"></span> <br>件
					</td>
					<td>フォロワー<br ><span id="follower" ></span><br>人
					</td>
					<td>フォロー中<br><span id="follow"></span><br>人
					</td>
				</tr>


			</table>
		</div>
	</div>
	<div class="body_body">
		<div class="body_collection">
			<div>
				<img alt="" src="resources/images/default_img/page_feedlist.png" onclick="myfeedshow()">
			</div>
			<div>
				<img alt="" src="resources/images/default_img/default_bookmark.png" onclick="bookmarkshow()">
			</div>
			<div>
				<img alt="" src="resources/images/default_img/tag_human.png">
			</div>
		</div>
		<article class="feed_list"></article>

	</div>
</body>

<footer>
	<div class="footer_controll_bar">
		<div class="default_home" onclick="window.scrollTo(0,0);">
			<a href="/feed_screen"> <img alt=""
				src="resources/images/default_img/default_home.png">
			</a>
		</div>
		<div class="default_search">
			<img alt="" src="resources/images/default_img/default_explore.png">
		</div>
		<div class="default_video">
			<img alt="" src="resources/images/default_img/default_video.png">
		</div>
		<div class="default_plus" onclick='feed_upload()'>
			<img alt="" src="resources/images/default_img/new_upload.png">
		</div>
		<div class="default_message">
			<img alt="" src="resources/images/default_img/default_message.png">
		</div>
		<div class="default_profile">
			<img
				src="resources/images/privacy_img/profile/${loginvo.profile_image}"
				alt="">
		</div>
	</div>
</footer>
</html>
