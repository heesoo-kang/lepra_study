$(document).ready(function() {
	var test = "eventmain ok";
	console.log(test);
	var append = "";

	for (myfeednum = 0; myfeednum < 30; myfeednum++) {
		append += "<div class='heart'>";
		append += "<div class='ring'></div>";
		append += "<div class='inner'>";
		append += "<div class='regular'>";
		append += "<div class='movable'>";
		append += "<div class='left'></div>";
		append += "<div class='right'></div>";
		append += "</div>"; //movable
		append += "</div>"; //regular
		append += "<div class='reverse'>";
		append += "<div class='movable'>";
		append += "<div class='left'></div>";
		append += "<div class='right'></div>";
		append += "</div>";//movable
		append += "</div>";//reverse
		append += "</div>";//inner
		append += "</div>";//heart
	}
	$(document.getElementById("chocolate_rains")).append(append);




});
function imgclick() {
	document.getElementById("animate_id").classList.remove('animate__tada');
	document.getElementById("animate_id").classList.add('animate__flipOutY');


	setTimeout(function() {
		document.getElementById("message_button").classList.add('animate__slideInDown');
		document.getElementById("picture_button").classList.add('animate__slideInDown');
		document.getElementById("message_button").style.display = 'inline-block';
		document.getElementById("picture_button").style.display = 'inline-block';
		document.getElementById("picturediv").style.display = 'none';
	}, 1500);
};


function message() {
	document.getElementById("message_button").style.display = 'none';
	document.getElementById("picture_button").style.display = 'none';
	var typingBool = false;
	var typingIdx = 0;

	// 타이핑될 텍스트를 가져온다 
	var typingTxt = "ここはコメントのメッセージ部分です。よろしくお願いいたします。 ここはコメントのメッセージ部分です。よろしくお願いいたします。 ここはコメントのメッセージ部分です。よろしくお願いいたします。"

	typingTxt = typingTxt.split(""); // 한글자씩 자른다. 

	if (typingBool == false) {
		// 타이핑이 진행되지 않았다면 
		typingBool = true;
		var tyInt = setInterval(typing, 350); // 반복동작 
	}

	function typing() {
		if (typingIdx < typingTxt.length) {
			// 타이핑될 텍스트 길이만큼 반복 
			$(".typing").append(typingTxt[typingIdx]);
			// 한글자씩 이어준다. 
			typingIdx++;
		} else {
			//끝나면 반복종료 
			clearInterval(tyInt);
			document.getElementById("picture_button").style.display = 'inline-block';
		}
	}
}

function messagehidden() {
	document.getElementById("typingafter").style.display = 'none';
	document.getElementById("message_button").style.display = 'inline-block';
	document.getElementById("picture_button").style.display = 'inline-block';
}

function picture() {
	document.getElementById("message_button").style.display = 'none';
	document.getElementById("picture_button").style.display = 'none';
	document.getElementById("picturediv").style.display = 'contents';

}

function pictureclick(obj) {

	var path = $(obj).attr('src');

	$(".bigPictureWrapper").css("display", "flex").show();

	$(".bigPicture")
		.html("<img src='" + path + "' >")
		.animate({ width: '100%', height: '100%' }, 1000);
		
		
		
	$(".bigPictureWrapper").on("click", function() {
		
	});//end bigWrapperClick event


}


function bigclose() {

$(".bigPicture").animate({ width: '0%', height: '0%' }, 1000);
		setTimeout(function() {
			$('.bigPictureWrapper').hide();
		}, 1000);

}



