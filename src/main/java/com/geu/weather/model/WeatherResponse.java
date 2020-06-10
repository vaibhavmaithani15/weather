package com.geu.weather.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class WeatherResponse {
    private String dt;
    private Coord coord;
    private String visibility;
    private Weather[] weather;
    private String name;
    private String cod;
    private Main main;
    private Clouds clouds;
    private String id;
    private Sys sys;
    private String base;
    private Wind wind;
}
