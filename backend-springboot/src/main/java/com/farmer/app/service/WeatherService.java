package com.farmer.app.service;

import com.farmer.app.dto.WeatherResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponseDTO getWeather(String city) {

        String API_KEY = "77a0e98b9812dbb925d5a56f270072f9";
        String url =
                "https://api.openweathermap.org/data/2.5/weather?q="
                        + city
                        + "&appid="
                        + API_KEY
                        + "&units=metric";

        Map response = restTemplate.getForObject(url, Map.class);

        Map main = (Map) response.get("main");
        Map wind = (Map) response.get("wind");

        java.util.List weatherList =
                (java.util.List) response.get("weather");

        Map weather =
                (Map) weatherList.get(0);

        WeatherResponseDTO dto =
                new WeatherResponseDTO();

        dto.setCity(city);
        dto.setTemperature(
                ((Number) main.get("temp")).doubleValue());

        dto.setHumidity(
                ((Number) main.get("humidity")).intValue());

        dto.setCondition(
                weather.get("description").toString());

        dto.setWindSpeed(
                ((Number) wind.get("speed")).doubleValue());

        return dto;
    }
}