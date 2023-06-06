<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<SCRIPT>
	function test() {
		var target = document.getElementById("target");
		var val = target.innerHTML;
		if (val != '99') {
			target.innerHTML = val == '' ? 0 : parseInt(val) + 1;
			setTimeout('test()', 100);
		}
	}
</SCRIPT>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<h2 class="text-center">Login</h2>
				<form action="/event" method="GET">
					<div class="form-group">
						<label for="username">ID</label> <input type="text"
							class="form-control" id="username" name="username"
							placeholder="사용자명을 입력하세요">
					</div>
					<div class="form-group">
						<label for="password">PASSWORD</label> <input type="password"
							class="form-control" id="password" name="password"
							placeholder="비밀번호를 입력하세요">
					</div>
					<button type="submit" class="btn btn-primary btn-block">
						LOGIN</button>
				</form>
				<button type="submit" class="btn btn-primary btn-block" onclick="test()" >COUNT- UP</button>
			</div>
		</div>
	</div>
</body>
</html>
