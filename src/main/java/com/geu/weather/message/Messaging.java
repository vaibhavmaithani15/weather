package com.geu.weather.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Messaging {
    String WEATHER = "weather";

    @Output(WEATHER)
    MessageChannel publishWeatherChannel();
}
