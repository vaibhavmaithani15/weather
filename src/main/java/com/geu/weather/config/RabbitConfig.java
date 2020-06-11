package com.geu.weather.config;

import com.geu.weather.message.Messaging;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(Messaging.class)
public class RabbitConfig {
}
