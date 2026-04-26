package com.example.weatherapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.weatherapp.model.Weather;
import com.example.weatherapp.repository.WeatherRepository;

import java.util.Map;
import java.util.List;

@Service
public class WeatherService {

    private final WeatherRepository repository;

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    public WeatherService(WeatherRepository repository) {
        this.repository = repository;
    }

    public Weather getWeather(String city) {

        RestTemplate restTemplate =
                new RestTemplate();

        String url =
                apiUrl
                        + "?q=" + city
                        + "&appid=" + apiKey
                        + "&units=metric";

        Map response =
                restTemplate.getForObject(
                        url,
                        Map.class
                );

        Map main =
                (Map) response.get("main");

        List weatherList =
                (List) response.get("weather");

        Map weatherMap =
                (Map) weatherList.get(0);

        double temperature =
                Double.parseDouble(
                        main.get("temp").toString()
                );

        int humidity =
                Integer.parseInt(
                        main.get("humidity").toString()
                );

        String condition =
                weatherMap.get("main").toString();

        Weather weather =
                new Weather(
                        city,
                        condition,
                        temperature,
                        humidity
                );

        return repository.save(weather);
    }

    public List<Weather> getAllWeather() {
        return repository.findAll();
    }
}