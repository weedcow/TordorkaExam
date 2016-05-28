
$(document).ready(function() {
		
	if ($(".buyBtn").hasClass("d0")) {
		  $(".d0").find("span").text("BOOK CAR");
		  $(".d0").removeClass("lalala")
	} 
	
	$(".lalala").find("span").text("NOT AVAILABLE");
	
	$(".lalala").find("a").click(function( event ) {
		  event.preventDefault();
			console.log("Prevented default")
	});
	
	
	// ADMIN PAGE
	
	if (typeof localStorage.admin == 'undefined' || localStorage.admin == 0 || localStorage.admin == "return") {
		localStorage.admin = 0;
		$(".addNewDiv").hide();
		$(".updateCarDiv").hide();
		$(".updateUserDiv").hide();
	} else if (localStorage.admin == "new"){
		localStorage.admin = 0;
		$(".addNewDiv").show();
		$(".updateCarDiv").hide();
		$(".updateUserDiv").hide();
	} else if (localStorage.admin == "car"){
		localStorage.admin = 0;
		$(".addNewDiv").hide();
		$(".updateCarDiv").show();
		$(".updateUserDiv").hide();
	} else if (localStorage.admin == "user"){
		localStorage.admin = 0;
		$(".addNewDiv").hide();
		$(".updateCarDiv").hide();
		$(".updateUserDiv").show();
	}
});

$(document).on("click", ".getClick", function(){
	localStorage.admin = $(this).attr("data-name");
	
	if (localStorage.admin == "new"){
		localStorage.admin = 0;
		$(".addNewDiv").show();
		$(".updateCarDiv").hide();
		$(".updateUserDiv").hide();
	}
});

var page = $(document).find('.pageHidden').text();

if(page == "index"){ 

	xhrGet("Controller?action=getCars", function(responseText){
		// add to document
		if (typeof localStorage.loop == 'undefined' || localStorage.loop == 0) {
				localStorage.loop = 1;
				$("body").empty();
				$("body").append(responseText);
			} else {
				localStorage.loop = 0;
			}

	}, function(err){
		console.log(err);
	});

}


function createXHR(){
	if(typeof XMLHttpRequest != 'undefined'){
		return new XMLHttpRequest();
	}else{
		try{
			return new ActiveXObject('Msxml2.XMLHTTP');
		}catch(e){
			try{
				return new ActiveXObject('Microsoft.XMLHTTP');
			}catch(e){}
		}
	}
	return null;
}

function xhrGet(url, callback, errback){
	var xhr = new createXHR();
	xhr.open("GET", url, true);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				callback(xhr.responseText);
			}else{
				errback('service not available');
			}
		}
	};
	xhr.timeout = 3000;
	xhr.ontimeout = errback;
	xhr.send();
}


//Weather API

//On startup run function getLocation.
getLocation();


// Get users geolocation
function getLocation() {
	// Check if geo location is supported
    if (navigator.geolocation) {
    	// First time: Prompts user for permission to use geolocation
    	// If success: Runs function showPosition
    	// If failure: Runs function showError
        navigator.geolocation.getCurrentPosition(showPosition, showError);
    } else {
        console.log("Geolocation is not supported by this browser.");
    }
}

function showPosition(position) {
	// Receives latitude and longitude and store it in array
    var cords = [position.coords.latitude,position.coords.longitude];
    // Runs function getWeather with the cords array as argument
    getWeather(cords);
}


function showError(error) {
	// If getLocation gets an error 
    switch(error.code) {
        case error.PERMISSION_DENIED:
            console.log("User denied the request for Geolocation.");
            break;
        case error.POSITION_UNAVAILABLE:
            console.log("Location information is unavailable.");
            break;
        case error.TIMEOUT:
            console.log("The request to get user location timed out.");
            break;
        case error.UNKNOWN_ERROR:
            console.log("An unknown error occurred.");
            break;
    }

    // Sets the loading text
	$(".render").find("h3").text("Loading default");
	
	// Waits 1 second and runs function getWeather with default cords.
	setTimeout(function(){
	    var cords = ["56.17","9.55"];
    	getWeather(cords);
	}, 1000);


}

