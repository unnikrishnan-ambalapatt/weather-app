package com.weather.weatherapp.controller;

import com.weather.weatherapp.dto.WeatherDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Testing using TestRestTemplate for basic scenarios calling the local endpoint.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {
        "relative.path=/weather/city/",
})
public class WeatherControllerTest {

    @Value("${relative.path}")
    private String path;

    @Autowired
    private TestRestTemplate testRestTemplate;

    /**
     * Test the service call for London. We pass in the city id for London and check the returned values.
     */
    @Test
    public void getWeatherForCity_London() throws Exception {
        path = path + "2643743";
        WeatherDto weatherDto = testRestTemplate.postForObject(path, null, WeatherDto.class);
        Assert.assertEquals("London", weatherDto.getCity());
        commonChecks(weatherDto);
    }

    /**
     * Test the service call for Hong Kong. We pass in the city id for Hong Kong and check the returned values.
     */
    @Test
    public void getWeatherForCity_HongKong() throws Exception {
        path = path + "1819729";
        WeatherDto weatherDto = testRestTemplate.postForObject(path, null, WeatherDto.class);
        Assert.assertEquals("Hong Kong", weatherDto.getCity());
        commonChecks(weatherDto);
    }

    /**
     * Few common tests across all the locations.
     */
    private void commonChecks(WeatherDto weatherDto) {
        Assert.assertNotNull("Temperature in Celsius", weatherDto.getTempCelsius());
        Assert.assertNotNull("Temperature in Fahrenheit", weatherDto.getTempFahrenheit());
        Assert.assertTrue(weatherDto.getSunRiseTime().endsWith("AM"));
        Assert.assertTrue(weatherDto.getSunSetTime().endsWith("PM"));
    }
}