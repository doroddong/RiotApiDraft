package org.cnu.realcoding.weathercrawler.controller;

import org.cnu.realcoding.weathercrawler.domain.CurrentWeather;
import org.cnu.realcoding.weathercrawler.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * 아래와 같이 Controller 클래스에 @RequestMapping 을 붙이면
 * 아래 Controller 클래스에서 제공되는 Endpoints(API) 들의 기본 URI 가 다음과 같이 매핑된다.
 * http://localhost:8080/weather-crawler
 */
@RestController
@RequestMapping("/RiotGamesApi")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/available-summnorName")
    public List<String> getAvailableCityNames() throws IOException {
        return weatherService.getAvailableCityNames();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/current-summnor/by-summnors-name/{summnorName}")
    public CurrentWeather getCurrentWeatherByCityName(@PathVariable String cityName) {
        return weatherService.getCurrentWeatherByCityName(cityName);
    }
}
