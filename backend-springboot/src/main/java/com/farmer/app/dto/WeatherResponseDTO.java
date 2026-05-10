package com.farmer.app.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherResponseDTO {
    private String city;
    private Double temperature;
    private Integer humidity;
    private String condition;
    private Double windSpeed;
    private Integer rainChance;
}
