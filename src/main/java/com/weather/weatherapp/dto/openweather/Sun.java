package com.weather.weatherapp.dto.openweather;

/**
 * Class to hold sunrise and sunset timings retrieved from openweathermap.org.
 * All the variables are named as per what is returned by the API call.
 */
public class Sun {

    private long sunrise;
    private long sunset;

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }
}

