package com.weather.weatherapp.services;

import com.weather.weatherapp.dto.WeatherDto;

public interface WeatherService {

    /**
     * Service to get weather data by cityId.
     * <p>
     * Since there are several cities with the same name around the world,
     * let's use the unique cityId to get results for a city.
     * <p>
     * E.g.: There are multiple cities with the name "London". For the "most famous" London,
     * we need to use the one in Great Britain which has cityId 2643743 as per openweathermap.org.
     *
     * @param cityId
     * @return WeatherDto
     *
     */
    WeatherDto getWeatherForCity(Integer cityId);


}
