package com.geu.weather.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Weather {
    private String icon;
    private String description;
    private String main;
    private String id;
}
