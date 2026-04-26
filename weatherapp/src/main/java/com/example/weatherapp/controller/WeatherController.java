package com.example.weatherapp.controller;

import org.springframework.web.bind.annotation.*;

import com.example.weatherapp.model.Weather;
import com.example.weatherapp.service.WeatherService;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService service;

    public WeatherController(
            WeatherService service) {
        this.service = service;
    }

    @GetMapping("/{city}")
    public Weather getWeather(
            @PathVariable String city) {

        return service.getWeather(city);
    }

    @GetMapping("/history")
    public List<Weather> getHistory() {
        return service.getAllWeather();
    }
}