package com.farmer.app.controller;

import com.farmer.app.dto.WeatherResponseDTO;
import com.farmer.app.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "http://localhost:4200")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public WeatherResponseDTO getWeather(
            @PathVariable String city) {

        return weatherService.getWeather(city);
    }
}