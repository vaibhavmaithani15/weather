package com.geu.weather.scheduler;

import com.geu.weather.message.Messaging;
import com.geu.weather.model.WeatherResponse;
import com.geu.weather.services.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Slf4j
@Component
public class WeatherScheduler {
    private WeatherService weatherService;
    private String openWeatherMapUrl;
    private Messaging messaging;

    public WeatherScheduler(WeatherService weatherService,
                            @Value("${openweathermap.url}") String openWeatherMapUrl,
                            Messaging messaging) {
        this.weatherService = weatherService;
        this.openWeatherMapUrl = openWeatherMapUrl;
        this.messaging = messaging;
    }

    @Scheduled(fixedDelay = 10000)
    public void addPerson() {
        log.info("openWeatherMapUrl :: " + openWeatherMapUrl);
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

            ResponseEntity<WeatherResponse> result = restTemplate.exchange(
                    openWeatherMapUrl,
                    HttpMethod.GET,
                    entity,
                    WeatherResponse.class);

            log.info("Result :: {}", result.getBody());

        Message<WeatherResponse> message = MessageBuilder.withPayload(result.getBody()).build();
        this.messaging.getMessageChannel().send(message);
    }
}
