/**
 * Simple function in pure JavaScript to submit the form with the selected city as path variable.
 */
function getWeather(){
    var service = "http://localhost:8090/weather/city/" + document.getElementById("cityOption").value;
    //var cityForm = document.getElementById('cityForm');
    //cityForm.action = service;
    var weatherData;
    document.getElementById("loading").style = "";
    document.getElementById("results").style = "display: none; visibility: hidden";
    var ajax = new XMLHttpRequest();
    ajax.onreadystatechange = function() {
        if (4 == this.readyState && 200 == this.status) {
            weatherData = JSON.parse(this.responseText);
            document.getElementById("date").innerHTML = weatherData.date;
            document.getElementById("city").innerHTML = weatherData.city;
            document.getElementById("weather").innerHTML = weatherData.weatherDesc;
            document.getElementById("tempC").innerHTML = weatherData.tempCelsius;
            document.getElementById("tempF").innerHTML = weatherData.tempFahrenheit;
            document.getElementById("sunrise").innerHTML = weatherData.sunRiseTime;
            document.getElementById("sunset").innerHTML = weatherData.sunSetTime;
            document.getElementById("loading").style = "display: none; visibility: hidden";
            document.getElementById("results").style = "";
        }
     };
     ajax.open("POST", service, true);
     ajax.send();
}
