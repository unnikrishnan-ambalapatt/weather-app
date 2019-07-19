package com.weather.weatherapp.controller;

import com.weather.weatherapp.dto.WeatherDto;
import com.weather.weatherapp.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller class that exposes weather related endpoints at "/weather".
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    /**
     * Service that returns weather data for the specified city.
     *
     * @param cityId
     * @return WeatherDto
     */
    @PostMapping("/city/{cityId}")
    public WeatherDto getWeatherForCity(@PathVariable Integer cityId) {
        return weatherService.getWeatherForCity(cityId);
    }

}
