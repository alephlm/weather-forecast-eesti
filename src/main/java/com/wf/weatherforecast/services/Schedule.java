package com.wf.weatherforecast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;

@Configuration
@EnableScheduling
public class Schedule {

    @Autowired
    private WeatherService weatherService;

    @Scheduled(fixedDelay = 1800000)
    public void scheduleFixedDelayTask() throws IOException {
        weatherService.SavePlaces();
    }
}
