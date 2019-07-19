package com.weather.weatherapp;

import com.weather.weatherapp.exceptions.RemoteCallErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WeatherAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(WeatherAppApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplateBuilder().errorHandler(new RemoteCallErrorHandler()).build();
	}

}
