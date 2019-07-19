package com.weather.weatherapp.dto.openweather;

/**
 * Class to hold temperature data retrieved from openweathermap.org.
 * All the variables are named as per what is returned by the API.
 */
public class Temperature {

    private double temp;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}
