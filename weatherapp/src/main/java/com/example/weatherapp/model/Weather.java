package com.example.weatherapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String weatherCondition;

    private double temperature;

    private int humidity;

    public Weather() {}

    public Weather(String city,
                   String weatherCondition,
                   double temperature,
                   int humidity) {
        this.city = city;
        this.weatherCondition = weatherCondition;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}