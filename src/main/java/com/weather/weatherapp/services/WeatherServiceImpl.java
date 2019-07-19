package com.weather.weatherapp.services;

import com.weather.weatherapp.common.Util;
import com.weather.weatherapp.dto.openweather.OpenWeatherDto;
import com.weather.weatherapp.dto.WeatherDto;
import com.weather.weatherapp.dto.openweather.WeatherDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}")
    private String apiUrl;

    @Value("${api.key}")
    private String apiKey;

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
    @Override
    public WeatherDto getWeatherForCity(Integer cityId) {

        /**
         * Get the real weather data from service provided by openweathermap.org.
        * */
        OpenWeatherDto openWeatherDto = restTemplate.getForObject(apiUrl
                        + "?id=" + cityId + "&units=metric&appid=" + apiKey, OpenWeatherDto.class);

        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setCity(openWeatherDto.getName());

        /**
         * Timezone used below gives the number of seconds offset (+ or -) from UTC. Add it to epoch to get local date/time.
         */
        weatherDto.setDate(Util.getReadableDateOrTime(
                openWeatherDto.getDt() + openWeatherDto.getTimezone(), Util.DateTime.DATE));
        weatherDto.setSunRiseTime(Util.getReadableDateOrTime(
                openWeatherDto.getSys().getSunrise() + openWeatherDto.getTimezone(), Util.DateTime.TIME));
        weatherDto.setSunSetTime(Util.getReadableDateOrTime(
                openWeatherDto.getSys().getSunset() + openWeatherDto.getTimezone(), Util.DateTime.TIME));
        weatherDto.setTempCelsius(openWeatherDto.getMain().getTemp());

        /**
         * While there is an API parameter, provided by OpenWeather, to get the temperature in Fahrenheit,
         * it will involve another call to their server. Let's avoid the extra round-trip
         * by converting Celsius to Fahrenheit from within our application.
         */
        weatherDto.setTempFahrenheit(Util.convertCelsiusToFahrenheit(openWeatherDto.getMain().getTemp()));

        /**
         * The main weatherDto object returned by the service is not a single object but an array of weatherDto objects,
         * each of which denote different weather conditions like drizzle, rain, snow, clouds etc. Since one or more
         * of these could happen in simultaneously, let's collect and format all of them.
         * */
        String weatherDescFull = "";
        for(WeatherDesc weatherDesc : openWeatherDto.getWeather()) {
            if("".equals(weatherDescFull)) {
                weatherDescFull = weatherDesc.getDescription();
            } else {
                weatherDescFull = weatherDescFull + ", " + weatherDesc.getDescription();
            }
        }
        /*Convert to initcap since returned string is in full lower case.*/
        weatherDto.setWeatherDesc(weatherDescFull.substring(0, 1).toUpperCase() + weatherDescFull.substring(1));
        return weatherDto;
    }
}
