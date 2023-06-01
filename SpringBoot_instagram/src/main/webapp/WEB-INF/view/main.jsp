<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="jp">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Instagram</title>
<link rel="stylesheet" type="text/css"
	href="resources/css/main_style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/main_js.js"></script>
<link rel="icon" href="resources/images/default_img/insta-icon.png">
</head>


<body>

	<div class="contentsWrap">
		<div class="loginWindow">
			<img src="resources/images/default_img/logo.png" alt="" id="instaLogo">
			<input type="text" placeholder="電話番号、ユーザーネーム、メールアドレス" class="inlineToBlock" id="account"> 
			<input type="password" placeholder="パスワード" class="inlineToBlock" id="pw">
			<button class="inlineToBlock ordinaryLogin unactivatedLoginColor" id="login">ログイン</button>

			<div class="horizonAndOrWrap">
				<hr class="leftHr">
				<div class="or">または</div>
				<hr class="rightHr">
			</div>

			<a href="/screen" class="noneunderline">
				<button class="inlineToBlock facebookLogin">
					<img src="resources/images/default_img/facebook.png" alt=""
						class="facebookIcon" id="facebook"> Facebookでログイン
				</button>
			</a>
			<p class = "forget_idpw unactive" id="forget_idpw" type="hidden">パスワードが間違っています。パスワードをご確認ください。</p>
			 パスワードを忘れた場合

		</div>
		<div class="haveAccount">
			<p>
				アカウントをお持ちでないですか？ <a href="join_user" class="noneunderline" id="insert_user">登録する</a>
			</p>
		</div>
	</div>

</body>


</html>