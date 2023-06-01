$(document).ready(function() {
	var test = "join script ok";
	console.log(test);
});
function replaceClass(id, oldClass, newClass) {  //class 変更
	var elem = document.getElementById(id);
	elem.classList.remove(oldClass);
	elem.classList.add(newClass);
}
$(function() {
	$('#email_phone, #pw, #fullname, #username').keyup(function() {
		var account = $('#email_phone').val();
		var fullname = $('#fullname').val();
		var username = $('#username').val();
		var pw = $('#pw').val();
		const target = document.getElementById('join');

		if (account !== "" && fullname !== "" && username !== "" && pw !== "") {
			console.log(account);
			console.log(pw);
			replaceClass("join", "unactivatedJoinColor", "activatedJoinColor");
			target.disabled = false;
		} else {
			replaceClass("join", "activatedJoinColor", "unactivatedJoinColor");
			target.disabled = true;
		}
	});
})


$(function() {
	$("#join").click(function() {
		var email_phone = $('#email_phone').val();
		var fullname = $('#fullname').val();
		var username = $('#username').val();
		var pw = $('#pw').val();

		if (email_phone == "" || fullname == "" || username == "" || pw == "") {
			alert("入力不足,異常接近");
		} else {
			console.log("email_phone: " + email_phone);
			var mailchk = email_phone.indexOf('@');
			console.log("mail chk :" + mailchk);
			console.log(mailchk == -1)
			if (mailchk == -1) {
				$.ajax({
					type: "POST",
					url: "/join_user",
					data: {
						account: fullname,
						name: username,
						userpw: pw,
						phone: email_phone
					}
				})
					.done(function(result) {
						/*alert("成功");*/
						Swal.fire({
							icon: '成功',
							title: 'ユーザー登録が完了しました。',
							text: 'ログインページに移動します。',
						});
						console.log("result: " + result);
					})
					.fail(function(request, status, error) {
						if (request.status == 500) {
							alert("登録に失敗しました。");
						} else {
							alert("code:" + request.status + "\n" + "error:" + error);
						}
					});
			} else {
				$.ajax({
					type: "POST",
					url: "/join_user",
					data: {
						email: email_phone,
						account: fullname,
						name: username,
						userpw: pw
					}
				})
					.done(function(result) {
						Swal.fire({
							icon: '成功',
							title: 'ユーザー登録が完了しました。',
							text: 'ログインページに移動します。',
						});
						console.log("result: " + result);
					})
					.fail(function(request, status, error) {
						if (request.status == 500) {
							alert("登録に失敗しました。");
						} else {
							alert("code:" + request.status + "\n" + "error:" + error);
						}
					});
			}


		}


		/*$.ajax({
			type: "POST",
			url: "/login",
			data: { account: account, userpw: pw }
		})
			.done(function(result) {
				alert(result);
				console.log("reslut: " + result);
				if (result == 'loginFail') {
					alert('loginFail.');
					replaceClass("forget_idpw", "unactive", "active");
				} else {
					let url = '/screen';
					location.replace(url);
				}
			})
			.fail(function(request, status, error) {
				if (request.status == 500) {
					replaceClass("forget_idpw", "unactive", "active");
				} else {
					alert("code:" + request.status + "\n" + "error:" + error);

				}
			});*/
	})

});