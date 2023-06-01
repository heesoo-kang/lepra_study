$(document).ready(function() {
	var test = "screen_script ok";
	console.log(test);

	feed_numlen = document.getElementsByClassName("feed_number").length;
	var Myelement;

	getcomment(feed_numlen);
	like_bookmark_chk(feed_numlen);

});


function alerttest() {
	console.log("onload test");
}

function getcomment(feed_numlen) {
	var step;
	var commentlen;

	for (step = 0; step < feed_numlen; step++) {
		var number = document.getElementsByClassName("feed_number")[step].value;

		var append = "<div class='commantlist'>";

		$.ajax({
			type: "POST",
			url: "/commentlist",
			async: false,
			data: { commentnumber: number }
		}).done(function(result) {
			if (result.length > 0) {
				for (commentlen = 0; commentlen < result.length; commentlen++) {

					append += "<b>" + result[commentlen].comment_user + "</b>  " + result[commentlen].comment;
					append += "<br>  ";
				};
			}
		}).fail(function(request, status, error) {
			if (request.status == 500) {
				alert("500 error。");
			} else {
				alert("code:" + request.status + "\n" + "error:" + error);
			}
		});

		append += "</div>";
		$(document.getElementsByClassName("content_comment")[step]).append(append);
	}
}

function feed_upload() {
	let popOption = "width = 650px, height=500px, scrollbars=yes,toolbar = no ";
	let openUrl = "/feed_upload_pop";

	window.open(openUrl, 'pop', popOption);
}


function like_bookmark_chk(feed_numlen) {

	var commentForm = document.commentForm;
	var account = commentForm.comment_account.value;
	var feed_numberlist = [];


	for (step = 0; step < feed_numlen; step++) {
		var feedcounter = $($('.content_reaction_bar')[step]);
		var number = feedcounter.attr("value");
		feed_numberlist.push(number);
		feedcounter.prepend("<img class='chk_heart' id='chk_heart_" + number + "' src='resources/images/default_img/check_Notification.png' ' style='display: none;'>");
		feedcounter.prepend("<img class='default_heart' id='default_heart_" + number + "' src='resources/images/default_img/default_Notification.png'>");
		feedcounter.append("<img class='chk_bookmark' id='chk_bookmark_" + number + "' src='resources/images/default_img/chk_bookmark.png' ' style='display: none;'>");
		feedcounter.append("<img class='default_bookmark' id='default_bookmark_" + number + "' src='resources/images/default_img/default_bookmark.png'>");
	}

	$.ajax({
		type: "POST",
		url: "/likechk",
		data: { account: account }
	}).done(function(result) {
		var likecount = result.length;

		for (var number = 0; number < likecount; number++) {
			for (let feed of feed_numberlist) {
				/*			console.log("feed_numberlist: "+ feed);*/
				if (feed == result[number].feed_number) {
					if (result[number].account.includes(account)) {
						const json = JSON.stringify(result[number].feed_number);
						console.log("feedcounter2: " + json);
						console.log("cheeeeek : " + ("#chk_heart_" + result[number].feed_number));
						console.log("document: " + document.getElementById("default_heart_" + result[number].feed_number).alt);
						document.getElementById("default_heart_" + result[number].feed_number).style.display = "none";
						document.getElementById("chk_heart_" + result[number].feed_number).style.display = "block";

					}
				}
			}
		}
	}).fail(function(request, status, error) {
		if (request.status == 500) {
			console.log("500 error。");
		} else {
			console.log("code:" + request.status + "\n" + "error:" + error);
		}
	});

	$.ajax({
		type: "POST",
		url: "/bookmarkchk",
		data: { account: account }
	}).done(function(result) {
		var bookmarkcount = result.length;
		console.log("bookmark result: " + result);
		console.log("bookmark result: " + result[0].bookmark_user);
		for (var number = 0; number < bookmarkcount; number++) {

			for (let feed of feed_numberlist) {
				/*			console.log("feed_numberlist: "+ feed);*/
				if (feed == result[number].feed_number) {
					if (result[number].bookmark_user.includes(account)) {
						const json = JSON.stringify(result[number].feed_number);
						console.log("feedcounter2: " + json);
						console.log("cheeeeek : " + ("#chk_bookmark" + result[number].feed_number));
						console.log("document: " + document.getElementById("default_heart_" + result[number].feed_number).alt);

						document.getElementById("default_bookmark_" + result[number].feed_number).style.display = "none";
						document.getElementById("chk_bookmark_" + result[number].feed_number).style.display = "block";

					}
				}
			}
		}

	}).fail(function(request, status, error) {
		if (request.status == 500) {
			console.log("500 error。");
		} else {
			console.log("code:" + request.status + "\n" + "error:" + error);
		}
	});
}


