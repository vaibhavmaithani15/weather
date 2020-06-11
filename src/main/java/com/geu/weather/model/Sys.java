package com.geu.weather.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Sys {
    private String country;
    private String sunrise;
    private String sunset;
    private String id;
    private String type;
    private String message;
}
