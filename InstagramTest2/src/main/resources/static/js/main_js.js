
$(document).ready(function() {
	var test = "script ok";
	console.log(test);
});

function replaceClass(id, oldClass, newClass) {  //class 変更
	var elem = document.getElementById(id);
	elem.classList.remove(oldClass);
	elem.classList.add(newClass);
}

$(function() {
	$("#insert_user").click(function() {

	})
});

$(function() {
	$("#login").click(function() {
		var account = $('#account').val();
		var pw = $('#pw').val();
		console.log(account);
		console.log(pw);
		$.ajax({
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
					let url = '/feed_screen';
					location.replace(url);
				}
			})
			.fail(function(request, status, error) {
				if (request.status == 500) {
					replaceClass("forget_idpw", "unactive", "active");
				} else {
					alert("code:" + request.status + "\n" + "error:" + error);

				}
			});
	})

});

$(function() {
	$('#account, #pw').keyup(function() {
		var account = $('#account').val();
		var pw = $('#pw').val();

		if (account !== "" && pw !== "") {
			console.log(account);
			console.log(pw);
			replaceClass("login", "unactivatedLoginColor", "activatedLoginColor");
		} else {
			replaceClass("login", "activatedLoginColor", "unactivatedLoginColor");
		}
	});
})

/*const idInput = document.getElementById('userID');
const pwInput = document.getElementById('userPW');
const loginBtn = document.getElementById('btn_login');
const linkToMain = document.getElementsByTagName('a')[0];


document.ready(function() {
		history.replaceState({}, null, location.pathname);	
		loginBtn.disabled = true;	
	});
	
	

idInput.addEventListener('keyup', function(event) {
	if (idInput.value && pwInput.value) {
		loginBtn.disabled = false;
		//linkToMain.href = "file:///Users/MiaJLee/Desktop/WeCode/westagram/main.html";
	}
	else {
		loginBtn.disabled = true;
		linkToMain.href = "#none";
	}
})

pwInput.addEventListener('keyup', function(event) {
	if (idInput.value && pwInput.value) {
		loginBtn.disabled = false;
		//linkToMain.href = "file:///Users/MiaJLee/Desktop/WeCode/westagram/main.html";
	}
	else {
		loginBtn.disabled = true;
		linkToMain.href = "#none";
	}
})

document.addEventListener('keyup', function(event) {
	if (event.keyCode === 13) {
		document.getElementById("btn_login").click();
	}
})*/