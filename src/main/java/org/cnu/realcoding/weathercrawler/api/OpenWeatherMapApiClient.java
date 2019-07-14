package org.cnu.realcoding.weathercrawler.api;

import org.cnu.realcoding.weathercrawler.domain.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherMapApiClient {
    @Autowired
    private RestTemplate restTemplate;

    private final String apiKey = "RGAPI-42869508-4b86-4ca9-bf29-1593edc4a796";
    private final String currentWeatherUri = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{cityName}?api_key={apiKey}";

    public CurrentWeather getCurrentWeather(String cityName) {
        CurrentWeather currentWeather = restTemplate.exchange(currentWeatherUri, HttpMethod.GET, null, CurrentWeather.class, cityName, apiKey)
                .getBody();
        return currentWeather;
    }
}