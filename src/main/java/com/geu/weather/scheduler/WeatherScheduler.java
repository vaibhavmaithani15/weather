package com.geu.weather.scheduler;

import com.geu.weather.services.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Slf4j
@Component
public class WeatherScheduler {
    private WeatherService weatherService;
    private String openWeatherMapUrl;

    public WeatherScheduler(WeatherService weatherService,
                            @Value("${openweathermap.url}") String openWeatherMapUrl) {
        this.weatherService = weatherService;
        this.openWeatherMapUrl = openWeatherMapUrl;
    }

    @Scheduled(fixedDelay = 10000)
    public String addPerson() {
        log.debug("SenderBaseUrl :::::::::::::::::::" + openWeatherMapUrl);
        try {
            /*RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(openWeatherMapUrl, String.class);*/
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

            ResponseEntity<String> result = restTemplate.exchange(openWeatherMapUrl, HttpMethod.GET, entity, String.class);

            log.debug("Result :: {}", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "sucess";
    }
}
