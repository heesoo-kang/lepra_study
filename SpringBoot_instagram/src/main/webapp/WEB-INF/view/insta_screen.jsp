<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>screen</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/screen_style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
<link rel="icon" href="resources/images/default_img/insta-icon.png">

</head>

<header class="screen_header">
	<div class="header_controll_bar">
		<div id="logo_bar">
			<img src="resources/images/default_img/default_logo_text.png" alt="">
		</div>
		<div id="search_bar">
			<input class="screen_search" placeholder="検索">
		</div>
		<div class="noti_msg default_notifi">
			<img src="resources/images/default_img/default_Notification.png"
				alt="" id="default_notifi">
		</div>

	</div>
</header>
<body class="screen_body">
	<script type="text/javascript" src="resources/js/insta_screen.js"></script>
	<input type="hidden" id="login_account" value=${loginvo.account
		}
		style="display: none;">

	<input type="hidden" id="feedVOlist" list='${feedVO}' />

	<div id="modal">
		<div class="modal_content">
			<input id="comment_feed_number" type="hidden">
			<header id="modal_header"> </header>

			<div>
				<form class="commnet_form" name="commentForm">
					<div class="commnet_box">
						<input type="hidden" id="comment_account" class="upload-hidden"
							name="comment_account" value=${loginvo.account
							}
							style="display: none;">
						<textarea rows="5" cols="13" id="comment" name="comment"
							placeholder="コメントを追加…"></textarea>
						<label class="comment_upload_label" for="input-comment">投稿する</label>
						<input id="input-comment" type="button" style="display: none"
							onclick="comment_upload();"></input>
					</div>
				</form>
			</div>
		</div>
		<div class="modal_layer">
			<button type="button" id="modal_close_btn" onclick="modalclose();">X</button>
		</div>
	</div>

	<div class="screen_inbody">
		<div class="inbody_header">Story line</div>
		<div class="inbody_middle">

			<c:forEach items="${feedVO}" var="feed">
				<input id="hidden_num" type="hidden" value=${feed.feed_number}>
				<div class_="middle_head">
					<div class="follow_profile">
						<img
							src="resources/images/privacy_img/profile/${feed.profile_image}"
							alt=""
							onerror="this.src='resources/images/default_img/default_porfile.png'">
					</div>
					<div class="follow_id">${feed.account}</div>

					<div class="follow_setting">
						<img src="resources/images/default_img/screen_setting.png" alt="">
					</div>
				</div>

				<div class="swiper">
					<div class="swiper-wrapper">
						<div class="swiper-slide">
							<img src="resources/images/Feed/${feed.picture_address}" alt="">
						</div>
					</div>
					<!-- 	<div class="swiper-pagination"></div>
					<div class="swiper-button-prev"></div>
					<div class="swiper-button-next"></div>
					<div class="swiper-scrollbar"></div> -->
				</div>

				<div class="inbody_footer">
					<div class="content_reaction_bar" value=${feed.feed_number}>
						<!-- 	<img class="default_heart" id="default_heart" src="resources/images/default_img/default_Notification.png" alt="">
						<img class="chk_heart" id="chk_heart" src="resources/images/default_img/check_Notification.png" alt=""> -->
						<img class="speech"
							src="resources/images/default_img/default_speech.png"
							alt=${feed.feed_number} > <img
							src="resources/images/default_img/my_message.png" alt="">
					</div>
					<div class="follow_id_message">${feed.account}</div>
					<div class="content_message">${feed.comment}</div>
					<div class="content_comment" id="num_id">
						<input class="feed_number" type="hidden" value=${feed.feed_number}>
					</div>
				</div>
			</c:forEach>
		</div>
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
			<a href="/mypage?account=${loginvo.account}"> <img
				src="resources/images/privacy_img/profile/${loginvo.profile_image}"
				alt="">
			</a>
		</div>
	</div>
</footer>
</html>
