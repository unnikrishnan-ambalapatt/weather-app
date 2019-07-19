package com.weather.weatherapp.dto.openweather;

/**
 * This class holds data retrieved from openweathermap.org.
 * All the variables are named as per what is returned by the API call.
 */

public class OpenWeatherDto {

    private WeatherDesc[] weather;
    private String name;
    private long dt;
    private long timezone;
    private Temperature main;
    private Sun sys;

    public WeatherDesc[] getWeather() {
        return weather;
    }

    public void setWeather(WeatherDesc[] weather) {
        this.weather = weather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public long getTimezone() {
        return timezone;
    }

    public void setTimezone(long timezone) {
        this.timezone = timezone;
    }

    public Temperature getMain() {
        return main;
    }

    public void setMain(Temperature main) {
        this.main = main;
    }

    public Sun getSys() {
        return sys;
    }

    public void setSys(Sun sys) {
        this.sys = sys;
    }
}