// Load specific city from dropdown menu
function loadCity(city) {

	switch(city.value) {
        case "copenhagen":
            var cords = ["55.67","12.56"];
            break;
        case "newyork":
            var cords = ["40.73","-73.93"];
            break;
        case "london":
            var cords = ["51.50","-0.12"];
            break;
        case "sidney":
            var cords = ["-33.86","151.20"];
            break;
        default:
        	var cords = ["56.17","9.55"];
            break;
    }

    // Show the loading text and change the text
    $(".render").show();
    $(".render").find("h3").text("Loading city");
	
	// Waits 1 second and runs function getWeather with city cords.
	setTimeout(function(){
    	getWeather(cords);
	}, 1000);
}


function getWeather(cords){

	// Set API url
	var url = "http://api.openweathermap.org/data/2.5/weather";

	// Set latitude and longtitude received from cords argument.
	var lat = cords[0];
	var lon = cords[1];

	// APP ID - Authentication - Allow us to get data.
	var appId = "9ef7b5b755f09fe802a6da072609c428";

	// AJAX call
	$.ajax({
        url: url,
        data: {
            "lat": lat,
            "lon": lon,
            "units": "metric",
            "APPID": appId
        },
        method: "GET",
        dataType: "JSON"
    }).done(function (data) {

    	// Gets and array with day, month and date (Input: UNIX Timestamp)
    	var date = getDate(data.dt);

    	// Gets the wind direction in letters Ex. NE (North East) (Input: Degrees)
    	var direction = getDirection(data.wind.deg);

    	// Replaces the HTML with the received data
    	$(".weatherTemp").find("span").html(Math.floor(data.main.temp));
    	$(".weatherCity").find("span").html(data.name);
    	$(".weatherHigh").find("span").html(Math.floor(data.main.temp_max));
    	$(".weatherLow").find("span").html(Math.floor(data.main.temp_min));
    	$(".weatherWind").find("span").html(data.wind.speed);
    	$(".weatherDay").find("span").html(date[0]);
    	$(".weatherDate").find("span").html(date[1]+" "+date[2]);
    	$(".weatherDesc").find("span").html(data.weather[0].description);
    	$(".weatherClouds").find("span").html(data.clouds.all);
    	$(".weatherDirection").find("span").html(direction);
		$(".weatherIcon").attr("src","./icons/"+data.weather[0].icon+".png");

		// Fadeout loading text
		$(".render").fadeOut("500");
 
    })
    .fail(function (data) {
        console.log("Error");
	});
}


// Receives a timestamp, gets day, month and date and returns it in an array
function getDate(timestamp) {
	var date = new Date(timestamp*1000);
	var dayInt = date.getDay();
	var monthInt = date.getMonth();
	var days = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];
	var months = ["January", "February", "March", "April", "May", "June","July", "August", "September", "October", "November", "December"];

	var day = days[dayInt-1];
	var month = months[monthInt];
	var date = [day, month, date.getDate()];
	return date;

}


// Receives wind direction in degrees and return it in letters Ex. SW (South West).
function getDirection(deg){
  if (deg>11.25 && deg<33.75){
    return "NE";
  }else if (deg>33.75 && deg<56.25){
    return "NE";
  }else if (deg>56.25 && deg<78.75){
    return "E";
  }else if (deg>78.75 && deg<101.25){
    return "SE";
  }else if (deg>101.25 && deg<123.75){
    return "SE";
  }else if (deg>123.75 && deg<146.25){
    return "SE";
  }else if (deg>146.25 && deg<168.75){
    return "SE";
  }else if (deg>168.75 && deg<191.25){
    return "S";
  }else if (deg>191.25 && deg<213.75){
    return "SW";
  }else if (deg>213.75 && deg<236.25){
    return "SW";
  }else if (deg>236.25 && deg<258.75){
    return "SW";
  }else if (deg>258.75 && deg<281.25){
    return "W";
  }else if (deg>281.25 && deg<303.75){
    return "NW";
  }else if (deg>303.75 && deg<326.25){
    return "NW";
  }else if (deg>326.25 && deg<348.75){
    return "NW";
  }else{
    return "N"; 
  }
}