$(document).on("click", ".default_heart", function() {
	$(this).hide();
	$(this).next().show();

	var feednum = $(this).siblings(".speech").attr("alt"); //feed number catch
	console.log(feednum);

	var commentForm = document.commentForm;
	var account = commentForm.comment_account.value;
	console.log(account);

	$.ajax({
		type: "POST",
		url: "/likesubmit",
		data: { feed_number: feednum, account: account }
	}).done(function(result) {
		console.log(result);
	}).fail(function(request, status, error) {
		if (request.status == 500) {
			alert("500 error。");
		} else {
			alert("code:" + request.status + "\n" + "error:" + error);
		}
	});

});



$(document).on("click", ".chk_heart", function() {
	$(this).hide();
	$(this).prev().show();
	console.log($(this).siblings(".speech").attr("alt"));
	var feednum = $(this).siblings(".speech").attr("alt"); //feed number catch
	console.log(feednum);
	var commentForm = document.commentForm;
	var account = commentForm.comment_account.value;


	$.ajax({
		type: "POST",
		url: "/likecancel",
		data: { feed_number: feednum, account: account }
	}).done(function(result) {
		console.log(result);
	}).fail(function(request, status, error) {
		if (request.status == 500) {
			alert("500 error。");
		} else {
			alert("code:" + request.status + "\n" + "error:" + error);
		}
	});

});



$(document).on("click", ".speech", function() {
	let picname = $(this).attr("alt");
	console.log("picname: " + picname);
	console.log("picname2: " + $(this).parent(".content_reaction_bar").val());

	document.getElementById("modal").style.display = "block";
	Myelement = document.getElementById("comment_feed_number");
	Myelement.value = picname;

});


$(document).on("click", ".default_bookmark", function() {
	$(this).hide();
	$(this).prev().show();
	var feednum = $(this).siblings(".speech").attr("alt"); //feed number catch
	console.log(feednum);

	var commentForm = document.commentForm;
	var account = commentForm.comment_account.value;
	console.log(account);

	$.ajax({
		type: "POST",
		url: "/bookmarksubmit",
		data: { feed_number: feednum, account: account }
	}).done(function(result) {
		console.log(result);
	}).fail(function(request, status, error) {
		if (request.status == 500) {
			alert("500 error。");
		} else {
			alert("code:" + request.status + "\n" + "error:" + error);
		}
	});

});

$(document).on("click", ".chk_bookmark", function() {

	$(this).hide();
	$(this).next().show();
	var feednum = $(this).siblings(".speech").attr("alt"); //feed number catch
	console.log(feednum);

	var commentForm = document.commentForm;
	var account = commentForm.comment_account.value;
	console.log(account);

	$.ajax({
		type: "POST",
		url: "/bookmarkcancel",
		data: { feed_number: feednum, account: account }
	}).done(function(result) {
		console.log(result);
	}).fail(function(request, status, error) {
		if (request.status == 500) {
			alert("500 error。");
		} else {
			alert("code:" + request.status + "\n" + "error:" + error);
		}
	});

});

function modalclose() {
	document.getElementById("modal").style.display = "none";
	document.getElementById("comment").value = ''
}

function comment_upload() {
	var commentForm = document.commentForm;
	var comment_account = commentForm.comment_account;
	var comment = commentForm.comment;
	Myelement = document.getElementById("comment_feed_number");
	comment_account = comment_account.value
	comment = comment.value
	console.log("Myelement: " + Myelement.value);
	console.log("comment_account: " + comment_account);
	console.log("comment: " + comment);

	$.ajax({
		type: "POST",
		url: "/comment_insert",
		data: { feed_number: Myelement.value, comment_user: comment_account, comment: comment }
	}).done(function(result) {
		console.log(result);
		$('.content_comment  .commantlist').empty();
		getcomment(feed_numlen);
		modalclose();
	}).fail(function(request, status, error) {
		if (request.status == 500) {
			alert("500 error。");
		} else {
			alert("code:" + request.status + "\n" + "error:" + error);
		}
	});

}


function deleteDiv(feed_numlen) {

	console.log("classname: " + classname);
	const div = document.getElementsByClassName(classname);
	div.remove();
}

/*const swiper = new Swiper('.swiper', {
  // Optional parameters

  loop: true,

  // If we need pagination
  pagination: {
	el: '.swiper-pagination',
  },

  // Navigation arrows
  navigation: {
	nextEl: '.swiper-button-next',
	prevEl: '.swiper-button-prev',
  },

  // And if we need scrollbar
  scrollbar: {
	el: '.swiper-scrollbar',
  },
});*/


