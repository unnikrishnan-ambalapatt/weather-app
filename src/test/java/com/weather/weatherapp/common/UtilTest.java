package com.weather.weatherapp.common;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilTest {

    /**
     * Test epoch value in the past to convert to readable date.
     */
    @Test
    public void getReadableDateOrTime_PastDate() {
        assertEquals("Date", "July 15, 2019",
                Util.getReadableDateOrTime(1563153325, Util.DateTime.DATE));
    }

    /**
     * Test epoch value in the past to convert to readable time.
     */
    @Test
    public void getReadableDateOrTime_PastTime() {
        assertEquals("Time", "1:15 AM",
                Util.getReadableDateOrTime(1563153325, Util.DateTime.TIME));
    }

    /**
     * Test epoch value in the future to convert to readable date.
     */
    @Test
    public void getReadableDateOrTime_FutureDate() {
        assertEquals("Date", "October 15, 2022",
                Util.getReadableDateOrTime(1665836402, Util.DateTime.DATE));
    }

    /**
     * Test epoch value in the future to convert to readable time.
     */
    @Test
    public void getReadableDateOrTime_FutureTime() {
        assertEquals("Time", "12:20 PM",
                Util.getReadableDateOrTime(1665836402, Util.DateTime.TIME));
    }

    /**
     * Test for conversion of zero celsius to Fahrenheit
     */
    @Test
    public void convertCelsiusToFahrenheit_ZeroCelsius() {
        assertEquals(32, Util.convertCelsiusToFahrenheit(0), 0);
    }

    /**
     * Test for conversion of negative celsius to Fahrenheit
     */
    @Test
    public void convertCelsiusToFahrenheit_NegativeCelsius() {
        assertEquals(23, Util.convertCelsiusToFahrenheit(-5), 0);
    }

    /**
     * Test for conversion of bigger negative celsius to Fahrenheit
     */
    @Test
    public void convertCelsiusToFahrenheit_BiggerNegativeCelsius() {
        assertEquals(-148, Util.convertCelsiusToFahrenheit(-100), 0);
    }

    /**
     * Test for conversion of positive celsius to Fahrenheit
     */
    @Test
    public void convertCelsiusToFahrenheit_PositiveCelsius() {
        assertEquals(95, Util.convertCelsiusToFahrenheit(35), 0);
    }

    /**
     * Test for conversion of bigger positive celsius to Fahrenheit
     */
    @Test
    public void convertCelsiusToFahrenheit_BiggerPositiveCelsius() {
        assertEquals(212, Util.convertCelsiusToFahrenheit(100), 0);
    }

    /**
     * Test for conversion of medium negative celsius to Fahrenheit
     */
    @Test
    public void convertCelsiusToFahrenheit_MediumNegativeCelsius() {
        assertEquals(-58, Util.convertCelsiusToFahrenheit(-50), 0);
    }

    /**
     * Test for conversion of medium positive celsius to Fahrenheit
     */
    @Test
    public void convertCelsiusToFahrenheit_MediumPositiveCelsius() {
        assertEquals(136.4, Util.convertCelsiusToFahrenheit(58), 0);
    }
}