<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規投稿を作成</title>
<link rel="stylesheet" type="text/css"
	href="resources/css/feed_upload.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/feed_upload.js"></script>
<link rel="icon" href="resources/images/default_img/insta-icon.png">
</head>
<body class="feed_up_full_body">

	<header class="uplad_header"> Feed upload </header>
	<form class="feed_up_form" name="fileForm" action="/feed_upload" method="post" enctype="multipart/form-data">
		<div class ="login_user">user</div>
		<div class="filebox preview-image">
			<textarea rows="5" cols="13" name="comment" placeholder="キャプションを入力"></textarea>
			<label class="file_upload_label" for="input-file">コンピューターから選択</label>
			<input type="file" id="input-file" class="upload-hidden" name="FeedFile" style="display: none;">
			<label class="feed_upload_label" for="input-feed">シェア</label>
			<input id="input-feed" type="button" style="display: none" onclick="fileupload();"></input>
		</div>
	</form>
	<footer></footer>

</body>
</html>