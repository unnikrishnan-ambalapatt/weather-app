package com.weather.weatherapp.dto.openweather;

/**
 * Class to hold weather description retrieved from openweathermap.org.
 * All the variables are named as per what is returned by the API.
 */
public class WeatherDesc {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
