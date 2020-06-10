package com.geu.weather.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Main {
    private String temp;
    private String temp_min;
    private String humidity;
    private String pressure;
    private String temp_max;
}
