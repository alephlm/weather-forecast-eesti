async function getData() {
    let cityName = document.getElementById("search-box").value;
    let maxtemp = document.getElementById("maxtemp");
    let mintemp = document.getElementById("mintemp");

    let response = await fetch(`http://localhost:8080/getWeatherByCityName?name=${cityName}`);
    try {
        let city = await response.json();
        mintemp.textContent = city.tempmin + "°C";
        maxtemp.textContent = city.tempmax + "°C";
        console.log(city);
    } catch(exception){
        alert("City not found");
    }
}