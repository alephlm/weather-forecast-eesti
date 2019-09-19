package com.wf.weatherforecast.controllers;
import com.wf.weatherforecast.models.Place;
import com.wf.weatherforecast.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceController {

    @Autowired
    WeatherService weatherService;

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/getWeatherByCityName", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Place getWeatherForCity(@RequestParam("name") String cityName) {
        return weatherService.getWeatherByCityName(cityName);
    }

}
