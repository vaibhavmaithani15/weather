package com.geu.weather.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Wind {
    private String deg;
    private String speed;
}
