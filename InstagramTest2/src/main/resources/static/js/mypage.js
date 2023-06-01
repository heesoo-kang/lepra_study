$(document).ready(function() {
	var test = "mypage_script ok";
	console.log(test);

	var account = document.getElementById("myaccount").value;
	countlist(account);
	getmyfeed(account);

});

function countlist(account) {
	console.log("countlist myaccount:" + account);

	$.ajax({
		type: "POST",
		url: "/MyFollow_Feed_set",
		data: { account: account }
	}).done(function(result) {
		var countlen = result.length;
		const json = JSON.stringify(result);
		console.log("countlist resultlength: " + json);
		console.log("countlist result: " + result.myfeedcount);

		$('#feedcount').text(result.myfeedcount);
		$('#follower').text(result.followernum);
		$('#follow').text(result.followeenum);


	}).fail(function(request, status, error) {
		if (request.status == 500) {
			console.log("500 error。");
		} else {
			console.log("code:" + request.status + "\n" + "error:" + error);
		}
	});
}
function getmyfeed(account) {
	console.log(" getmyfeedmyaccount:" + account);

	$.ajax({
		type: "POST",
		url: "/myfeed",
		data: { account: account }
	}).done(function(result) {
		var myfeedcount = result.length;
		console.log("myfeed resultlength: " + result.length);
		console.log("myfeed result: " + result[0].feed_number);

		var append = "";
		for (myfeednum = 0; myfeednum < myfeedcount; myfeednum++) {
			append += "<div class='myfeed'>";
			//<img alt="" src="resources/images/default_img/page_feedlist.png">
			append += "<img alt='" + result[myfeednum].feed_number + "' src= 'resources/images/Feed/" + result[myfeednum].picture_address + "'>" + "</b>  ";
			append += "<br>  ";
			append += "</div>";
		}
		$(document.getElementsByClassName("feed_list")).append(append);
	}).fail(function(request, status, error) {
		if (request.status == 500) {
			console.log("500 error。");
		} else {
			console.log("code:" + request.status + "\n" + "error:" + error);
		}
	});


	$.ajax({
		type: "POST",
		url: "/MyBookmarkFeed",
		data: { account: account }
	}).done(function(result) {
		console.log("getmybookmarklist resultlength: " + result.length);
		console.log("getmybookmarklist result: " + result[0].feed_number);

		var myfeedcount = result.length;

		var append = "";
		for (bookfeednum = 0; bookfeednum < myfeedcount; bookfeednum++) {
			append += "<div class='bookmarkfeed' style='display: none;'>";
			//<img alt="" src="resources/images/default_img/page_feedlist.png">
			append += "<img alt='" + result[bookfeednum].feed_number + "' src= 'resources/images/Feed/" + result[bookfeednum].picture_address + "'>" + "</b>  ";
			append += "<br>  ";
			append += "</div>";
		}
		$(document.getElementsByClassName("feed_list")).append(append);

	}).fail(function(request, status, error) {
		if (request.status == 500) {
			console.log("500 error。");
		} else {
			console.log("code:" + request.status + "\n" + "error:" + error);
		}
	});
}
function bookmarkshow() {
	let myfeed = document.getElementsByClassName("myfeed");
	let len = myfeed.length;
	for (let i = 0; i < len; i++) {
		myfeed.item(i).style.display = "none";
	}
	let bookmarkfeed = document.getElementsByClassName("bookmarkfeed");
	let len2 = bookmarkfeed.length
	for (let i = 0; i < len2; i++) {
		bookmarkfeed.item(i).style.display = "";
	}
}

function myfeedshow() {
	let bookmarkfeed = document.getElementsByClassName("bookmarkfeed");
	let len2 = bookmarkfeed.length
	for (let i = 0; i < len2; i++) {
		bookmarkfeed.item(i).style.display = "none";
	}
	let myfeed = document.getElementsByClassName("myfeed");
	let len = myfeed.length;
	for (let i = 0; i < len; i++) {
		myfeed.item(i).style.display = "";
	}

}