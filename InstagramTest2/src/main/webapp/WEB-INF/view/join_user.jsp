<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="jp">
<head>
<meta charset="UTF-8">
<title>登録・Instagram</title>
<link rel="stylesheet" type="text/css"
	href="resources/css/join_user_style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/join_user.js"></script>
<link rel="icon" href="resources/images/default_img/insta-icon.png">
</head>

<body>
	<div class="contentsWrap">
		<div class="joinWindow">
			<img src="resources/images/default_img/logo.png" alt=""
				id="instaLogo">
			<p class="Description_head">
				<b>登録して友達の写真や動画をチェックしよう</b>
			</p>
			<a href="/screen" class="noneunderline">
				<button class="inlineToBlock facebookLogin">
					<img src="resources/images/default_img/facebook.png" alt=""
						class="facebookIcon" id="facebook"> Facebookでログイン
				</button>
			</a>
			<div class="horizonAndOrWrap">
				<hr class="leftHr">
				<div class="or">または</div>
				<hr class="rightHr">
			</div>
			<input type="text" placeholder="携帯電話番号またはメールアドレス" class="inlineToBlock" id="email_phone"> 
			<input type="text" placeholder="フルネーム" class="inlineToBlock" id="fullname">
			<input type="text" placeholder="ユーザーネーム" class="inlineToBlock" id="username"> 
			<input type="password" placeholder="パスワード" class="inlineToBlock" id="pw">
			<p class="Description_foot">
				サービスの利用者があなたの連絡先情報をInstagramにアップロードしている場合があります。
			</p>
			<p class="Description_foot">
				登録することで、Facebookの利用規約プライバシーポリシー,Cookieポリシーに同意するものとします。
			</p>
			<button class="inlineToBlock ordinaryLogin unactivatedJoinColor" id="join" disabled="true">登録する</button>
		</div>

		<div class="haveAccount">
			<p>
				アカウントをお持ちですか？ <a href="instagram" class="noneunderline" id="insert_user">ログインする</a>
			</p>
		</div>
	</div>

</body>
</html>