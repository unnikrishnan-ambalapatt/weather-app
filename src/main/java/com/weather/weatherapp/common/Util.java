package com.weather.weatherapp.common;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Utility class that provides reusable methods.
 */
public class Util {

    public enum DateTime {
        DATE,
        TIME
    }

    public static String getReadableDateOrTime(long epoch, DateTime dateTime) {
        String pattern = "";
        if(dateTime.equals(DateTime.DATE)) {
            pattern = "MMMM d, yyyy";
        } else if(dateTime.equals(DateTime.TIME)) {
            pattern = "h:mm a";
        }
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(epoch, 0, ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
        return localDateTime.format(formatter);
    }

    /**
     * Utility method to convert temperature in Celsius to Fahrenheit.
     * @param tempInCelsius
     * @return temperature in Fahrenheit
     */
    public static double convertCelsiusToFahrenheit(double tempInCelsius) {
        /*
        Convert from Celsius to Fahrenheit using the formula: (x°C × 9/5) + 32 = y°F
        Round the result to 2 decimal places.
         */
        return (double) Math.round(((tempInCelsius * 9/5) + 32) * 100) / 100;
    }
}
