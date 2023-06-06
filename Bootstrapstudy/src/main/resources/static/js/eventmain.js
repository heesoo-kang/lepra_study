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
	document.getElementById("animate_id").classList.add('animate__zoomOutUp');

};

