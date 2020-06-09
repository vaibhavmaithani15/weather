package com.geu.weather.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WeatherScheduler {
    //private WeatherService weatherService;
    private String openWeatherMapUrl;

    public WeatherScheduler(@Value("${openweathermap.url}") String openWeatherMapUrl) {
        //this.weatherService = weatherService;
        this.openWeatherMapUrl = openWeatherMapUrl;
    }

    @Scheduled(fixedDelay = 10000)
    public String addPerson() {
        log.debug("SenderBaseUrl :::::::::::::::::::" + openWeatherMapUrl);
        return "sucess";
    }
}
